package com.test.pluto.beans.dao;


public class Person{


    /*protected String getDatabaseName() {
        return "test";
    }

    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    protected String getMappingBasePackage() {
        return "com.test";
    }*/


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private long personId;
    private String firstName;
    private String lastName;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                '}';
    }
}
