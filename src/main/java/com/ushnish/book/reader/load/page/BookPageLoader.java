package com.ushnish.book.reader.load.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPageLoader {

	public void goToBook(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("The Handbook of Public Sector Communication")).click();
		System.out.println("Current Page Title: " + driver.getTitle());
		Thread.sleep(30000);
		System.out.println("Book loaded successfully");
	}

	public String getPageContent(WebDriver driver) {
		WebElement mainPageElement = driver.findElement(By.id("book-content"));
		return mainPageElement.getText();
	}

}
