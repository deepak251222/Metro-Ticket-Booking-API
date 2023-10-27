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

Some O/P:-
Station 
{
    "Station": [
        {
            "name": "A",
            "startStation": true
        },
        {
            "name": "B",
            "price": 10
        },
        {
            "name": "C",
            "price": 15
        },
        {
            "name": "C1",
            "price": 18
        },
        {
            "name": "D",
            "lastStation": true,
            "price": 25
        },
        {
            "name": "D1",
            "price": 28
        }
    ]
}
Metro Ticket booking o/p :-
i/p :
http:http://localhost:8082/api/tickets/buy
{
    "startStation": "B",
    "destinationStation": "C1"
}

o/p :-{
    "ticketId": "06ae4677-9f0d-4b2b-a535-fc54ce559394",
    "sourceStation": "B",
    "destinationStation": "C1",
    "expirationTime": "2023-10-28T10:59:12.3382163",
    "usagesLeft": 2,
    "price": 8
}
enter : 
i/p :-http://localhost:8082/api/tickets/enter/06ae4677-9f0d-4b2b-a535-fc54ce559394
o/p : if id is not expire or not use < 2 time     O/P    "Entered station successfully!" 
exit :
   i/p :- 
http://localhost:8082/api/tickets/exit/06ae4677-9f0d-4b2b-a535-fc54ce559394
o/p : if id is not expire or not use < 2 time     O/P    "Exited station successfully!" 


