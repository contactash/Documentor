package com.ace.generators.impl;

import com.ace.constants.ReportTemplateConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class PDFGenerator extends ReportGenerator {

    @Override
    public void generateReport(JasperPrint jasperPrint, String fileName) throws JRException {

        JRPdfExporter exporter = (JRPdfExporter) getExporter(jasperPrint, fileName, new JRPdfExporter());
        exporter.exportReport();
    }

    @Override
    public String getFileExtension() {
        return  ReportTemplateConstants.PDF_EXT;
    }

}
