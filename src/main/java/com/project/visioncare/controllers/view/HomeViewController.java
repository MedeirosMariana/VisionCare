package com.project.visioncare.controllers.view;

import com.project.visioncare.services.ProductService;
import com.project.visioncare.services.ServiceService;
import com.project.visioncare.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UniversityService universityService;

    @GetMapping("/")
    public String getCatalogPage(Model model) {
        model.addAttribute("services", serviceService.listAll());
        model.addAttribute("products", productService.listAll());
        model.addAttribute("universities", universityService.listAllForFront());

        return "index";
    }


}
