package com.yuriy.demotest2.controller;

import com.yuriy.demotest2.dao.DoctorRepository;
import com.yuriy.demotest2.entity.Doctor;
import com.yuriy.demotest2.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    DoctorRepository doctorRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();
        Session session =null;
        try{
            session = sessionFactory.openSession();
            List<Doctor> doctors = session.createQuery("from Doctor").getResultList();
            model.addAttribute("doctor", doctors);
        }finally {
            session.close();
            sessionFactory.close();
        }
        return "index";
    }

}
