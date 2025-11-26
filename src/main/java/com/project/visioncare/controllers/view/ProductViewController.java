package com.project.visioncare.controllers.view;

import com.project.visioncare.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductViewController {
    @Autowired
    private ProductService productService;

    @GetMapping("/produtos")
    public String getCatalogPage(Model model) {
        model.addAttribute("products", productService.listAll());
        return "pages/produtos";
    }
}
