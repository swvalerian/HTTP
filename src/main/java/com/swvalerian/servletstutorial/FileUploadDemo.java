package com.swvalerian.servletstutorial;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class FileUploadDemo extends HttpServlet {
    static final int fileMaxSize = 500 * 1024;
    static final int memMaxSize = 500 * 1024;

    private String filePath = "D:\\Java\\HTTP\\src\\main\\resources\\uploads";
    private File file;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8"); // это чтоб шрифт был русским, а не знаки ???

        String docType = "<!DOCTYPE html>";
        String title = "Пример загрузки файла";

        PrintWriter writer = response.getWriter();


        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new File(filePath));
        diskFileItemFactory.setSizeThreshold(memMaxSize);

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        upload.setSizeMax(fileMaxSize);

        try {
            List fileItems = upload.parseRequest(request);

            Iterator iterator = fileItems.iterator();

            writer.println(docType +
                    "<html>" +
                    "<head>" +
                    "<title>" + title + "</title>" +
                    "</head>" +
                    "<body>");

            while (iterator.hasNext()) {
                FileItem fileItem = (FileItem) iterator.next();
                if (!fileItem.isFormField()) {

                    String fileName = fileItem.getName();
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fileItem.write(file);
                    writer.println(fileName + " был загружен.<br>");
                }
            }
            writer.println("</body>" +
                    "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
