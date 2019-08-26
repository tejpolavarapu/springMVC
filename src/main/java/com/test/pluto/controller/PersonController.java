package com.test.pluto.controller;

import com.google.gson.Gson;
import com.test.pluto.beans.dao.Person;
import com.test.pluto.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.test.pluto.constants.Constants.HELLO_MESSAGE;

@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    private Gson gson = new Gson();


    @RequestMapping(path="/sayhello", method = RequestMethod.GET)
    public @ResponseBody String printHello(ModelMap model) {
        model.addAttribute("message", HELLO_MESSAGE);
        return "hello";
    }

    @RequestMapping(path="/getallpersons", method = RequestMethod.GET)
    @ResponseBody
    public String getPerson() {

        String personList = null;
        try{
            personList = gson.toJson(personService.getAllPersons());
        } catch (Exception e){
            e.printStackTrace();
        }
        return personList;
    }

}
