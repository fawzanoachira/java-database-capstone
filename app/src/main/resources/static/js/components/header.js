// header.js

// Function to render the header based on user role and session
function renderHeader() {
    const headerDiv = document.getElementById("header");
  
    // If on homepage, clear session and show basic header
    if (window.location.pathname.endsWith("/")) {
      localStorage.removeItem("userRole");
      localStorage.removeItem("token");
      headerDiv.innerHTML = `
        <header class="header">
          <div class="logo-section">
            <img src="../assets/images/logo/logo.png" alt="Hospital CRM Logo" class="logo-img">
            <span class="logo-title">Hospital CMS</span>
          </div>
        </header>`;
      return;
    }
  
    const role = localStorage.getItem("userRole");
    const token = localStorage.getItem("token");
  
    // Handle invalid or expired session
    if ((role === "loggedPatient" || role === "admin" || role === "doctor") && !token) {
      localStorage.removeItem("userRole");
      alert("Session expired or invalid login. Please log in again.");
      window.location.href = "/";
      return;
    }
  
    // Initialize header content with logo section
    let headerContent = `
      <header class="header">
        <div class="logo-section">
          <img src="../assets/images/logo/logo.png" alt="Hospital CRM Logo" class="logo-img">
          <span class="logo-title">Hospital CMS</span>
        </div>
        <nav>
    `;
  
    // Role-specific buttons
    if (role === "admin") {
      headerContent += `
        <button id="addDocBtn" class="adminBtn" onclick="openModal('addDoctor')">Add Doctor</button>
        <a href="#" id="adminLogout">Logout</a>`;
    } else if (role === "doctor") {
      headerContent += `
        <button id="doctorHomeBtn" class="adminBtn" onclick="window.location.href='/pages/doctorDashboard.html'">Home</button>
        <a href="#" id="doctorLogout">Logout</a>`;
    } else if (role === "patient") {
      headerContent += `
        <button id="patientLogin" class="adminBtn">Login</button>
        <button id="patientSignup" class="adminBtn">Sign Up</button>`;
    } else if (role === "loggedPatient") {
      headerContent += `
        <button id="home" class="adminBtn" onclick="window.location.href='/pages/loggedPatientDashboard.html'">Home</button>
        <button id="patientAppointments" class="adminBtn" onclick="window.location.href='/pages/patientAppointments.html'">Appointments</button>
        <a href="#" id="patientLogout">Logout</a>`;
    }
  
    // Close nav and header
    headerContent += `
        </nav>
      </header>
    `;
  
    // Inject header into page
    headerDiv.innerHTML = headerContent;
  
    // Attach event listeners for dynamically created buttons
    attachHeaderButtonListeners();
  }
  
  // Function to attach listeners to header buttons
  function attachHeaderButtonListeners() {
    // Patient login
    const loginBtn = document.getElementById("patientLogin");
    if (loginBtn) {
      loginBtn.addEventListener("click", () => openModal("patientLogin"));
    }
  
    // Patient signup
    const signupBtn = document.getElementById("patientSignup");
    if (signupBtn) {
      signupBtn.addEventListener("click", () => openModal("patientSignup"));
    }
  
    // Admin logout
    const adminLogout = document.getElementById("adminLogout");
    if (adminLogout) {
      adminLogout.addEventListener("click", logout);
    }
  
    // Doctor logout
    const doctorLogout = document.getElementById("doctorLogout");
    if (doctorLogout) {
      doctorLogout.addEventListener("click", logout);
    }
  
    // Patient logout
    const patientLogout = document.getElementById("patientLogout");
    if (patientLogout) {
      patientLogout.addEventListener("click", logoutPatient);
    }
  }
  
  // General logout function for admin and doctor
  function logout() {
    localStorage.removeItem("userRole");
    localStorage.removeItem("token");
    window.location.href = "/";
  }
  
  // Logout function for patients (keep role as 'patient')
  function logoutPatient() {
    localStorage.removeItem("token");
    localStorage.setItem("userRole", "patient");
    window.location.href = "/pages/patientDashboard.html";
  }
  
  // Call renderHeader when the script loads
  renderHeader();
  