package com.project.visioncare.controllers.view;

import com.project.visioncare.services.ProductService;
import com.project.visioncare.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class CheckoutViewController {

    @Autowired
    UniversityService universityService;

    @Autowired
    ProductService productService;


    @GetMapping("/finalizarcompra")
    public String checkoutPage(@RequestParam(required = false) UUID productId, Model model) {
        model.addAttribute("universities", universityService.listAllForFront());

        // Só busca se realmente tiver produto
        if (productId != null) {
            try {
                model.addAttribute("product", productService.getById(productId));
            } catch (Exception e) {
                System.out.println("Produto não encontrado: " + productId);
            }
        }

        return "pages/finalizarcompra";
    }
}
