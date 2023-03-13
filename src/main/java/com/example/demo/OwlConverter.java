package com.example.demo;

import com.example.demo.entities.*;
import lombok.Getter;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Getter
@Transactional(readOnly = true)
public class OwlConverter {

    private String nameSpace;
    private OntModel ontModel;
    private EntityManager entityManager;


    private Map<Classes, OntClass> classesMap = new HashMap<>();
    private Map<ObjectProperties, ObjectProperty> objectPropertiesMap = new HashMap<>();
    private Map<Individuals, Individual> individualMap = new HashMap<>();

    public OwlConverter(String nameSpace, OntModel ontModel, EntityManager entityManager) {
        this.nameSpace = nameSpace;
        this.ontModel = ontModel;
        this.entityManager = entityManager;
    }


    @Transactional
    public void addClasses () {
        for (Classes classes : entityManager.createQuery(
                "select o from Classes o", Classes.class).getResultList()) {
            classesMap.put(classes, ontModel.createClass(nameSpace + classes.getTitle()));
        }

        for (Classes classes : classesMap.keySet()) {
            for (DisjointClassesLink disjointClassesLink : classes.getDisjointClassesLinksByClassId()) {
                classesMap.get(classes)
                        .addDisjointWith(classesMap.get(disjointClassesLink
                                .getClassesByDisjointClassId()));
            }
        }

        for (Classes classes : classesMap.keySet()) {
            for (SubClassesLink subClassesLink : classes.getSubClassesLinksByClassId()) {
                classesMap.get(classes)
                        .addSubClass(classesMap.get(subClassesLink
                                .getClassesBySubClassId()));
            }
        }
    }
    @Transactional
    public void addObjectProperties () {

        for (ObjectProperties objectProperties : entityManager.createQuery(
                "select o from ObjectProperties o", ObjectProperties.class).getResultList()) {
            objectPropertiesMap.put(objectProperties, ontModel.createObjectProperty(nameSpace + objectProperties.getTitle()));

            if (objectProperties.getFunctional()) objectPropertiesMap.get(objectProperties).convertToFunctionalProperty();
//            if (objectProperties.getIrreflexive()) objectPropertiesMap.get(objectProperties).();
//            if (objectProperties.getReflexive()) objectPropertiesMap.get(objectProperties).();
            if (objectProperties.getInvFunctional()) objectPropertiesMap.get(objectProperties).convertToInverseFunctionalProperty();
            if (objectProperties.getTransitive()) objectPropertiesMap.get(objectProperties).convertToTransitiveProperty();
            if (objectProperties.getSym()) objectPropertiesMap.get(objectProperties).convertToSymmetricProperty();
//            if (objectProperties.getAsym()) objectPropertiesMap.get(objectProperties).();
        }

        for (ObjectProperties objectProperties : objectPropertiesMap.keySet()) {
            for (DisjointObjPropLink disjointObjPropLinks : objectProperties.getDisjointObjPropLinksByObjPropId()) {
                objectPropertiesMap.get(objectProperties)
                        .addIsDefinedBy(objectPropertiesMap.get(disjointObjPropLinks
                                .getObjectPropertiesByDisjointObjPropId()));
            }
        }

        for (ObjectProperties objectProperties : objectPropertiesMap.keySet()) {
            for (SubObjPropLink objPropLink : objectProperties.getSubObjPropLinksByObjPropId()) {
                objectPropertiesMap.get(objectProperties)
                        .addSubProperty(objectPropertiesMap.get(objPropLink
                                .getObjectPropertiesByObjPropId()));
            }
        }

        for (ObjectProperties objectProperties : objectPropertiesMap.keySet()) {
            for (DomainsObjPropLink domainsObjPropLink : objectProperties.getDomainsObjPropLinksByObjPropId()) {
                objectPropertiesMap.get(objectProperties)
                        .addDomain(classesMap.get(domainsObjPropLink
                                .getClassesByDomainsClassId()));
            }
        }

        for (ObjectProperties objectProperties : objectPropertiesMap.keySet()) {
            for (RangesObjPropLink rangesObjPropLink : objectProperties.getRangesObjPropLinksByObjPropId()) {
                objectPropertiesMap.get(objectProperties)
                        .addRange(classesMap.get(rangesObjPropLink
                                .getClassesByRangesClassId()));
            }
        }

        for (ObjectProperties objectProperties : objectPropertiesMap.keySet()) {
            for (InverseObjPropLink inverseObjPropLink : objectProperties.getInverseObjPropLinksByObjPropId()) {
                objectPropertiesMap.get(objectProperties)
                        .addInverseOf(objectPropertiesMap.get(inverseObjPropLink
                                .getObjectPropertiesByInverseObjPropId()));
            }
        }

    }
    @Transactional
    public void addIndividuals() {
        for (Individuals individuals :  entityManager.createQuery(
                "select o from Individuals o", Individuals.class).getResultList()) {
            for (IndividualsTypesLink individualsTypesLink : individuals.getIndividualsTypesLinksByIndividualsId()) {
                individualMap.put(individuals,
                        ontModel.createIndividual(nameSpace + individuals.getTitle(),
                                classesMap.get(individualsTypesLink.getClassesByTypesClassId())));
            }
        }

        for (Individuals individuals : individualMap.keySet()) {
            for (Link link : individuals.getLinksByIndividualsId()) {
                individualMap.get(link.getIndividualsBySubjectId()).addProperty(
                        objectPropertiesMap.get(link.getObjectPropertiesByPredicateId()),
                        individualMap.get(link.getIndividualsByObjectId())
                );
            }
        }

    }


    public void save (String path) {
        try {
            OutputStream outputStream = new FileOutputStream(path);
            ontModel.write(outputStream, "RDF/XML-ABBREV");
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
