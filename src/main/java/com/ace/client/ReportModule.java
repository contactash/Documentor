package com.ace.client;

import com.ace.connection.Connections;
import com.ace.connection.impl.MySQLConnection;
import com.ace.generators.ReportGenerator;
import com.ace.generators.impl.PDFGenerator;
import com.ace.template.ReportTemplate;
import com.ace.template.impl.EmployeeTemplate;
import com.google.inject.AbstractModule;

public class ReportModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReportGenerator.class)
                .to(PDFGenerator.class);

        bind(Connections.class)
                .to(MySQLConnection.class);

        bind(ReportTemplate.class)
                .to(EmployeeTemplate.class);
    }
}
