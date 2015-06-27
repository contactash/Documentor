package com.ace.generators.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PDFGeneratorTest {

    @Test
    public void testThatFileNameIsWithPDFExtension() throws Exception {
        PDFGenerator generator = new PDFGenerator();
        String actualFileName = generator.getFileName();
        String expectedFileName = "Product-Report.pdf";
        assertEquals(actualFileName, expectedFileName);
        assertThat(actualFileName, is(equalTo(expectedFileName)));
    }
}