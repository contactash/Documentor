package com.ace.generators.impl;

import com.ace.constants.ProductTemplateConstants;
import com.ace.constants.ReportConstants;
import com.ace.template.impl.ProductTemplate;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class HTMLGeneratorTest {

    private HTMLGenerator htmlGenerator = new HTMLGenerator();
    private ProductTemplate productTemplate = new ProductTemplate();
    @Mock private JasperPrint jasperPrint;
    private String actualFileName;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        actualFileName = productTemplate.getFileName() + htmlGenerator.getFileExtension();
    }

    @Test
    public void shouldExportReport() throws JRException {
        htmlGenerator.generateReport(jasperPrint, actualFileName);
    }

    @Test
    public void shouldReturnHTMLFileWithExtension() throws Exception {

        String expectedFileName = ProductTemplateConstants.FILE_NAME + ReportConstants.HTML_EXT;
        assertThat(actualFileName, is(equalTo(expectedFileName)));
    }
}