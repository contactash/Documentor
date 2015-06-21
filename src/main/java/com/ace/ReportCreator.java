package com.ace;

import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class ReportCreator {

    public String createPDFReport() {

        try {
            Class.forName(Constant.DB_DRIVER.getValue());
            Connection conn = DriverManager.getConnection(Constant.DB_URL.getValue(), Constant.USER.getValue(), Constant.PASSWORD.getValue());


            InputStream inputStream = getClass().getResourceAsStream(Constant.REPORT_XML.getValue());
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
            jasperParameter.put(Constant.QUERY.getValue(), Constant.QUERY_VALUE.getValue());
            jasperParameter.put(Constant.REPORT_NAME.getValue(), Constant.REPORT_NAME_VALUE.getValue());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, conn);
            JasperExportManager.exportReportToPdfFile(jasperPrint, Constant.FILE_NAME.getValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constant.FILE_NAME.getValue();

    }

}
