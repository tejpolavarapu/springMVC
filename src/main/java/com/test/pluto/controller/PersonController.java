package com.test.pluto.controller;

import com.google.gson.Gson;
import com.test.pluto.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import static com.test.pluto.constants.Constants.HELLO_MESSAGE;

@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


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

}
