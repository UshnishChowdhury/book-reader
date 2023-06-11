package com.ushnish.book.reader;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.ushnish.book.reader.page.merge.PdfPageMerger;
import com.ushnish.book.reader.print.page.MainPrinter;

public class MainReader {

	private static MainPrinter getMainPrinter() {
		return new MainPrinter();
	}

	private static PdfPageMerger getPdfPageMerger() {
		return new PdfPageMerger();
	}

	public static void main(String args[]) throws InterruptedException, FileNotFoundException, IOException {
		MainPrinter printPages = getMainPrinter();
		printPages.printRequiredPages("");
		PdfPageMerger pdfMerger = getPdfPageMerger();
		pdfMerger.mergeAllPages("");
	}
}
