package com.swvalerian.servletstutorial;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassingParametersUsingGetMethodDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // для эксперимента введем в поле браузера эту строку
        // http://localhost:8088/getParamDemo?spec=Java_Developer&exp=6_years
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        String title = "Passing parameters using GET method";

        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body><h2>SPECIALITY: </h2>" + request.getParameter("spec") + // здесь подставится то, что мы укажем в пармаетре ?spec=
                "<h2>EXPERIENCE: </h2>" + request.getParameter("exp") // здесь подставится то, что мы укажем в пармаетре &exp=
                + "</body>" +
                "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
