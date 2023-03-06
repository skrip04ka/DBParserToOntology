package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repositories.ClassesRepository;
import com.example.demo.repositories.IndividualsRepository;
import com.example.demo.repositories.ObjectPropertiesRepository;
import lombok.Getter;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Getter
public class OwlConverter {

    private String nameSpace;
    private OntModel ontModel;

    private Map<Classes, OntClass> classesMap = new HashMap<>();
    private Map<ObjectProperties, ObjectProperty> objectPropertiesMap = new HashMap<>();
    private Map<Individuals, Individual> individualMap = new HashMap<>();

    public OwlConverter(String nameSpace, OntModel ontModel) {
        this.nameSpace = nameSpace;
        this.ontModel = ontModel;
    }


    public void addClasses (ClassesRepository classesRepository) {

        for (Classes classes : classesRepository.findAll()) {
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

    public void addObjectProperties (ObjectPropertiesRepository objectPropertiesRepository) {

        for (ObjectProperties objectProperties : objectPropertiesRepository.findAll()) {
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

    public void addIndividuals(IndividualsRepository individualsRepository) {
        for (Individuals individuals : individualsRepository.findAll()) {
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
