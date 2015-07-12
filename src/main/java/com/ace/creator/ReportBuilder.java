package com.ace.creator;

import com.ace.connection.Connections;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportBuilder {

    private ReportTemplate reportTemplate;
    private ReportGenerator reportGenerator;
    private Connections connections;

    public ReportBuilder(ReportGenerator reportGenerator) {
        if(reportGenerator == null) {
            throw new IllegalArgumentException("Report Generator cannot be null");
        }
        this.reportGenerator = reportGenerator;
    }

    public void setReportTemplate(ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public String createReport() {

        String fileName = "";

        try {
            InputStream inputStream = reportTemplate.getReportTemplate();
            JasperReport jasperReport = compileReport(inputStream);
            HashMap<String, Object> jasperParameter = reportTemplate.setReportParameters();
            JasperPrint jasperPrint = fillReport(jasperReport, jasperParameter);
            fileName = reportTemplate.getFileName() + reportGenerator.getFileExtension();
            reportGenerator.generateReport(jasperPrint, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private JasperPrint fillReport(JasperReport jasperReport, HashMap<String, Object> jasperParameter) throws JRException, ClassNotFoundException, SQLException {
        return JasperFillManager.fillReport(jasperReport,
                jasperParameter, connections.getConnection());
    }

    private JasperReport compileReport(InputStream inputStream) throws JRException {
        return JasperCompileManager.compileReport(inputStream);
    }
}