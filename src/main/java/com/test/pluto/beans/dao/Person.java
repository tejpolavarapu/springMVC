package com.test.pluto.beans.dao;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PERSON_DATA")
public class Person{


    @Transient
    public static final String SEQUENCE_NAME = "person_sequence";

    @Id
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
