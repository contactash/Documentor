package com.ace.creator;

import com.ace.constants.DBConstants;
import com.ace.constants.ProductReportConstants;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import com.ace.utils.ConnectionUtils;
import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportBuilder {

    ReportTemplate reportTemplate;
    ReportGenerator reportGenerator;

    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void setReportTemplate(ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    public String createReport() {

        String fileName = "";

        try {
            InputStream inputStream = reportTemplate.getReportTemplate();
            JasperReport jasperReport = compileReport(inputStream);
            HashMap<String, Object> jasperParameter = setReportParameters();
            JasperPrint jasperPrint = fillReport(jasperReport, jasperParameter);
            fileName = reportTemplate.getFileName() + reportGenerator.getFileExtension();
            reportGenerator.generateReport(jasperPrint, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;

    }

    private JasperPrint fillReport(JasperReport jasperReport, HashMap<String, Object> jasperParameter) throws JRException, ClassNotFoundException, SQLException {
        return JasperFillManager.fillReport(jasperReport,
                jasperParameter, ConnectionUtils.getConnection());
    }

    private JasperReport compileReport(InputStream inputStream) throws JRException {
        return JasperCompileManager.compileReport(inputStream);
    }

    private HashMap<String, Object> setReportParameters() {
        HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
        jasperParameter.put(DBConstants.QUERY, ProductReportConstants.QUERY_VALUE);
        jasperParameter.put(ProductReportConstants.REPORT_NAME, ProductReportConstants.REPORT_NAME_VALUE);
        return jasperParameter;
    }

}