package com.ace.generators.impl;

import com.ace.constants.ProductReportConstants;
import com.ace.constants.ReportConstants;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class HTMLGeneratorTest {

    @Ignore
    @Test
    public void testFileNameIsWithHTMLExtension() throws Exception {

        HTMLGenerator generator = new HTMLGenerator();
        String actualFileName = generator.getFileName();
        String expectedFileName = ProductReportConstants.FILE_NAME + ReportConstants.HTML_EXT;
        assertThat(actualFileName, is(equalTo(expectedFileName)));
    }
}