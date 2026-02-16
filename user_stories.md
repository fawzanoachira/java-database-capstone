# Admin User Stories


## User Story 1 – Admin Login

**Title:**  
_As an admin, I want to log into the admin panel, so that I can manage the system securely._

### Acceptance Criteria:
```gherkin
Given I am on the admin login page  
When I enter valid admin credentials  
Then I should be authenticated  
And redirected to the admin dashboard
```

**Priority:** High  
**Story Points:** 3  
**Notes:**  
- Only users with admin roles should access the admin panel.  
- Invalid login attempts should display an error message.  


## User Story 2 – Manage Doctor Profiles

**Title:**  
_As an admin, I want to add, edit, or deactivate doctor profiles, so that the doctor directory stays accurate and up to date._

### Acceptance Criteria:
```gherkin
Given I am logged in as an admin  
When I create, update, or deactivate a doctor profile  
Then the changes should be saved  
And reflected in the doctor listing
```

**Priority:** High  
**Story Points:** 5  
**Notes:**  
- Deactivated doctors should not appear in public listings.  
- Required fields must be validated before saving.  


## User Story 3 – View All Appointments

**Title:**  
_As an admin, I want to view all patient appointments, so that I can monitor system activity and resolve issues._

### Acceptance Criteria:
```gherkin
Given I am logged in as an admin  
When I navigate to the appointments management section  
Then I should see a list of all appointments  
And their status, date, doctor, and patient details
```

**Priority:** Medium  
**Story Points:** 3  
**Notes:**  
- Admin should be able to filter appointments by date or status.  
- Pagination should be implemented for large datasets.  


## User Story 4 – Cancel or Reschedule Appointments

**Title:**  
_As an admin, I want to cancel or reschedule appointments, so that conflicts or emergencies can be handled efficiently._

### Acceptance Criteria:
```gherkin
Given I am logged in as an admin  
When I select an appointment  
And choose to cancel or reschedule it  
Then the appointment should be updated  
And affected users should be notified
```

**Priority:** High  
**Story Points:** 5  
**Notes:**  
- Notifications should be sent via email or system alert.  
- Rescheduling must validate doctor availability.  

---

## User Story 5 – Manage User Accounts

**Title:**  
_As an admin, I want to activate, deactivate, or remove user accounts, so that I can maintain platform security and integrity._

### Acceptance Criteria:
```gherkin
Given I am logged in as an admin  
When I manage a user account  
Then the account status should be updated  
And the user’s access should reflect the change
```

**Priority:** High  
**Story Points:** 5  
**Notes:**  
- Deactivated users should not be able to log in.  
- Account deletion should require confirmation.


# Doctor User Stories


## User Story 1 – Doctor Login

**Title:**  
_As a doctor, I want to log into the portal, so that I can manage my appointments._

### Acceptance Criteria:
```gherkin
Given I have a registered doctor account  
When I enter valid credentials  
Then I should be redirected to my dashboard  
And gain access to appointment management features
```

**Priority:** High  
**Story Points:** 3  
**Notes:**
- Only users with doctor roles should access the doctor dashboard.  
- Invalid login attempts should display an error message.


## User Story 2 – Doctor Logout

**Title:**  
_As a doctor, I want to log out of the portal, so that my data remains secure._

### Acceptance Criteria:
```gherkin
Given I am logged in  
When I click the logout button  
Then my session should be terminated  
And I should be redirected to the login page
```

**Priority:** Medium  
**Story Points:** 2  
**Notes:**
- Session tokens should be invalidated on logout.  
- Back navigation should not allow access to secured pages.


## User Story 3 – View Appointment Calendar

**Title:**  
_As a doctor, I want to view my appointment calendar, so that I can stay organized._

### Acceptance Criteria:
```gherkin
Given I am logged in as a doctor  
When I navigate to the calendar section  
Then I should see all scheduled appointments  
And their respective dates, times, and patient names
```

**Priority:** High  
**Story Points:** 5  
**Notes:**
- Calendar should support daily, weekly, and monthly views.  
- Appointments should be clearly marked by status.


## User Story 4 – Mark Unavailability

