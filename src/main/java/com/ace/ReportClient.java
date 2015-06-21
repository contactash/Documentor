package com.ace;

import com.ace.utils.FileUtils;

import java.io.IOException;

public class ReportClient {
	
	public static void main(String args[]) {
		ReportCreator reportCreator = new ReportCreator();
		String fileName = reportCreator.createPDFReport();
		FileUtils.openFile(fileName);
	}


}
