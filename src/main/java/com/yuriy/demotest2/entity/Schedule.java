package com.yuriy.demotest2.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "date_time_of_receipt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dateTimeOfReceipt;

    @Column(name = "information_about_receipt")
    private String informationAboutReceipt;//инфо о приеме

}
