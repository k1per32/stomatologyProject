package com.yuriy.demotest2.entity;


import lombok.Data;

import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;//отчество

    @Column(name = "history_of_receipt")
    private String historyOfReceipt;

    @Column(name = "date_of_birth")
    @DateTimeFormat
    private String dateOfBirth;

    public Patient() {
    }

    public Patient(String name, String surname, String patronymic, String historyOfReceipt, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.historyOfReceipt = historyOfReceipt;
        this.dateOfBirth = dateOfBirth;
    }

}
