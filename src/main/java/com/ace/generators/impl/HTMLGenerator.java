package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;

public class HTMLGenerator extends ReportGenerator {
    public String generateReport(JasperPrint jasperPrint) throws JRException {

        String fileName = getPDFFileName();
        JRHtmlExporter exporter = (JRHtmlExporter) getExporter(jasperPrint, fileName, new JRHtmlExporter());
        exporter.exportReport();
        return fileName;
    }

    String getPDFFileName() {
        return ReportConstants.FILE_NAME + ReportConstants.HTML_EXT;
    }
}
