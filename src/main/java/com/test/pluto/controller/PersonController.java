package com.test.pluto.controller;

import com.google.gson.Gson;
import com.test.pluto.beans.dao.Person;
import com.test.pluto.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.test.pluto.constants.Constants.HELLO_MESSAGE;

@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    private Gson gson = new Gson();


    @RequestMapping(path = "/sayhello", method = RequestMethod.GET)
    public @ResponseBody
    String printHello(ModelMap model) {
        //TODO Read about what "model.addAttribute()" do?
        //model.addAttribute("message", HELLO_MESSAGE);
        return HELLO_MESSAGE;
    }

    @RequestMapping(path = "/getallpersons", method = RequestMethod.GET)
    @ResponseBody
    public String getPerson() {

        String personList = null;
        try {
            personList = gson.toJson(personService.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }

    @RequestMapping(value = " /getperson/{personId}", method= RequestMethod.GET)
    private Person getPersonDetailsById(@PathVariable String personId){
        Person person=new Person();

        return person;
    }

}
