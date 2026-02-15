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
