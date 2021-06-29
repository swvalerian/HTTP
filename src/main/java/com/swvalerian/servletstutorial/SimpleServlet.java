package com.swvalerian.servletstutorial;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple class that extends {@link HttpServlet}.
 *
 * @author Eugene Suleimanov
 */
public class SimpleServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message - I LOVE TATIANA PANAFIDINA!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(200);

        PrintWriter messageWriter = response.getWriter();
        messageWriter.println("<h3>" + message + "<h3>");
    }

    public void destroy() {

    }
}