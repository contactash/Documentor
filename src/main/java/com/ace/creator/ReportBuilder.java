package com.ace.creator;

import com.ace.connection.Connections;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import com.google.inject.Inject;
import net.sf.jasperreports.engine.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportBuilder {

    private ReportTemplate reportTemplate;
    private ReportGenerator reportGenerator;
    private Connections connections;
    private String contentType;

    @Inject
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

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

        try {
            JasperPrint jasperPrint = getJasperPrint();
            fileName = reportTemplate.getFileName() + reportGenerator.getFileExtension();
            reportGenerator.generateReport(jasperPrint, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private JasperPrint getJasperPrint() {

        Connection connection = null;
        JasperPrint jasperPrint = null;

        try {
            InputStream inputStream = reportTemplate.getReportTemplate();
            JasperReport jasperReport = compileReport(inputStream);
            HashMap<String, Object> jasperParameter = reportTemplate.setReportParameters();
            connection = connections.getConnection();
            jasperPrint = fillReport(jasperReport, jasperParameter, connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connections.closeConnection(connection);
        }
        return jasperPrint;
    }

    public ByteArrayOutputStream getByteArrayOutputStream()  {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRExporter exporter = reportGenerator.getExporterType();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, getJasperPrint());
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        try {
            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
        }
        return outputStream;
    }



    private JasperPrint fillReport(JasperReport jasperReport, HashMap<String, Object> jasperParameter, Connection connection) throws JRException, ClassNotFoundException, SQLException {
        return JasperFillManager.fillReport(jasperReport,
                jasperParameter, connection);
    }

    private JasperReport compileReport(InputStream inputStream) throws JRException {
        return JasperCompileManager.compileReport(inputStream);
    }
}