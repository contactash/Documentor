package com.ace.creator;

import com.ace.constants.ReportConstants;
import com.ace.constants.DBConstants;
import com.ace.generators.ReportGenerator;
import com.ace.utils.ConnectionUtils;
import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportBuilder {

    ReportGenerator reportGenerator;

    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public String createReport() {

        String fileName = "";

        try {
            InputStream inputStream = getReportTemplate();
            JasperReport jasperReport = compileReport(inputStream);
            HashMap<String, Object> jasperParameter = setReportParameters();
            JasperPrint jasperPrint = fillReport(jasperReport, jasperParameter);
            fileName = reportGenerator.generateReport(jasperPrint);

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

    private InputStream getReportTemplate() {
        return getClass().getResourceAsStream(ReportConstants.REPORT_XML);
    }

    private HashMap<String, Object> setReportParameters() {
        HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
        jasperParameter.put(DBConstants.QUERY, DBConstants.QUERY_VALUE);
        jasperParameter.put(ReportConstants.REPORT_NAME, ReportConstants.REPORT_NAME_VALUE);
        return jasperParameter;
    }

}
