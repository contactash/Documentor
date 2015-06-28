package com.ace.creator;

import com.ace.constants.ProductReportConstants;

import java.io.InputStream;

public class ProductTemplate {

    InputStream getReportTemplate() {
        return getClass().getResourceAsStream(ProductReportConstants.REPORT_XML);
    }
}