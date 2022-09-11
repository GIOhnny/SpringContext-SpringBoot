package ro.giohnnysoftware.springlesson14webscopes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.giohnnysoftware.springlesson14webscopes.services.NumberService;
import ro.giohnnysoftware.springlesson14webscopes.services.RandomNumberService;

@Controller
public class IndexController {

    @Autowired
    //private RandomNumberService numberService; //proxy
    private NumberService numberService; //proxy

    @GetMapping("/home")
    public String indexAction(Model model) {
        model.addAttribute("message",numberService.getValue());
        return "index.html";
    }
}
