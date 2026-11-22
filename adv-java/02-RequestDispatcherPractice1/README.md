# RequestDispatcher Practice

## Project Description
This is a simple Java Web Application to learn how one Servlet sends a request to another Servlet using RequestDispatcher.

## Technologies Used
- Java
- Jakarta Servlets
- HTML
- Apache Tomcat 10.1
- Eclipse IDE

## Concepts Learned
- Creating Servlets
- `@WebServlet` annotation
- Servlet URL Mapping
- RequestDispatcher
- `getRequestDispatcher()`
- `forward()` method
- Sending requests from one Servlet to another

## Project Structure
- `index.html` – Contains a Submit button to start the process.
- `FirstServlet.java` – Receives the request and sends it to SecondServlet.
- `SecondServlet.java` – Receives the request and displays the output.

## Application Flow
1. Open the `index.html` page.
2. Click the Submit button.
3. The request goes to FirstServlet.
4. FirstServlet creates a RequestDispatcher for SecondServlet.
5. FirstServlet uses `forward()` to send the request to SecondServlet.
6. SecondServlet processes the request and generates the response.
7. The browser displays the output.

## Learning Objective
To understand how one Servlet forwards a request to another Servlet using the `RequestDispatcher.forward()` method.