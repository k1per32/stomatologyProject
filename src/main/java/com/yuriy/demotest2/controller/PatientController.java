package com.yuriy.demotest2.controller;

import com.yuriy.demotest2.dao.PatientRepository;
import com.yuriy.demotest2.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")

public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient/show")
    public String showUserList(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "show-patient";
    }


    @GetMapping("/patient/add")
    public String addUser(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "add-patient";
    }

    @PostMapping("/patient/created")
    public String createdPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "added-patient";
    }

    @PostMapping("/patient/updated/{id}")
    public String updatedPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "updated-patient";
    }


    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        patientRepository.delete(patient);
        return "delete-patient";
    }
}