**Title:**  
_As a doctor, I want to mark my unavailability, so that patients can only book available time slots._

### Acceptance Criteria:
```gherkin
Given I am logged in as a doctor  
When I mark specific dates or time slots as unavailable  
Then those slots should not appear as bookable to patients
```

**Priority:** High  
**Story Points:** 5  
**Notes:**
- The system should prevent overlapping availability conflicts.  
- Changes should immediately reflect in patient booking view.


## User Story 5 – Update Profile Information

**Title:**  
_As a doctor, I want to update my specialization and contact information, so that patients have up-to-date information._

### Acceptance Criteria:
```gherkin
Given I am logged in as a doctor  
When I update my profile details  
Then the changes should be saved  
And reflected in the public doctor listing
```

**Priority:** Medium  
**Story Points:** 3  
**Notes:**
- Required fields must be validated before saving.  
- Profile updates should be logged for audit purposes.


## User Story 6 – View Patient Details

**Title:**  
_As a doctor, I want to view patient details for upcoming appointments, so that I can be prepared._

### Acceptance Criteria:
```gherkin
Given I am logged in as a doctor  
When I open an upcoming appointment  
Then I should see relevant patient details  
Such as name, contact information, and appointment notes
```

**Priority:** High  
**Story Points:** 5  
**Notes:**
- Access to patient details must comply with privacy regulations.  
- Only appointment-related patient information should be visible.


# Patient User Stories


## User Story 1 – View Doctors Without Logging In

**Title:**  
_As a patient, I want to view a list of doctors without logging in, so that I can explore my options before registering._

### Acceptance Criteria:
```gherkin
Given I access the doctor listing page  
When I am not logged in  
Then I should see names, specialties, and contact information of available doctors  
And I should not be able to book an appointment
```

**Priority:** High  
**Story Points:** 3  
**Notes:**
- The doctor list should be publicly accessible.  
- Booking options should require login.


## User Story 2 – Patient Sign-Up

**Title:**  
_As a patient, I want to sign up using my email and password, so that I can book appointments._

### Acceptance Criteria:
```gherkin
Given I am on the signup page  
When I submit valid registration details  
Then my account should be created  
And I should be redirected to the login page
```

**Priority:** High  
**Story Points:** 5  
**Notes:**
- Email must be unique.  
- Password should meet minimum security requirements.


## User Story 3 – Patient Login

**Title:**  
_As a patient, I want to log into the portal, so that I can manage my bookings._

### Acceptance Criteria:
```gherkin
Given I have a registered account  
When I enter valid credentials  
Then I should be redirected to my dashboard  
And gain access to appointment management features
```

**Priority:** High  
**Story Points:** 3  
**Notes:**
- Invalid credentials should display an error message.  
- Session should be securely maintained.


## User Story 4 – Patient Logout

**Title:**  
_As a patient, I want to log out of the portal, so that my account remains secure._

### Acceptance Criteria:
```gherkin
Given I am logged in  
When I click the logout button  
Then my session should be terminated  
And I should be redirected to the homepage or login page
```

**Priority:** Medium  
**Story Points:** 2  
**Notes:**
- Session tokens should be invalidated on logout.  
- Back button should not allow access to secured pages.


## User Story 5 – Book Appointment

**Title:**  
_As a patient, I want to log in and book an hour-long appointment, so that I can consult with a doctor._

### Acceptance Criteria:
```gherkin
Given I am logged in  
When I select a doctor, date, and time  
Then the system should verify availability  
And confirm the booking if the slot is free
```

**Priority:** High  
**Story Points:** 5  
**Notes:**
- Appointment duration should default to one hour.  
- Booking should fail if the time slot is unavailable.


## User Story 6 – View Upcoming Appointments

**Title:**  
_As a patient, I want to view my upcoming appointments, so that I can prepare accordingly._

### Acceptance Criteria:
```gherkin
Given I am logged in  
When I navigate to the "My Appointments" section  
Then I should see a list of all upcoming appointments  
Including date, time, and doctor details
```

**Priority:** Medium  
**Story Points:** 3  
**Notes:**
- Past appointments should be shown separately.  
- List should be sorted by nearest upcoming date.
