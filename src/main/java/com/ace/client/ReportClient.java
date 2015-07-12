package com.ace.client;

import com.ace.connection.impl.MySQLConnection;
import com.ace.creator.ReportBuilder;
import com.ace.generators.impl.PDFGenerator;
import com.ace.template.impl.ProductTemplate;
import com.ace.utils.FileUtils;

public class ReportClient {

	public static void main(String args[]) {

        ReportBuilder reportBuilder = new ReportBuilder(new PDFGenerator());
        reportBuilder.setReportTemplate(new ProductTemplate());
        reportBuilder.setConnections(new MySQLConnection());
        createReportAndOpenFile(reportBuilder);

//        reportBuilder.setReportTemplate(new EmployeeTemplate());
//        createReportAndOpenFile(reportBuilder);

//        reportBuilder.setReportGenerator(new XLSGenerator());
//        reportBuilder.setReportTemplate(new ProductTemplate());
//        createReportAndOpenFile(reportBuilder);


//        reportBuilder.setReportGenerator(new HTMLGenerator());
//        reportBuilder.setReportTemplate(new ProductTemplate());
//        createReportAndOpenFile(reportBuilder);
	}

    private static void createReportAndOpenFile(ReportBuilder reportBuilder) {
        String fileName = reportBuilder.createReport();
        FileUtils.openFile(fileName);
    }
}