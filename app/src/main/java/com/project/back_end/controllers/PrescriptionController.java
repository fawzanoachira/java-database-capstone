package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.AppointmentService;
import com.project.back_end.services.PrescriptionService;
import com.project.back_end.services.ClinicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController // 1. REST controller for JSON API
@RequestMapping("${api.path}prescription") // e.g. /api/prescription
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final AppointmentService appointmentService;
    private final ClinicService service;

    // 2. Constructor injection
    public PrescriptionController(PrescriptionService prescriptionService,
                                  AppointmentService appointmentService,
                                  ClinicService service) {
        this.prescriptionService = prescriptionService;
        this.appointmentService = appointmentService;
        this.service = service;
    }

    // 3. Save prescription for an appointment
    @PostMapping("/save/{token}")
    public ResponseEntity<Map<String, String>> savePrescription(
            @Valid @RequestBody Prescription prescription, 
            @PathVariable String token) {
        
        Map<String, String> response = new HashMap<>();
        
        if (!service.validateToken(token, "doctor")) {
            response.put("status", "error");
            response.put("message", "Invalid or expired token.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        try {
            // Update appointment status (e.g., to "1" meaning 'Completed')
            appointmentService.changeAppointmentStatus(prescription.getAppointmentId(), 1);

            // Save prescription
            ResponseEntity<?> result = prescriptionService.savePrescription(prescription);
            
            if (result.getStatusCode() == HttpStatus.OK || result.getStatusCode() == HttpStatus.CREATED) {
                response.put("status", "success");
                response.put("message", "Prescription saved successfully.");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                response.put("status", "error");
                response.put("message", "Failed to save prescription.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An error occurred while saving the prescription: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 4. Get prescription by appointment ID
    @GetMapping("/{appointmentId}/{token}")
    public ResponseEntity<?> getPrescription(@PathVariable Long appointmentId, @PathVariable String token) {
        Map<String, String> response = new HashMap<>();
        
        if (!service.validateToken(token, "doctor")) {
            response.put("status", "error");
            response.put("message", "Invalid or expired token.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return prescriptionService.getPrescription(appointmentId);
    }
}