package syksy24.eka_sovellus.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("sayHelloAndAge")
    @ResponseBody
    public String returnGreeting(@RequestParam (name="nimesi", required=false, 
    defaultValue="Tuntematon käyttäjä") String etunimi, @RequestParam int age){
        return "Hei " + etunimi + ", " + age + " vuotta";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(@RequestParam (name="location", required=false,
    defaultValue="Tuntematon sijainti") String location, @RequestParam (name="name", required=false,
    defaultValue="Tuntematon käyttäjä") String name){

        List<String> placesRequiringThe = Arrays.asList("Moon", "Sun", "United States, Netherlands");

        if (placesRequiringThe.contains(location)) {
            location = "the " + location;
        }
        
        return "Welcome to " + location + " " + name + "!";
    }

    @RequestMapping("index")
    @ResponseBody
    public String returnIndexMessage(){
        return "This is the main page";
    }

    @RequestMapping("contact")
    @ResponseBody
    public String returnContactMessage(){
        return "This is the contact page";
    }

}
