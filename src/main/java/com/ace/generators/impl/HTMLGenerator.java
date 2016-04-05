package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;

public class HTMLGenerator extends ReportGenerator {

    @Override
    public void generateReport(JasperPrint jasperPrint, String fileName) throws JRException {

        JRHtmlExporter exporter = (JRHtmlExporter) getExporter(jasperPrint, fileName, new JRHtmlExporter());
        exporter.exportReport();
    }

    @Override
    public String getFileExtension() {
        return ReportConstants.HTML_EXT;
    }

    @Override
    public JRExporter getExporterType() {
        return new JRHtmlExporter();
    }

}
