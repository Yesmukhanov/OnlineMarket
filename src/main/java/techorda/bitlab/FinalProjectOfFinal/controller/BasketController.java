package techorda.bitlab.FinalProjectOfFinal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/basket")
    public String basketPage(){
        return "basketPage";
    }
}
