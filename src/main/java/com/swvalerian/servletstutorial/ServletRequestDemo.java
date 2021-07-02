package com.swvalerian.servletstutorial;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletRequestDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter  printWriter = response.getWriter();

        String title = "HTTP simple example servlet request";
        String contentType = "<!DOCTYPE html>\n"; // стандартный заголовок HTML документа

        printWriter.println(contentType + "<html>\n" +
                "<head><title>" + title + "</title></head>" +
                "<body>" +
                "<h1>HTTP Servlet Request Example - ну пример запроса! </h1>"
        );

        // заголовки получим
        Enumeration headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            String parameterName = (String) headers.nextElement();
            String parameterValue = request.getHeader(parameterName);
            printWriter.println("<h3>" + parameterName + ": " + parameterValue + "</h3>" + "\n");
        }

        printWriter.println("\n METOD === " + request.getMethod() + "\n");
        printWriter.println("</body>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}