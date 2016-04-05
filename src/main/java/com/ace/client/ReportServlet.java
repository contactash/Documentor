package com.ace.client;

import com.ace.creator.ReportBuilder;
import com.ace.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "AnnotatedServlet",
        description = "A sample annotated servlet",
        urlPatterns = {"/ReportServlet"}
)
public class ReportServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.getWriter().println("Hello !!");

        PrintWriter writer = response.getWriter();
        writer.println("<html>Hello, I am a Java servlet! </html>");
        writer.flush();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String reportFormat = request.getParameter("reportFormat");
        String reportType = request.getParameter("reportType");
        String openInBrowser = request.getParameter("checkbox");


        ReportWebClient reportWebClient = new ReportWebClient();
        ReportBuilder reportBuilder = reportWebClient.buildReport(reportFormat, reportType);

        if(openInBrowser != null) {
            ByteArrayOutputStream reportStream = reportBuilder.getByteArrayOutputStream();
            response.setContentLength(reportStream.size());
            response.setContentType(reportBuilder.getContentType());
            ServletOutputStream servletOutputStream = response.getOutputStream();
            reportStream.writeTo(servletOutputStream);
            servletOutputStream.flush();
        } else {
            String fileName = reportBuilder.createReport();
            FileUtils.openFile(fileName);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


}