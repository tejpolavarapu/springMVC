package com.test.pluto.controller;

import com.test.pluto.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.test.pluto.constants.Constants.HELLO_MESSAGE;

@RequestMapping("/person")
@Controller
public class PersonController {
    @RequestMapping(path="/sayhello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", HELLO_MESSAGE);
        return "hello";
    }

    @RequestMapping(path="/getperson", method = RequestMethod.GET)
    public String getPerson(ModelMap model) {

        PersonDAO personDAO = new PersonDAO();
        String values = personDAO.getPerson();
        model.addAttribute("message", values);
        return "hello";
    }

}
