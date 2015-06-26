package com.ace.generators;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;

public abstract class ReportGenerator {
    public abstract String generateReport(JasperPrint jasperPrint) throws JRException;

    public JRExporter getExporter(JasperPrint jasperPrint, String fileName, JRExporter exporter) {
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);

        return exporter;
    }
}
