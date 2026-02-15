This Spring Boot application uses both MVC and REST controllers. Thymeleaf templates are used for the Admin and Doctor dashboards, while REST APIs serve all other modules. The application interacts with two databases—MySQL (for patient, doctor, appointment, and admin data) and MongoDB (for prescriptions). All controllers route requests through a common service layer, which in turn delegates to the appropriate repositories. MySQL uses JPA entities while MongoDB uses document models.

1. User Interface Interaction: A user interacts with the system through either the server-rendered Thymeleaf Dashboards (Admin/Doctor) or via REST Module clients like mobile apps.
+1

2. Controller Routing: The request is captured by the Controller Layer. Thymeleaf Controllers handle requests for web pages, while REST Controllers process API calls and return JSON data.

3. Service Layer Execution: The controllers delegate the request to the Service Layer, which applies business logic, performs validations, and coordinates workflows.


4. Repository Layer Communication: The Service Layer calls the appropriate Repository Layer (MySQL or MongoDB) to perform data operations.


5. Database Access: The repositories interface with the underlying Database Engines—MySQL for structured relational entities and MongoDB for flexible document records.

6. Model Binding: Retrieved data is mapped back into Java objects. MySQL data is bound to JPA Entities (@Entity), and MongoDB data is bound to Document Models (@Document).
+1

7. Response Delivery: The bound models are sent back to the controllers. The system then delivers either a rendered HTML page (for MVC) or a JSON response (for REST) back to the user.