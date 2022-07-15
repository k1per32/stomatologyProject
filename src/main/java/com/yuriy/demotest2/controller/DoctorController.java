package com.yuriy.demotest2.controller;

import com.yuriy.demotest2.dao.DoctorRepository;
import com.yuriy.demotest2.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Controller
@RequestMapping("/")

public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/doctor/show")
    public String showUserList(Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        return "show-doctor";
    }


    @GetMapping("/doctor/add")
    public String addUser(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "add-doctor";
    }

    @PostMapping("/doctor/created")
    public String createdDoctor(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "added-doctor";
    }

    @PostMapping("/doctor/updated/{id}")
    public String updatedDoctor(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "updated-doctor";
    }


    @GetMapping("/doctor/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("doctor", doctor);
        return "update-doctor";
    }

    @GetMapping("/doctor/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        doctorRepository.delete(doctor);
        return "delete-doctor";
    }
}
