package ro.giohnnysoftware.springbootlesson8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
/** va scrie in body ul paginii web ce este in return altfel ar cauta
 * o pagina web statica Hello.html
 */
@ResponseBody
// @Controller + @ResponseBody = @RestController

public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
