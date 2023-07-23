package com.ushnish.book.reader.print.page;

import java.nio.file.Path;

import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ushnish.book.reader.initialize.ChromeInitializer;
import com.ushnish.book.reader.load.page.BookPageLoader;
import com.ushnish.book.reader.load.page.PageLoader;
import com.ushnish.book.reader.utils.PageUtils;

public class MainPrinter {

	private ChromeInitializer getChormeInitializer() {
		return new ChromeInitializer();
	}

	private PageLoader getPageLoader() {
		return new PageLoader();
	}

	private BookPageLoader getBookPageLoader() {
		return new BookPageLoader();
	}

	private PageUtils getPageUtils() {
		return new PageUtils();
	}

	private Printer getPrinter() {
		return new Printer();
	}

	public void printRequiredPages(String bookName) {
		ChromeInitializer initializer = getChormeInitializer();
		PageLoader pageLoader = getPageLoader();
		BookPageLoader bookPageLoader = getBookPageLoader();
		PageUtils utils = getPageUtils();
		Printer pagePrinter = getPrinter();
		int fileNumber = 1;
		WebDriver requiredDriver = null;
		try {
			requiredDriver = initializer.initialize();
			pageLoader.loadPage(requiredDriver);
			pageLoader.signIn(requiredDriver);
			
			bookPageLoader.clickViewAll(requiredDriver);
			bookPageLoader.goToBook(requiredDriver, bookName);

			Path bookPath = utils.makeBookDirectory(bookName);

			Pdf pdf = utils.printPdf(requiredDriver);
			pagePrinter.printPage(pdf, fileNumber, bookPath);

			WebElement nextPage = bookPageLoader.getNextTopic(requiredDriver);
			while (nextPage != null) {
				nextPage.click();
				utils.waitForProcess(20000);
				fileNumber++;
				pdf = utils.printPdf(requiredDriver);
				pagePrinter.printPage(pdf, fileNumber, bookPath);
				utils.waitForProcess(10000);
				nextPage = bookPageLoader.getNextTopic(requiredDriver);
			}
			System.out.println("All pages of the book printed successfully of the book: " + bookName);
			pageLoader.stopDriver(requiredDriver);
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
			pageLoader.stopDriver(requiredDriver);
		}
	}
}
