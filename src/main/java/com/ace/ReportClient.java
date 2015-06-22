package com.ace;

import com.ace.utils.FileUtils;

public class ReportClient {
	
	public static void main(String args[]) {
		ReportCreator reportCreator = new ReportCreator();
//		String fileName = reportCreator.createReport(Constants.PDF_EXT);
		String fileName = reportCreator.createReport(Constants.XLS_EXT);
		FileUtils.openFile(fileName);
	}


}
