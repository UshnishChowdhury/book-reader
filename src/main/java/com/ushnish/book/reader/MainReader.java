package com.ushnish.book.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ushnish.book.reader.initialize.ChromeInitializer;
import com.ushnish.book.reader.load.page.BookPageLoader;
import com.ushnish.book.reader.load.page.PageLoader;
import com.ushnish.book.reader.print.page.Printer;
import com.ushnish.book.reader.utils.PageUtils;

public class MainReader {

	public static void main(String args[]) throws InterruptedException, FileNotFoundException, IOException {
		PageUtils utils = new PageUtils();
		Path bookPath = utils.makeBookDirectory("The Handbook of Public Sector Communication");
		String absolutePathOfFiles = bookPath.toAbsolutePath().toString().replace("\\.", "");
		File folder = new File(absolutePathOfFiles);
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles, new Comparator<File>() {
			@Override
			public int compare(File firstFile, File secondFile) {
				int n1 = extractNumber(firstFile.getName());
				int n2 = extractNumber(secondFile.getName());
				return n1 - n2;
			}

			private int extractNumber(String name) {
				int i = 0;
				try {
					int e = name.lastIndexOf('.');
					String number = name.substring(0, e);
					i = Integer.parseInt(number);
				} catch (Exception e) {
					i = 0;
				}
				return i;
			}
		});

		PDFMergerUtility pdfMerger = new PDFMergerUtility();
		pdfMerger.setDestinationFileName(absolutePathOfFiles + "\\The Handbook of Public Sector Communication.pdf");
		for (File file : listOfFiles) {
			System.out.println("File Name: " + file.getName());
			pdfMerger.addSource(file);
		}

		pdfMerger.mergeDocuments(null);
	}
}
