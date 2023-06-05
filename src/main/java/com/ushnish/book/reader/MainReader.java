package com.ushnish.book.reader;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.ushnish.book.reader.initialize.ChromeInitializer;
import com.ushnish.book.reader.load.page.BookPageLoader;
import com.ushnish.book.reader.load.page.PageLoader;
import com.ushnish.book.reader.utils.PageUtils;

public class MainReader {

	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		ChromeInitializer initializer = new ChromeInitializer();
		PageLoader pageLoader = new PageLoader();
		BookPageLoader bookPageLoader = new BookPageLoader();
		PageUtils utils = new PageUtils();
		WebDriver requiredDriver = initializer.initialize();
		pageLoader.loadPage(requiredDriver);
		pageLoader.signIn(requiredDriver);
		bookPageLoader.goToBook(requiredDriver);
		String pageContent = bookPageLoader.getPageContent(requiredDriver);
		pageLoader.stopDriver(requiredDriver);
	}
}
