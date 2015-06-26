package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class PDFGenerator extends ReportGenerator {

    public String generateReport(JasperPrint jasperPrint) throws JRException {

        String fileName = ReportConstants.FILE_NAME + ReportConstants.PDF_EXT;
        JRPdfExporter exporter = (JRPdfExporter) getExporter(jasperPrint, fileName, new JRPdfExporter());
        exporter.exportReport();
        return fileName;

    }

}
