package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello-language")
    @ResponseBody
    public String helloLanguage(@RequestParam String name, String language) {
        if(language.equals("english")) {
            return "<h1>Hello, " + name + "!</h1>";
        }
        else if(language.equals("spanish")) {
            return "<h1>Hola, " + name + "!</h1>";
        }
        else if(language.equals("french")) {
            return "<h1>Bonjour, " + name + "!</h1>";
        }
        else if(language.equals("russian")) {
            return "<h1>Zdravstvuyte, " + name + "!</h1>";
        }
        else if(language.equals("japanese")) {
            return "<h1>Kon'nichiwa, " + name + "!</h1>";
        }
        else {
            return "<h1>" + name + ", you did not enter another language for me to greet you in :(</h1>";
        }
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("greeting")
    @ResponseBody
    public String languageGreeting() {
        return "<html>" +
                "<body>" +
                "<form action='hello-language' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value=''>--Please choose a Language--</option>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='russian'>Russian</option>" +
                "<option value='japanese'>Japanese</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Matt");
        names.add("Java");
        names.add("Stapler the Destroyer");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
