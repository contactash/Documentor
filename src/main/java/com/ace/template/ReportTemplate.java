package com.ace.template;

import java.io.InputStream;
import java.util.HashMap;

//This is interface is so that we can create different types of report template like
// product, sales, order etc

public interface ReportTemplate {

    InputStream getReportTemplate();
    String getFileName();

    HashMap<String,Object> setReportParameters();
}
