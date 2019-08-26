package com.test.pluto.dao;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.test.pluto.beans.dao.Person;
import org.bson.Document;


import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Scope("prototype")
@Repository
public class PersonDAO {

    @Autowired
    private MongoOperations mongoOperation;

    public List<Person> getAllPersons() {

        List<Person> persons = null;

        try{
            persons = mongoOperation.findAll(Person.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        // Creates a new instance of MongoDBClient and connect to localhost
        // port 27017.
//        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//
//        MongoDatabase database = mongoClient.getDatabase("person");
//
//        MongoCollection<Document> collection = database.getCollection("PERSON_DATA");
//
//        String values;
//        Block<Document> printBlock = new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                System.out.println(document.toJson());
//            }
//        };
//
//        collection.find().forEach(printBlock);
//
//        Document myDoc = collection.find().first();
//        values = myDoc.toJson();
        return persons;
    }
}