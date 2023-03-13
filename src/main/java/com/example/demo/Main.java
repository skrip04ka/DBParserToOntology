package com.example.demo;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;

public class Main {

    private static final String nameSpace = "http://jena-test#";
    private static final String path = "src/main/resources/owl/ontology_v1.owl";


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Model model = ModelFactory.createDefaultModel();
        OntModel ontModel = ModelFactory.createOntologyModel(OWL_MEM, model);

        OwlConverter owlConverter = new OwlConverter(nameSpace, ontModel, entityManager);

        owlConverter.addClasses();
        owlConverter.addObjectProperties();
        owlConverter.addIndividuals();

        owlConverter.save(path);


    }
}
