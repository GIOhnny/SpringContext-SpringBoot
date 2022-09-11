package ro.giohnnysoftware.springbootlesson9.controllers;

import org.springframework.web.bind.annotation.*;
import ro.giohnnysoftware.springbootlesson9.dto.Person;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    //@RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    @GetMapping(path = "/hello/{name}")
    // http://localhost:8080/hello/GIO
    public String hello(@PathVariable("name") String name) {
        return "Hello, "+name+"!";
    }

    @PostMapping("/goodbye")
    // http://localhost:8080/goodbye
    public String goodbye(@RequestBody Person p) {
        return "Goodbye, " + p.getName() + "!";
    }

    @GetMapping(path = "/getPerson")
    public Person getPerson() {
        Person p = new Person();
        p.setName("George");
        return  p;
    }

    @GetMapping(path = "/getAll")
    public List<Person> getAllPersons() {
        Person p = new Person();
        p.setName("George");
        Person p2 = new Person();
        p2.setName("John");

        return Arrays.asList(p, p2);
    }

    @GetMapping(path = "/statustest")
    public void statusTest(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
