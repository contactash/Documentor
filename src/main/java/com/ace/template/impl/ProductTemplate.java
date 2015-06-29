package com.ace.template.impl;

import com.ace.constants.DBConstants;
import com.ace.constants.ProductTemplateConstants;
import com.ace.template.ReportTemplate;

import java.io.InputStream;
import java.util.HashMap;

public class ProductTemplate implements ReportTemplate {

    public InputStream getReportTemplate() {
        return getClass().getResourceAsStream(ProductTemplateConstants.PRODUCT_TEMPLATE_XML);
    }

    public String getFileName() {
        return ProductTemplateConstants.FILE_NAME;
    }

    public HashMap<String, Object> setReportParameters() {
        HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
        jasperParameter.put(DBConstants.QUERY, ProductTemplateConstants.QUERY_VALUE);
        jasperParameter.put(ProductTemplateConstants.REPORT_NAME, ProductTemplateConstants.REPORT_NAME_VALUE);
        return jasperParameter;
    }
}