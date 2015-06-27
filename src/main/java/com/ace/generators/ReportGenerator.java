package com.ace.generators;

import com.ace.constants.ReportConstants;
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

     public  String getFileName() {
        return  ReportConstants.FILE_NAME;
    }

}
