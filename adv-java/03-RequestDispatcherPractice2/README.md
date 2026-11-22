# RequestDispatcher2

## Project Description
This is a simple Java Web Application that demonstrates how to pass data from one Servlet to another using RequestDispatcher.

## Technologies Used
- Java
- Jakarta Servlets
- HTML
- Apache Tomcat 10.1
- Eclipse IDE

## Concepts Learned

| Concept | Simple Explanation |
|---|---|
| `setAttribute()` | Stores data in the request with a name. |
| `getAttribute()` | Retrieves the stored data using its name. |
| Object Return Type | `getAttribute()` returns data as an Object. |
| Type Casting | Converts an Object reference into the required type, such as String. |
| Upcasting | Stores a child class reference in a parent class reference. |
| Downcasting | Converts a parent class reference back to a child class reference. |
| RequestDispatcher | Helps one Servlet send request processing to another resource. |
| `forward()` | Forwards the same request and response to another Servlet. |

## Project Structure
- `index.html` – Contains the Submit button to start the request.
- `FirstServlet.java` – Stores the username using setAttribute() and forwards the request.
- `SecondServlet.java` – Retrieves the username using getAttribute() and displays it.

## Application Flow
1. User opens index.html.
2. User clicks the Submit button.
3. FirstServlet receives the GET request.
4. FirstServlet stores the username using `request.setAttribute()`.
5. FirstServlet forwards the request to SecondServlet.
6. SecondServlet retrieves the username using `request.getAttribute()`.
7. SecondServlet displays the username in the browser.

## Learning Objective
To understand how to pass data between Servlets using request attributes and RequestDispatcher.forward().