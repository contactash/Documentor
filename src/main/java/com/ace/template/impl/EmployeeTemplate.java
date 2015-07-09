package com.ace.template.impl;

import com.ace.constants.DBConstants;
import com.ace.constants.EmployeeTemplateConstants;
import com.ace.template.ReportTemplate;

import java.io.InputStream;
import java.util.HashMap;

public class EmployeeTemplate implements ReportTemplate {

    public InputStream getReportTemplate() {
        return getClass().getResourceAsStream(EmployeeTemplateConstants.EMPLOYEES_TEMPLATE_XML);
    }

    public String getFileName() {
        return EmployeeTemplateConstants.FILE_NAME;
    }

    public HashMap<String, Object> setReportParameters() {
        HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
        jasperParameter.put(DBConstants.QUERY, EmployeeTemplateConstants.QUERY_VALUE);
        jasperParameter.put(EmployeeTemplateConstants.REPORT_NAME, EmployeeTemplateConstants.REPORT_NAME_VALUE);
        return jasperParameter;
    }
}