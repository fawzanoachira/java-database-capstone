# Smart Clinic Management System – Schema Design

## MySQL Database Design

### Table: patients
- id: INT, Primary Key, Auto Increment
- first_name: VARCHAR(100), Not Null
- last_name: VARCHAR(100), Not Null
- email: VARCHAR(150), Unique, Not Null
- phone: VARCHAR(20), Not Null
- date_of_birth: DATE
- created_at: DATETIME, Default CURRENT_TIMESTAMP

**Design Decision:**  
Patients are core entities. Email is unique to avoid duplicate registrations.

---

### Table: doctors
- id: INT, Primary Key, Auto Increment
- first_name: VARCHAR(100), Not Null
- last_name: VARCHAR(100), Not Null
- email: VARCHAR(150), Unique, Not Null
- phone: VARCHAR(20), Not Null
- specialization: VARCHAR(100), Not Null
- license_number: VARCHAR(50), Unique, Not Null
- experience_years: INT
- created_at: DATETIME, Default CURRENT_TIMESTAMP

**Design Decision:**  
License number uniquely identifies a doctor.

---

### Table: appointments
- id: INT, Primary Key, Auto Increment
- patient_id: INT, Foreign Key → patients(id)
- doctor_id: INT, Foreign Key → doctors(id)
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)
- reason: VARCHAR(255)
- created_at: DATETIME, Default CURRENT_TIMESTAMP

**Design Decision:**  
Appointments link patients and doctors. Overlapping appointments should be handled in backend logic.

---

### Table: admin
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- email: VARCHAR(150), Unique, Not Null
- password_hash: VARCHAR(255), Not Null
- role: VARCHAR(50)
- created_at: DATETIME, Default CURRENT_TIMESTAMP

---

### Table: payments
- id: INT, Primary Key, Auto Increment
- appointment_id: INT, Foreign Key → appointments(id)
- amount: DECIMAL(10,2), Not Null
- payment_method: VARCHAR(50)
- payment_status: VARCHAR(50)
- paid_at: DATETIME

**Design Decision:**  
Payments are tied to appointments to maintain transaction traceability.

---

## MongoDB Collection Design

### Collection: prescriptions

```json
{
  "_id": "ObjectId('64abc123456')",
  "appointmentId": 101,
  "patientId": 12,
  "doctorId": 5,
  "medications": [
    {
      "name": "Amoxicillin",
      "dosage": "500mg",
      "frequency": "3 times daily",
      "duration_days": 5
    }
  ],
  "doctorNotes": "Patient shows mild infection symptoms.",
  "refillAllowed": true,
  "attachments": [
    {
      "fileName": "blood_test_report.pdf",
      "uploadedAt": "2026-02-15T10:30:00Z"
    }
  ],
  "createdAt": "2026-02-15T10:00:00Z"
}
```

**Design Decision:**  
Prescriptions are stored in MongoDB due to flexible structure, variable medication lists, and optional attachments.
