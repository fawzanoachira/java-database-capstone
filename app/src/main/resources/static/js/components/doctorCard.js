// doctorCard.js

// Import necessary functions
import { showBookingOverlay } from "./loggedPatient.js"; // For booking appointments
import { deleteDoctor } from "./doctorServices.js";      // Admin delete API
import { getPatientData } from "./patientServices.js";   // Fetch patient details

// Function to create a doctor card
export function createDoctorCard(doctor) {
  // Main card container
  const card = document.createElement("div");
  card.classList.add("doctor-card");

  // Fetch current user role
  const role = localStorage.getItem("userRole");

  // Doctor info section
  const infoDiv = document.createElement("div");
  infoDiv.classList.add("doctor-info");

  const name = document.createElement("h3");
  name.textContent = doctor.name;

  const specialization = document.createElement("p");
  specialization.textContent = `Specialty: ${doctor.specialization}`;

  const email = document.createElement("p");
  email.textContent = `Email: ${doctor.email}`;

  const availability = document.createElement("p");
  availability.textContent = `Availability: ${doctor.availability.join(", ")}`;

  infoDiv.appendChild(name);
  infoDiv.appendChild(specialization);
  infoDiv.appendChild(email);
  infoDiv.appendChild(availability);

  // Actions container
  const actionsDiv = document.createElement("div");
  actionsDiv.classList.add("card-actions");

  // Role-based buttons
  if (role === "admin") {
    const removeBtn = document.createElement("button");
    removeBtn.textContent = "Delete";
    removeBtn.addEventListener("click", async () => {
      const confirmDelete = confirm(`Are you sure you want to delete Dr. ${doctor.name}?`);
      if (!confirmDelete) return;

      const token = localStorage.getItem("token");
      if (!token) {
        alert("Admin not authenticated.");
        return;
      }

      try {
        await deleteDoctor(doctor.id, token);
        card.remove();
        alert(`Dr. ${doctor.name} has been deleted.`);
      } catch (error) {
        console.error("Error deleting doctor:", error);
        alert("Failed to delete doctor. Please try again.");
      }
    });
    actionsDiv.appendChild(removeBtn);

  } else if (role === "patient") {
    const bookNow = document.createElement("button");
    bookNow.textContent = "Book Now";
    bookNow.addEventListener("click", () => {
      alert("Please log in to book an appointment.");
    });
    actionsDiv.appendChild(bookNow);

  } else if (role === "loggedPatient") {
    const bookNow = document.createElement("button");
    bookNow.textContent = "Book Now";
    bookNow.addEventListener("click", async (e) => {
      const token = localStorage.getItem("token");
      if (!token) {
        alert("Session expired. Please log in again.");
        window.location.href = "/";
        return;
      }

      try {
        const patientData = await getPatientData(token);
        showBookingOverlay(e, doctor, patientData);
      } catch (error) {
        console.error("Error fetching patient data:", error);
        alert("Could not fetch patient data. Try again.");
      }
    });
    actionsDiv.appendChild(bookNow);
  }

  // Assemble the card
  card.appendChild(infoDiv);
  card.appendChild(actionsDiv);

  return card;
}
