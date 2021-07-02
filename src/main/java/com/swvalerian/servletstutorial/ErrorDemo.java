package com.swvalerian.servletstutorial;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // получим код исключения
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        // пишем свой обработчик на ошибку
        String title = "Error Handling";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<body>");

        writer.println("<h1>Error information</h1>");
        writer.println("Code: " + code);

        writer.println("</body>");
        writer.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
