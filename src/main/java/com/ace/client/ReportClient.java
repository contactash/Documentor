package com.ace.client;

import com.ace.creator.ReportBuilder;
import com.ace.template.impl.EmployeeTemplate;
import com.ace.utils.FileUtils;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ReportClient {

	public static void main(String args[]) {

        Injector inject = Guice.createInjector(new ReportModule());

        ReportBuilder reportBuilder = inject.getInstance(ReportBuilder.class);
        createReportAndOpenFile(reportBuilder);

//        ReportBuilder reportBuilder = new ReportBuilder(new PDFGenerator());
//        reportBuilder.setReportTemplate(new ProductTemplate());
//        reportBuilder.setConnections(new MySQLConnection());

//        reportBuilder.setReportGenerator(new XLSGenerator());
        reportBuilder.setReportTemplate(new EmployeeTemplate());
        createReportAndOpenFile(reportBuilder);

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