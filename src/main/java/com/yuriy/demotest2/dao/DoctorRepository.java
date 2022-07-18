package com.yuriy.demotest2.dao;

import com.yuriy.demotest2.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    Doctor getDoctorById(int id);

    boolean findDoctorByIdIsNotNull();

}
