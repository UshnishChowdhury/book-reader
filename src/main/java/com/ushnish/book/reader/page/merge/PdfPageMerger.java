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

	private PDFMergerUtility getPDFMergerUtility() {
		return new PDFMergerUtility();
	}

	public void mergeAllPages(String bookName) throws IOException {
		PageUtils utils = getPageUtils();
		Path bookPath = utils.makeBookDirectory(bookName);
		String absolutePathOfFiles = utils.getAbsolutePathOfBookDirectory(bookPath);
		File folder = createFolder(absolutePathOfFiles);
		File[] listOfFiles = utils.sortFiles(folder.listFiles());

		mergePdfFiles(absolutePathOfFiles, listOfFiles, bookName);
	}

	public void mergePdfFiles(String absolutePathOfFiles, File[] listOfFiles, String bookName) throws IOException {
		PDFMergerUtility pdfMerger = getPDFMergerUtility();
		pdfMerger.setDestinationFileName(absolutePathOfFiles + setMergedFileName(bookName));
		for (File file : listOfFiles) {
			pdfMerger.addSource(file);
			System.out.println("File added for merging: " + file.getName());
		}
		pdfMerger.mergeDocuments(null);
		System.out.println("Merging Successful...");
	}

	public String setMergedFileName(String bookName) {
		return "\\" + bookName + ".pdf";
	}

}
