package com.project.visioncare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String initialPage() {
        return "/index";
    }

    @RequestMapping("/produtos")
    public String produtosPage() {
        return "pages/produtos";
    }

    @RequestMapping("/contato")
    public String contactPage() {
        return "/pages/contato";
    }

    @RequestMapping("/agendarconsulta")
    public String schenduleAppointmentPage() {
        return "/pages/agendarconsulta";
    }

    @RequestMapping("/finalizarcompra")
    public String checkoutPage() {
        return "/pages/finalizarcompra";
    }

}