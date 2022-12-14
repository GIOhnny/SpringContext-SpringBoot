package ro.giohnnysoftware.springbootlesson10.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class HelloController {

    @PostMapping(path = "/test/{name}")
    public String test(@PathVariable String name,
                       @RequestHeader String a,
                       @RequestHeader String b,
                       @RequestHeader String c,
                       @RequestBody String body,
                       HttpServletResponse response) {
        response.addHeader("test","good");
        return a+ " / " + b + " / " + c+ " / "+name + " / "+ body;
    }

    @GetMapping(path = "/all")
    public Map<String, String> all (@RequestHeader Map<String,String> map) {
        return map;
    }

    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file() {
        byte[] file = new byte[100];
        return file;
    }
}
