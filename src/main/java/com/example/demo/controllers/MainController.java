package com.example.demo.controllers;

import com.example.demo.repositories.ClassesRepository;
import com.example.demo.repositories.IndividualsRepository;
import com.example.demo.repositories.ObjectPropertiesRepository;
import com.example.demo.services.OwlConverter;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;

@Controller
public class MainController {
    private static final String nameSpace = "http://jena-test#";
    private static final String path = "src/main/resources/owl/ontology_v1.owl";

    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private ObjectPropertiesRepository objectPropertiesRepository;
    @Autowired
    private IndividualsRepository individualsRepository;


    @GetMapping("/index")
    public String doSomething() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Model model = ModelFactory.createDefaultModel();
        OntModel ontModel = ModelFactory.createOntologyModel(OWL_MEM, model);

        OwlConverter owlConverter = new OwlConverter(nameSpace, ontModel);

        owlConverter.addClasses(classesRepository);
        owlConverter.addObjectProperties(objectPropertiesRepository);
        owlConverter.addIndividuals(individualsRepository);



        owlConverter.save(path);

        return "index";
    }


}
