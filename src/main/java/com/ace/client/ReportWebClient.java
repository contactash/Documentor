package com.ace.client;

import com.ace.connection.impl.MySQLConnection;
import com.ace.creator.ReportBuilder;
import com.ace.generators.impl.HTMLGenerator;
import com.ace.generators.impl.PDFGenerator;
import com.ace.generators.impl.XLSGenerator;
import com.ace.template.impl.EmployeeTemplate;
import com.ace.template.impl.ProductTemplate;

class ReportWebClient {


    ReportBuilder buildReport(String reportFormat, String reportType)  {
        ReportBuilder reportBuilder = new ReportBuilder(new PDFGenerator());
        reportBuilder.setContentType("application/pdf");
        switch (reportFormat) {
            case "xls" :
                reportBuilder = new ReportBuilder(new XLSGenerator());
                reportBuilder.setContentType("application/vnd.ms-excel");
                break;
            case "html" :
                reportBuilder = new ReportBuilder(new HTMLGenerator());
                reportBuilder.setContentType("application/html");
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

        return  reportBuilder;
    }

}
