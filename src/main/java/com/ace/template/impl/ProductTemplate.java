package com.ace.template.impl;

import com.ace.constants.DBConstants;
import com.ace.constants.ProductReportConstants;
import com.ace.template.ReportTemplate;

import java.io.InputStream;
import java.util.HashMap;

public class ProductTemplate implements ReportTemplate {

    public InputStream getReportTemplate() {
        return getClass().getResourceAsStream(ProductReportConstants.PRODUCT_TEMPLATE_XML);
    }

    public String getFileName() {
        return ProductReportConstants.FILE_NAME;
    }

    public HashMap<String, Object> setReportParameters() {
        HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
        jasperParameter.put(DBConstants.QUERY, ProductReportConstants.QUERY_VALUE);
        jasperParameter.put(ProductReportConstants.REPORT_NAME, ProductReportConstants.REPORT_NAME_VALUE);
        return jasperParameter;
    }
}