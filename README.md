# Metro-Ticket-Booking-API
Metro Ticket Booking

Technologies Used
Backend: Spring Boot (Java)
Database: MySQL
Tools: IntelliJ IDEA, POSTMAN, JSON

Running the Application
1. Clone this repository to your local machine:

bash
Copy code
git clone https://github.com/deepak251222/Metro-Ticket-Booking-API.git

POSTMAN DOC 
https://documenter.getpostman.com/view/24219652/2s9YRGw8Ed
Set up the database:

Create a MySQL database and configure the database connection settings in application.properties.
Run the application:

Open the project in IntelliJ IDEA or your preferred Java IDE.
Configure the application properties and database settings.
Run the Spring Boot application.
Postman Collection:

Use the provided Postman collection file to test the API endpoints.

Usage
1. Use the API endpoints provided in the Postman collection to:

2.Purchase a metro ticket.
Check the status of a ticket.
Use a ticket for entry and exit.
Verify the validity of a ticket.
The system enforces the two-time use and 18-hour expiration limit, showing "Invalid Token or ID" or "Token Is Expire" messages as needed.
