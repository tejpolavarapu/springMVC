package com.test.pluto.controller;

import com.google.gson.Gson;
import com.test.pluto.beans.dao.DatabaseSequence;
import com.test.pluto.beans.dao.Person;
import com.test.pluto.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.test.pluto.constants.Constants.HELLO_MESSAGE;
import static org.springframework.data.mongodb.core.FindAndReplaceOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RequestMapping("/person")
@Controller
@Service
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private MongoOperations mongoOperation;


    private Gson gson = new Gson();


    //greeting message
    // URL-pattern :  http://localhost:9090/person/sayhello
    @RequestMapping(path = "/sayhello", method = RequestMethod.GET)
    public @ResponseBody
    String printHello(ModelMap model) {
        //TODO Read about what "model.addAttribute()" do?
        //model.addAttribute("message", HELLO_MESSAGE);
        return HELLO_MESSAGE;
    }

    //get all persons available in the mongo db
    // URL-pattern :  http://localhost:9090/person/getallpersons
    @RequestMapping(path = "/getallpersons", method = RequestMethod.GET)
    @ResponseBody
    public String getPerson() {

        String personList = null;
        try {
            personList="All documents available in person DB \n";
            personList = gson.toJson(personService.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }


    //get person details by id using path variable
    // URL-pattern :  http://localhost:9090/person/getperson/{id}
    @RequestMapping(value = "/getperson/{personId}", method= RequestMethod.GET)
    @ResponseBody
    private String getPersonDetailsById(@PathVariable("personId") String perId){
        System.out.println("personId is - "+ perId);
        String personList = null;
        try {
            personList="Get person by ID using PathVariable - \n";
            personList = gson.toJson(personService.getPersonById(perId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;

    }


    //get person details by id using request param
    // URL-pattern :  http://localhost:9090/person/getpersonparam?id={id}
    @RequestMapping(value = "/getpersonparam", method= RequestMethod.GET)
    @ResponseBody
    public String getPersonDetails(@RequestParam(value = "id", required=true) String perId){

        System.out.println("personId is - "+ perId);
        String personList = null;
        try {
            personList="Get person by ID using RequestParam - \n";
            personList = gson.toJson(personService.getPersonById(perId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;

    }


    //insert a new person into db
    //URL-pattern :  http://localhost:9090/person/insert?fname={fname}&lname={lname}
    @RequestMapping(value = "/insert", method= RequestMethod.GET)
    @ResponseBody
    public String insertPerson(@RequestParam(value = "id", required=true) long id, @RequestParam(value = "fname", required=true) String firstName, @RequestParam(value = "lname", required=true) String lastName){

        Person person=new Person();

        String personList=null;
        //TODO replace the id with generateSequence
        person.setPersonId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);


        mongoOperation.insert(person);
        personList="Created person - "+firstName+" "+lastName;
        return personList;

    }



    /*
    //TODO auto increment id - reference : https://www.baeldung.com/spring-boot-mongodb-auto-generated-field

    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperation.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }



    */


}
