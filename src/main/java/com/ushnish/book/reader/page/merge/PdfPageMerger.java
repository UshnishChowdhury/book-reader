package com.ushnish.book.reader.page.merge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import com.ushnish.book.reader.utils.PageUtils;

public class PdfPageMerger {

	private PageUtils getPageUtils() {
		return new PageUtils();
	}
	
	private File createFolder(String absolutePathOfPrintedPages) {
		return new File(absolutePathOfPrintedPages);
	}

	public void mergeAllPages(String bookName) throws IOException {
		PageUtils utils = getPageUtils();
		Path bookPath = utils.makeBookDirectory(bookName);
		String absolutePathOfFiles = utils.getAbsolutePathOfBookDirectory(bookPath);
		File folder = createFolder(absolutePathOfFiles);
		File[] listOfFiles = utils.sortFiles(folder.listFiles());

		PDFMergerUtility pdfMerger = new PDFMergerUtility();
		pdfMerger.setDestinationFileName(absolutePathOfFiles + "\\The Handbook of Public Sector Communication.pdf");
		for (File file : listOfFiles) {
			System.out.println("File Name: " + file.getName());
			pdfMerger.addSource(file);
		}

		pdfMerger.mergeDocuments(null);
	}

}
