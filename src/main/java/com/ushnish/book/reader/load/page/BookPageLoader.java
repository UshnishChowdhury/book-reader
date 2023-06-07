package com.ushnish.book.reader.load.page;

import java.util.NoSuchElementException;

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

	public WebElement getNextTopic(WebDriver driver) {
		WebElement nextTopicLink = null;
		PageLoader pageLoader = new PageLoader();
		try {
			nextTopicLink = driver.findElement(By.xpath("/html/body/div[1]/main/section/div/nav/section/div[3]/a"));
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
			pageLoader.stopDriver(driver);
		}
		return nextTopicLink;
	}

}
