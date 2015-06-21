package com.ace;

public enum Constant {
    DB_DRIVER("com.mysql.jdbc.Driver"), DB_URL("jdbc:mysql://localhost/classicmodels"), USER("ash"), PASSWORD("password"), QUERY("QUERY"), QUERY_VALUE("select productCode, productName, productLine, productScale, productVendor from products"), REPORT_NAME_VALUE("Product Report"), REPORT_XML("/products.xml"), REPORT_NAME("REPORT_NAME"), FILE_NAME("Product-Report.pdf");
    private String value;

    public String getValue() {
        return value;
    }

    Constant(String value) {
        this.value = value;
    }
}