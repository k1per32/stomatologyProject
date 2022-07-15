package com.yuriy.demotest2.dao;


import com.yuriy.demotest2.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
//    public List<Patient> getAllPatient();
//
//    public void savePatient(Patient patient);
//
//    public Patient getPatient(int id);
//
//    public void deletePatient(int id);

