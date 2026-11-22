# ServletToJSP

## Project Description

This is a simple Java Web Application that demonstrates how to forward a request from a Servlet to a JSP page using RequestDispatcher.

In this project, the Servlet stores a username and forwards the request to a JSP page. The JSP page retrieves the username and displays it in the browser.

## Technologies Used
- Java
- Jakarta Servlets
- JSP
- HTML
- Apache Tomcat 10.1
- Eclipse IDE

## Concepts Learned

| Concept | Simple Explanation |
|---|---|
| Servlet | A Java class that receives and processes browser requests. |
| JSP | A page used to generate dynamic web content. |
| RequestDispatcher | Helps transfer request processing from one resource to another. |
| forward() | Forwards the same request and response to another resource. |
| setAttribute() | Stores data in the request using an attribute name. |
| Expression Language (EL) | Retrieves data from the request using a simple expression like `${username}`. |
| JSP Page Directive | Defines JSP page settings such as language and content type. |
| HTTP Request | Carries information from the browser to the server. |
| HTTP Response | Carries the result from the server back to the browser. |
| Tomcat Server | Processes Servlets and JSP pages and sends the response to the browser. |

## Project Structure

- `index.html` – Contains the Submit button to send a request to WelcomeServlet.
- `WelcomeServlet.java` – Receives the request, stores the username and forwards it to welcome.jsp.
- `welcome.jsp` – Retrieves the username and displays the welcome message.

## Application Flow

1. User opens the index.html page.
2. User clicks the Submit button.
3. The browser sends a GET request to WelcomeServlet.
4. WelcomeServlet receives the request.
5. WelcomeServlet stores the username using `request.setAttribute()`.
6. WelcomeServlet uses `RequestDispatcher` to identify welcome.jsp.
7. The `forward()` method forwards the request to welcome.jsp.
8. Tomcat processes the JSP page.
9. JSP retrieves the username using `${username}`.
10. JSP generates the HTML output.
11. Tomcat sends the generated HTML response to the browser.
12. The browser displays the welcome message.

## Learning Objective

To understand how a Servlet forwards a request to a JSP page, how data passes between them, and how JSP displays dynamic content in the browser.