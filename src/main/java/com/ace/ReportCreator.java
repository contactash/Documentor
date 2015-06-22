package com.ace;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class ReportCreator {

    public String createPDFReport() {

        try {
            Class.forName(Constants.DB_DRIVER);
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASSWORD);


            InputStream inputStream = getClass().getResourceAsStream(Constants.REPORT_XML);
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
            jasperParameter.put(Constants.QUERY, Constants.QUERY_VALUE);
            jasperParameter.put(Constants.REPORT_NAME, Constants.REPORT_NAME_VALUE);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, conn);
            JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.FILE_NAME + Constants.PDF_EXT);

            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, Constants.FILE_NAME + Constants.XLS_EXT);
            exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
            exporter.exportReport();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FILE_NAME + Constants.PDF_EXT;

    }

}
