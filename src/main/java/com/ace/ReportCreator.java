package com.ace;

import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class ReportCreator {

    public String createPDFReport() {
        Connection conn = null;
        String fileName = "school.pdf";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/college", "ash", "password");

            InputStream inputStream = ReportClient.class.getResourceAsStream("/school.xml");
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, conn);
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

}
