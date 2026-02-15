package com.project.back_end.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Appointment {

    // Primary key for Appointment entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Doctor associated with the appointment
    @ManyToOne
    @NotNull(message = "Doctor must be provided")
    private Doctor doctor;

    // Patient associated with the appointment
    @ManyToOne
    @NotNull(message = "Patient must be provided")
    private Patient patient;

    // Date and time of the appointment
    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointmentTime;

    // 0 = Scheduled, 1 = Completed
    @NotNull(message = "Appointment status must be provided")
    private Integer status;

    // No-argument constructor (required by JPA)
    public Appointment() {
    }

    // Optional parameterized constructor
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentTime, Integer status) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Transient method to calculate appointment end time
    @Transient
    public LocalDateTime getEndTime() {
        return appointmentTime.plusHours(1);
    }

    // Extracts only the date part of the appointment
    @Transient
    public LocalDate getAppointmentDate() {
        return appointmentTime.toLocalDate();
    }

    // Extracts only the time part of the appointment
    @Transient
    public LocalTime getAppointmentTimeOnly() {
        return appointmentTime.toLocalTime();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
