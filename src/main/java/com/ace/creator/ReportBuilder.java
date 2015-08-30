package com.ace.creator;

import com.ace.connection.Connections;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import com.google.inject.Inject;
import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportBuilder {

    private ReportTemplate reportTemplate;
    private ReportGenerator reportGenerator;
    private Connections connections;

    @Inject
    public ReportBuilder(ReportGenerator reportGenerator) {
        if(reportGenerator == null) {
            throw new IllegalArgumentException("Report Generator cannot be null");
        }
        this.reportGenerator = reportGenerator;
    }

    @Inject
    public void setReportTemplate(ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    @Inject
    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public String createReport() {

        String fileName = "";
        Connection connection = null;

        try {
            InputStream inputStream = reportTemplate.getReportTemplate();
            JasperReport jasperReport = compileReport(inputStream);
            HashMap<String, Object> jasperParameter = reportTemplate.setReportParameters();
            connection = connections.getConnection();
            JasperPrint jasperPrint = fillReport(jasperReport, jasperParameter, connection);
            fileName = reportTemplate.getFileName() + reportGenerator.getFileExtension();
            reportGenerator.generateReport(jasperPrint, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connections.closeConnection(connection);
        }
        return fileName;
    }

    private JasperPrint fillReport(JasperReport jasperReport, HashMap<String, Object> jasperParameter, Connection connection) throws JRException, ClassNotFoundException, SQLException {
        return JasperFillManager.fillReport(jasperReport,
                jasperParameter, connection);
    }

    private JasperReport compileReport(InputStream inputStream) throws JRException {
        return JasperCompileManager.compileReport(inputStream);
    }
}