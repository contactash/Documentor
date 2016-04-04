package com.ace.client;

import com.ace.connection.impl.MySQLConnection;
import com.ace.creator.ReportBuilder;
import com.ace.generators.impl.HTMLGenerator;
import com.ace.generators.impl.PDFGenerator;
import com.ace.generators.impl.XLSGenerator;
import com.ace.template.impl.EmployeeTemplate;
import com.ace.template.impl.ProductTemplate;
import com.ace.utils.FileUtils;

class ReportWebClient {

    void buildReport(String reportFormat, String reportType) {
        ReportBuilder reportBuilder = new ReportBuilder(new PDFGenerator());
        switch (reportFormat) {
            case "xls" :
                reportBuilder = new ReportBuilder(new XLSGenerator());
                break;
            case "html" :
                reportBuilder = new ReportBuilder(new HTMLGenerator());
                break;
        }

        switch (reportType) {
            case "emp" :
                reportBuilder.setReportTemplate(new EmployeeTemplate());
                break;
            case "prod" :
                reportBuilder.setReportTemplate(new ProductTemplate());
                break;
            default:
                reportBuilder.setReportTemplate(new ProductTemplate());
        }

        reportBuilder.setConnections(new MySQLConnection());

        createReportAndOpenFile(reportBuilder);
    }

    private static void createReportAndOpenFile(ReportBuilder reportBuilder) {
        String fileName = reportBuilder.createReport();
        FileUtils.openFile(fileName);
    }
}
