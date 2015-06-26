package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

public class HTMLGenerator extends ReportGenerator {
    public String generateReport(JasperPrint jasperPrint) throws JRException {

        String fileName = ReportConstants.FILE_NAME + ReportConstants.HTML_EXT;
        JRHtmlExporter exporter = (JRHtmlExporter) getJrExporter(jasperPrint, fileName,new JRHtmlExporter() );
        exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporter.exportReport();
        return fileName;
    }
}
