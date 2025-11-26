package com.project.visioncare.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactViewController {

    @GetMapping("/contato")
    public String contato() { return "pages/contato"; }

}
