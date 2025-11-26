package com.project.visioncare.controllers.view;

import com.project.visioncare.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutViewController {

    @Autowired
    UniversityService universityService;

    @GetMapping("/finalizarcompra")
    public String appointment(Model model) {
        model.addAttribute("universities", universityService.listAllForFront());

        return "pages/finalizarcompra";
    }
}
