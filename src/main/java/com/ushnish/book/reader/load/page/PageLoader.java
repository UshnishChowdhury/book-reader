package com.ushnish.book.reader.load.page;

import org.openqa.selenium.WebDriver;

public class PageLoader {
	
	public void loadPage(WebDriver driver) {
		driver.get("http://www.google.com");
		driver.quit();
	}

}
