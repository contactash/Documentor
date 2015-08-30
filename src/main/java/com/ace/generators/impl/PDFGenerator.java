package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import com.google.inject.Singleton;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Singleton
public class PDFGenerator extends ReportGenerator {

    @Override
    public void generateReport(JasperPrint jasperPrint, String fileName) throws JRException {

        JRPdfExporter exporter = (JRPdfExporter) getExporter(jasperPrint, fileName, new JRPdfExporter());
        exporter.exportReport();
    }

    @Override
    public String getFileExtension() {
        return  ReportConstants.PDF_EXT;
    }

}
