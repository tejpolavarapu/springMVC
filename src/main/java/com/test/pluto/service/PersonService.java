package com.test.pluto.service;

import com.test.pluto.beans.dao.Person;
import com.test.pluto.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public List<Person> getAllPersons(){
        List<Person> persons = null;
        try{
            persons = this.personDAO.getAllPersons();


        } catch (Exception e){
            e.printStackTrace();
        }
        return persons;
    }

    public Person getPersonById(String ID){
        int id=Integer.parseInt(ID);
        List<Person> personList=getAllPersons();
        Person person=new Person();

        for(Person p : personList) {
            if(p.getPersonId()==id){
                person=p;
            }
        }

        return person;
    }
}
