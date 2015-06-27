package com.ace.generators.impl;

import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class XLSGeneratorTest {

    @Test
    public void testThatFileNameIsWithXlsExtension() throws Exception {
        XLSGenerator generator = new XLSGenerator();
        String actualName = generator.getFileName();
        String expectedName = ReportConstants.FILE_NAME + ReportConstants.XLS_EXT;
        assertThat(actualName, is(equalTo(expectedName)));
    }

}