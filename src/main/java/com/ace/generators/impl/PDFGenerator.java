package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class PDFGenerator extends ReportGenerator {


    public String generateReport(JasperPrint jasperPrint) throws JRException {

        String fileName = getFileName();
        JRPdfExporter exporter = (JRPdfExporter) getExporter(jasperPrint, fileName, new JRPdfExporter());
        exporter.exportReport();
        return fileName;
    }

    @Override
    public String getFileName() {
        return  super.getFileName() + ReportConstants.PDF_EXT;
    }

}
