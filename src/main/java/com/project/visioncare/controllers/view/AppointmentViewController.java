package com.project.visioncare.controllers.view;

import com.project.visioncare.dtos.AppointmentRecordDto;
import com.project.visioncare.services.appointment.AppointmentService;
import com.project.visioncare.services.UniversityService;
import com.project.visioncare.services.appointment.AppointmentServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AppointmentViewController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UniversityService universityService;

    @Autowired
    private AppointmentServiceProxy appointmentServiceProxy;

    @GetMapping("/agendarconsulta")
    public String appointment(Model model) {

        model.addAttribute("universities", universityService.listAllForFront());
        return "pages/agendarconsulta";
    }

    @PostMapping("/agendarconsulta")
    @ResponseBody
    public Map<String, Object> scheduleAppointment(@ModelAttribute AppointmentRecordDto appointmentRecordDto) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Usando o Proxy para delegar a chamada ao serviço real
            appointmentServiceProxy.create(appointmentRecordDto, universityService);

            response.put("success", true);
            response.put("message", "Consulta agendada com sucesso!");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao agendar consulta.");
        }

        return response;
    }
}
