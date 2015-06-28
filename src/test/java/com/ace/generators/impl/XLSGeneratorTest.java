package com.ace.generators.impl;

import com.ace.constants.ProductReportConstants;
import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class XLSGeneratorTest {

    @Ignore
    @Test
    public void testThatFileNameIsWithXlsExtension() throws Exception {
        ReportGenerator generator = new XLSGenerator();
        String actualName = generator.getFileName();
        String expectedName = ProductReportConstants.FILE_NAME + ReportConstants.XLS_EXT;
        assertThat(actualName, is(equalTo(expectedName)));
    }

}