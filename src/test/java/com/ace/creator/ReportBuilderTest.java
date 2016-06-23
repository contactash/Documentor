package com.ace.creator;

import com.ace.connection.Connections;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.InputStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value={JasperCompileManager.class, JasperFillManager.class})
public class ReportBuilderTest {

    @Mock private ReportTemplate mockReportTemplate;
    @Mock private ReportGenerator mockReportGenerator;
    @Mock private JasperPrint mockJasperPrint;
    @Mock private Connections mockConnections;
    @Mock private JasperReport mockJasperReport;
    @Mock private Connection mockConnection;
    @Mock private HashMap<String, Object> mockJasperParameters;
    private ReportBuilder reportBuilder;


    @Before
    public void setUp() throws JRException {
        MockitoAnnotations.initMocks(this);
        reportBuilder = new ReportBuilder(mockReportGenerator);
        reportBuilder.setContentType("application/pdf");
        reportBuilder.setConnections(mockConnections);
        reportBuilder.setReportTemplate(mockReportTemplate);

        Mockito.when(mockReportTemplate.getFileName()).thenReturn("Product-Report");
        Mockito.when(mockReportGenerator.getFileExtension()).thenReturn(".pdf");

        // Add static mocking here
        mockStatic(JasperCompileManager.class);
        when(JasperCompileManager.compileReport(Matchers.any(InputStream.class))).thenReturn(mockJasperReport);

        mockStatic(JasperFillManager.class);
        when(JasperFillManager.fillReport(Matchers.any(JasperReport.class), eq(mockJasperParameters), eq(mockConnection))).thenReturn(mockJasperPrint);
    }

    @Test
    public void createReport() throws Exception {
        //execution
        String actualResult = reportBuilder.createReport();
        //verification
        verify(mockReportTemplate, times(1)).getReportTemplate();
        verify(mockConnections, times(1)).getConnection();
        verify(mockConnections, times(1)).closeConnection(null);
        assertThat(actualResult, is("Product-Report.pdf"));
    }

    @Test
    public void getByteArrayOutputStream() throws Exception {

    }

}