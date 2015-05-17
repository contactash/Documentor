package com.ace;

import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class ReportCreator {

    public String createPDFReport() {
        Connection conn = null;
        String fileName = "Students-Report.pdf";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/college", "ash", "password");

            HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
            jasperParameter.put("QUERY", "select * from students;");
            InputStream inputStream = ReportClient.class.getResourceAsStream("/school.xml");
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, conn);
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;

    }

}
