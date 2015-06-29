package com.ace.generators.impl;

import com.ace.constants.ProductTemplateConstants;
import com.ace.constants.ReportConstants;
import com.ace.generators.ReportGenerator;
import com.ace.template.ReportTemplate;
import com.ace.template.impl.ProductTemplate;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class XLSGeneratorTest {

    @Ignore
    @Test
    public void testThatFileNameIsWithXlsExtension() throws Exception {
        ReportGenerator xlsGenerator = new XLSGenerator();
        ReportTemplate productTemplate = new ProductTemplate();
        String actualName = productTemplate.getFileName() + xlsGenerator.getFileExtension();
        String expectedName = ProductTemplateConstants.FILE_NAME + ReportConstants.XLS_EXT;
        assertThat(actualName, is(equalTo(expectedName)));
    }

}