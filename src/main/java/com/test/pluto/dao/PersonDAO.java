package com.test.pluto.dao;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import com.mongodb.MongoClient;






public class PersonDAO {
    //public static void main(String[] args) {
    public String getPerson() {
        // Creates a new instance of MongoDBClient and connect to localhost
        // port 27017.
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoDatabase database = mongoClient.getDatabase("person");

        MongoCollection<Document> collection = database.getCollection("PERSON_DATA");

        String values;
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };

        collection.find().forEach(printBlock);

        Document myDoc = collection.find().first();
        values = myDoc.toJson();
        return values;
    }


    /*public  void operations(MongoClient mongoClient) throws Exception {

        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(mongoClient, "person") {
            @Override
            public MongoDatabase getDb() throws DataAccessException {
                return null;
            }

            @Override
            public MongoDatabase getDb(String s) throws DataAccessException {
                return null;
            }

            @Override
            public PersistenceExceptionTranslator getExceptionTranslator() {
                return null;
            }

            @Override
            public DB getLegacyDb() {
                return null;
            }

            @Override
            public ClientSession getSession(ClientSessionOptions clientSessionOptions) {
                return null;
            }

            @Override
            public MongoDbFactory withSession(ClientSession clientSession) {
                return null;
            }
        });



        Person p = new Person("Aaron", "Smith");

        // Insert is used to initially store the object into the database.
        mongoOps.insert(p);
        System.out.println(mongoOps);

        // Find
        p = mongoOps.findById(p.getPersonId(), Person.class);

        // Update
        mongoOps.updateFirst(query(where("first_name").is("Aaron")), update("last_name", "Khole"), Person.class);
        p = mongoOps.findOne(query(where("first_name").is("Aaron")), Person.class);

        // Delete
        mongoOps.remove(p);

        // Check that deletion worked
        List<Person> people =  mongoOps.findAll(Person.class);
        mongoOps.dropCollection(Person.class);
    }*/
}