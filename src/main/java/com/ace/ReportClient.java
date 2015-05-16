package com.ace;

import com.ace.utils.FileUtils;

import java.io.IOException;

public class ReportClient {
	
	public static void main(String[] args) throws IOException {
		ReportCreator report = new ReportCreator();
		String fileName = report.createPDFReport();
        FileUtils.openFile(fileName);
	}

}
