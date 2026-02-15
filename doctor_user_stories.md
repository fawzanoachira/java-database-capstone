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
