package com.ace.generators.impl;

import com.ace.constants.ProductTemplateConstants;
import com.ace.constants.ReportConstants;
import com.ace.template.impl.ProductTemplate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class HTMLGeneratorTest {

    @Test
    public void testFileNameIsWithHTMLExtension() throws Exception {

        HTMLGenerator htmlGenerator = new HTMLGenerator();
        ProductTemplate productTemplate = new ProductTemplate();
        String actualFileName = productTemplate.getFileName() + htmlGenerator.getFileExtension();

        String expectedFileName = ProductTemplateConstants.FILE_NAME + ReportConstants.HTML_EXT;
        assertThat(actualFileName, is(equalTo(expectedFileName)));
    }
}