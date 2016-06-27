package com.ace.creator;

import com.ace.connection.Connections;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

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
    @Mock private ByteArrayOutputStream mockByteArrayOutputStream;
    @Mock private JRPdfExporter mockPdfExporter;
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
        Mockito.when(mockReportGenerator.getExporterType()).thenReturn(mockPdfExporter);

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
        verify(mockReportTemplate, times(1)).setReportParameters();
        verify(mockConnections, times(1)).getConnection();
        verify(mockConnections, times(1)).closeConnection(null);
        assertThat(actualResult, is("Product-Report.pdf"));
        verifyStatic();

        ArgumentCaptor<InputStream> inputStreamArgumentCaptor = ArgumentCaptor.forClass(InputStream.class);
        JasperCompileManager.compileReport(inputStreamArgumentCaptor.capture());

//        InputStream inputStream = inputStreamArgumentCaptor.getValue();
//        assertThat(inputStream, is(notNull()));

        ArgumentCaptor<JasperReport> jasperReportArgumentCaptor = ArgumentCaptor.forClass(JasperReport.class);
        ArgumentCaptor<HashMap> jasperParameterArgumentCaptor = ArgumentCaptor.forClass(HashMap.class);
        ArgumentCaptor<Connection> connectionArgumentCaptor = ArgumentCaptor.forClass(Connection.class);

        JasperFillManager.fillReport(jasperReportArgumentCaptor.capture(), jasperParameterArgumentCaptor.capture(), connectionArgumentCaptor.capture());

//        JasperReport jasperReport = jasperReportArgumentCaptor.getValue();
//        assertThat(jasperReport, is(notNull()));

//         HashMap jasperParameter = jasperParameterArgumentCaptor.getValue();
//        assertThat(jasperParameter, is(notNull()));        r
    }

    @Test
    public void getByteArrayOutputStream() throws Exception {
        ByteArrayOutputStream actualResult = reportBuilder.getByteArrayOutputStream();
        verify(mockPdfExporter, times(1)).exportReport();
        assertThat(actualResult, is(instanceOf(ByteArrayOutputStream.class)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        new ReportBuilder(null);
    }

}