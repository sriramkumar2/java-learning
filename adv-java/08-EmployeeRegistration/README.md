# Employee Registration System

## Description

A simple Java web application that allows users to add employee details
and view all employee records.

## Features

-   Add an employee with name, email, and phone number.
-   Save employee details in a MySQL database.
-   Display all employee records in a table.
-   Show a success or failure message after submitting the form.

## Technologies Used

-   Java 21
-   Maven
-   Jakarta Servlets
-   JSP
-   Apache Tomcat 10.1
-   MySQL
-   JDBC
-   HikariCP

## Project Structure

``` text
com.practice
├── connection
│   └── ConnectionFactory.java
├── controller
│   └── EmployeeServlet.java
├── dao
│   └── EmployeeDAO.java
├── model
│   └── Employee.java
└── service
    └── EmployeeService.java

src/main/resources
└── db.properties

src/main/webapp
├── index.jsp
├── addEmployee.jsp
└── viewEmployees.jsp
```

## Application Flow

### Add Employee

``` text
addEmployee.jsp
      ↓
EmployeeServlet (doPost)
      ↓
EmployeeService
      ↓
EmployeeDAO
      ↓
ConnectionFactory
      ↓
MySQL Database
      ↓
Success or failure message on the form page
```

### View Employees

``` text
View Employees link
      ↓
EmployeeServlet (doGet)
      ↓
EmployeeService
      ↓
EmployeeDAO
      ↓
MySQL Database
      ↓
viewEmployees.jsp
```

## Main Concepts Learned

-   Creating a Maven web application.
-   Using Servlets to handle HTTP GET and POST requests.
-   Using JSP pages to display forms, messages, and employee records.
-   Using a Model class to represent employee data.
-   Separating controller, service, DAO, and connection logic.
-   Using JDBC and PreparedStatement for database operations.
-   Using HikariCP for database connection pooling.
-   Passing data from a Servlet to JSP with request attributes and
    RequestDispatcher.
-   Loading database configuration from
    `src/main/resources/db.properties`.

## Database

The application uses a MySQL database with an `employee` table
containing: - `id` -- auto-increment primary key - `name` - `email` -
`phone`

## Note

Update the database URL, username, and password in `db.properties` to
match your local MySQL setup.


Credentials are not stored in this repository. Copy
`src/main/resources/db.properties.example` to
`src/main/resources/db.properties` and fill in your own values.
