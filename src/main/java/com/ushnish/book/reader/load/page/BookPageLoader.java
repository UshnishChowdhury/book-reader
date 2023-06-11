package com.ushnish.book.reader.load.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPageLoader {

	public void goToBook(WebDriver driver, String bookTitle) throws InterruptedException {
		driver.findElement(By.xpath(
				"/html/body/div[1]/main/article/div[3]/div/div/div[2]/article/ul/li[1]/article/div/div/div/div[1]/p/a"))
				.click();
		System.out.println("Current Page Title: " + driver.getTitle());
		Thread.sleep(30000);
		System.out.println("Book loaded successfully");
	}

	public WebElement getNextTopic(WebDriver driver) {
		WebElement nextTopicLink = null;
		try {
			System.out.println("Going to next topic...");
			nextTopicLink = driver.findElement(By.xpath("/html/body/div[1]/main/section/div/nav/section/div[3]/a"));
		} catch (NoSuchElementException e) {
			System.out.println("Next Tab not found, book reached its last page.");
		}
		return nextTopicLink;
	}

}
