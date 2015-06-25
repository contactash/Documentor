package com.ace.generators;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ReportGenerator {
     String generateReport(JasperPrint jasperPrint) throws JRException;
}
