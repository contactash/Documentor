package com.ace.generators;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;

public abstract class ReportGenerator {


    public abstract void generateReport(JasperPrint jasperPrint, String fileName) throws JRException;

    public abstract String getFileExtension();

    public abstract JRExporter getExporterType();

    public JRExporter getExporter(JasperPrint jasperPrint, String fileName, JRExporter exporter) {
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);

        return exporter;
    }

}
