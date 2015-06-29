package com.ace.client;

import com.ace.generators.impl.HTMLGenerator;
import com.ace.generators.impl.PDFGenerator;
import com.ace.creator.ReportBuilder;
import com.ace.generators.impl.XLSGenerator;
import com.ace.template.impl.ProductTemplate;
import com.ace.utils.FileUtils;

public class ReportClient {
	
	public static void main(String args[]) {

        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.setReportGenerator(new PDFGenerator());
        reportBuilder.setReportTemplate(new ProductTemplate());
        createReportAndOpenFile(reportBuilder);

        reportBuilder.setReportGenerator(new XLSGenerator());
        reportBuilder.setReportTemplate(new ProductTemplate());
        createReportAndOpenFile(reportBuilder);

//        reportBuilder.setReportGenerator(new HTMLGenerator());
//        reportBuilder.setReportTemplate(new ProductTemplate());
//        createReportAndOpenFile(reportBuilder);
	}

    private static void createReportAndOpenFile(ReportBuilder reportBuilder) {
        String fileName = reportBuilder.createReport();
        FileUtils.openFile(fileName);
    }
}