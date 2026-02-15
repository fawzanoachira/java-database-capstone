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
