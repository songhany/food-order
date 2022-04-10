package com.songhany.foodash;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;
import com.songhany.foodash.entity.Customer;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        String customer = request.getParameter("customer");  // get "?customer=XXX"
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Hello " + customer + "</h1>");  // <h1>Hello XXX</h1>
//        out.println("</body></html>");
//    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("application/json");
//
//        JSONObject customer = new JSONObject();
//        customer.put("email", "songhanysh@gmail.com");
//        customer.put("first_name", "songhan");
//        customer.put("last_name", "yu");
//        customer.put("age", 18);
//        response.getWriter().print(customer);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {  // above steps be simplified with Jackson
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("songhanysh@gmail.com");
        customer.setPassword("123456");
        customer.setFirstName("songhan");
        customer.setLastName("yu");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");

        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {  // above steps be simplified with Jackson
//        ObjectMapper objectMapper = new ObjectMapper();
//        Customer customer = objectMapper.readValue(IOUtils.toString(request.getReader()), Customer.class);
//
//        System.out.println(customer.getEmail());
//        System.out.println(customer.getFirstName());
//        System.out.println(customer.getLastName());
//        // Return status = ok as response body to the client
//        response.setContentType("application/json");
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("status", "ok");
//        response.getWriter().print(jsonResponse);
//    }
//
//    public void destroy() {
//    }
}