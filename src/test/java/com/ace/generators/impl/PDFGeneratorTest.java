package com.ace.generators.impl;

import com.ace.template.ReportTemplate;
import com.ace.template.impl.ProductTemplate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PDFGeneratorTest {

    @Test
    public void testThatFileNameIsWithPDFExtension() throws Exception {
        PDFGenerator pdfGenerator = new PDFGenerator();
        ReportTemplate productTemplate = new ProductTemplate();
        String actualFileName = productTemplate.getFileName() + pdfGenerator.getFileExtension();
        String expectedFileName = "Product-Report.pdf";
        assertEquals(actualFileName, expectedFileName);
        assertThat(actualFileName, is(equalTo(expectedFileName)));
    }
}