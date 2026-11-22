# LoginRequestDispatcher

## 1. Project Description

LoginRequestDispatcher is a simple login application developed using Java Servlets, HTML, and JSP.

The main purpose of this project is to understand how an HTML page sends user details to a Servlet, how the Servlet receives and validates those details, and how the Servlet forwards the result to a JSP page using RequestDispatcher.

The application checks the email and password entered by the user.

- If the entered credentials are correct, it displays **Login Successful!**
- If the entered credentials are incorrect, it displays **Invalid Email or Password!**

This project uses hardcoded login credentials for learning purposes.

## 2. Technologies Used

- Java
- HTML
- JSP (Java Server Pages)
- Java Servlet
- Apache Tomcat 10.1
- Eclipse IDE
- Jakarta Servlet API

## 3. Project Structure

```text
LoginRequestDispatcher
│
├── src/main/java
│   └── com.practice.controller
│       └── LoginServlet.java
│
└── src/main/webapp
    ├── login.html
    └── result.jsp
```

### File Explanation

**1. login.html**

This is the starting page of the application.

- It contains the email and password input fields.
- The user enters their login details.
- The form sends the entered details to LoginServlet.
- The form uses the POST method to submit the data.

**2. LoginServlet.java**

This Servlet handles the login request.

- It receives the email and password from the HTML page.
- It retrieves the values using `request.getParameter()`.
- It checks whether the entered credentials match the hardcoded credentials.
- It stores the login result using `request.setAttribute()`.
- It uses RequestDispatcher to forward the request to result.jsp.

**3. result.jsp**

This JSP page displays the login result.

- It receives the forwarded request from LoginServlet.
- It accesses the message stored in the request object.
- It uses JSP Expression Language `${message}` to display the result.
- It also provides a link to return to the login page.

## 4. Application Execution Flow

The following flow explains how the complete application executes, starting from the browser and ending with the login result.

```text
             USER
               |
               |
               v
          login.html
               |
               |
     User enters email and password
               |
               |
               v
        Clicks Login Button
               |
               |
               v
       Form submits using POST
               |
               |
               v
         LoginServlet.java
               |
               |
       Receives form details
               |
               |
               v
     request.getParameter()
               |
               |
       Retrieves email and password
               |
               |
               v
        Validates Credentials
               |
               |
          +----+----+
          |         |
          v         v
        Valid    Invalid
          |         |
          v         v
   Login Successful  Invalid Email
                     or Password
          |         |
          +----+----+
               |
               |
               v
     request.setAttribute()
               |
               |
       Stores the result message
               |
               |
               v
     RequestDispatcher is created
               |
               |
               v
       rd.forward(request,response)
               |
               |
               v
           result.jsp
               |
               |
        ${message} is evaluated
               |
               |
               v
        Displays Login Result
               |
               |
               v
            BROWSER
```

## 5. Concepts Learned

| Concept | Explanation |
|---|---|
| HTML Form | It collects the email and password entered by the user. |
| POST Method | It sends form data to the Servlet through an HTTP POST request. |
| `@WebServlet` | It maps a URL to a particular Servlet. |
| `doPost()` | It handles HTTP POST requests sent by the HTML form. |
| `getParameter()` | It retrieves the values submitted through the HTML form. |
| Conditional Statements | They check whether the entered email and password are correct. |
| `setAttribute()` | It stores data inside the request object using an attribute name and value. |
| RequestDispatcher | It helps transfer request processing from one server-side resource to another. |
| `forward()` | It forwards the same request and response objects from the Servlet to the JSP page. |
| JSP | It helps display dynamic information using HTML and JSP features. |
| JSP Expression Language (EL) | `${message}` retrieves the message stored in the request attributes. |

## 6. Understanding RequestDispatcher in This Project

RequestDispatcher is used to forward the request from LoginServlet to result.jsp.

First, the Servlet stores the login result:

```java
request.setAttribute("message", "Login Successful!");
```

Here, `message` is the attribute name, and `Login Successful!` is its value.

Next, the Servlet identifies the JSP page:

```java
RequestDispatcher rd =
        request.getRequestDispatcher("result.jsp");
```

Finally, the Servlet forwards the request:

```java
rd.forward(request, response);
```

The same request object reaches the JSP page. Therefore, JSP can access the attribute stored by the Servlet.

In result.jsp, we retrieve the message using:

```jsp
<h3>${message}</h3>
```

This displays the login result in the browser.

## 7. Important Points to Remember

1. HTML collects the user details and sends them to the Servlet.
2. The Servlet receives and processes the submitted details.
3. The request object carries data between the Servlet and JSP during forwarding.
4. `setAttribute()` stores data in the request object.
5. `getRequestDispatcher()` identifies the resource where the request will be forwarded.
6. `forward()` transfers request processing to the JSP page.
7. JSP displays the dynamic result using Expression Language.
8. We can also generate HTML directly from a Servlet using PrintWriter, but JSP makes the presentation easier to maintain.

## 8. Learning Objective

The main objective of this project is to understand how HTML, Java Servlets, JSP, and RequestDispatcher work together in a web application.

After completing this project, we understand how to:

- Receive form data in a Servlet.
- Validate user-entered details.
- Store values in the request object.
- Forward a request from a Servlet to a JSP page.
- Retrieve request attributes inside JSP using Expression Language.
- Separate request processing from presentation.

**Note:** This project uses hardcoded credentials only for practice. Real login applications require secure password storage and proper authentication.

---

**Project Name:** LoginRequestDispatcher

**Status:** CompletedYes! Exactly. You have understood the basic flow of a Java web application.

**1. HTML Form**

Collects email and password

**2. Servlet**

Receives data, validates credentials and processes the request

**3. JSP**

Displays the result to the user

**Remember these three responsibilities:**

- HTML → Input
- Servlet → Processing
- JSP → Output

This is a basic example of separating presentation and request processing.

You have completed our Login Application using RequestDispatcher. Next, we will learn **JSP Implicit Objects**.

Keep practising this flow because it will help you understand Spring MVC and Spring Boot controllers later.