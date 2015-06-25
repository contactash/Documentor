package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

public class PDFGenerator implements ReportGenerator {

    public String generateReport(JasperPrint jasperPrint) throws JRException {

        String fileName = ReportConstants.FILE_NAME + ReportConstants.PDF_EXT;

        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);

        return fileName;

    }

}
