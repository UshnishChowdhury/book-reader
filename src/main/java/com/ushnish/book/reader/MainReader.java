package com.ushnish.book.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebDriver;

import com.ushnish.book.reader.initialize.ChromeInitializer;
import com.ushnish.book.reader.load.page.BookPageLoader;
import com.ushnish.book.reader.load.page.PageLoader;
import com.ushnish.book.reader.print.page.Printer;
import com.ushnish.book.reader.utils.PageUtils;

public class MainReader {

	public static void main(String args[]) throws InterruptedException, FileNotFoundException, IOException {
		ChromeInitializer initializer = new ChromeInitializer();
		PageLoader pageLoader = new PageLoader();
		BookPageLoader bookPageLoader = new BookPageLoader();
		PageUtils utils = new PageUtils();
		Printer pagePrinter = new Printer();

		WebDriver requiredDriver = initializer.initialize();
		pageLoader.loadPage(requiredDriver);
		pageLoader.signIn(requiredDriver);
		bookPageLoader.goToBook(requiredDriver);

		Path bookPath = utils.makeBookDirectory("The Handbook of Public Sector Communication");
		Pdf pdf = utils.printPdf(requiredDriver);

		pagePrinter.printPage(pdf, 1, bookPath);

		pageLoader.stopDriver(requiredDriver);
	}
}
