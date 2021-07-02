package com.swvalerian.servletstutorial;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This is simple servlet that demonstrates work with {@link java.util.Date} class.
 *
 * @author Eugene Suelimanov
 */

public class DateTimeDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // жалкие попытки заменить ???????????????? на русский язык в браузере
        Locale.setDefault(new Locale("Ru-ru"));

        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // А надо было сделать вот так и больше не будет вопросиков, вместо латиницы!!!
        response.setCharacterEncoding("UTF-8");
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        // даннымм методом задали интервал автообновления страницы (1 секунда)
        response.setIntHeader("refresh", 1);

        String docType = "<!DOCTYPE html>";
        String title = "Date and Time Demo + AutoRefresh";
        Date currentDate = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");

        PrintWriter writer = response.getWriter();

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<H1>" +
                " -- текущее время = " + df.format(currentDate) +
                "<H1>" +
                "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}