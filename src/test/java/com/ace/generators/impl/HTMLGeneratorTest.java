package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class HTMLGeneratorTest {

    @Test
    public void testFileNameIsWithHTMLExtension() throws Exception {

        HTMLGenerator generator = new HTMLGenerator();
        String actualFileName = generator.getPDFFileName();
        String expectedFileName = ReportConstants.FILE_NAME + ReportConstants.HTML_EXT;
        assertThat(actualFileName, is(equalTo(expectedFileName)));
    }
}