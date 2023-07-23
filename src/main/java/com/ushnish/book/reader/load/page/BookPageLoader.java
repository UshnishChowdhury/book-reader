package com.ushnish.book.reader.load.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPageLoader {

	public void goToBook(WebDriver driver, String bookTitle) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/main/div/section[1]/article[1]/div/h2/a")).click();
		System.out.println("Current Page Title: " + driver.getTitle());
		Thread.sleep(30000);
		driver.findElement(By.xpath("/html/body/div[1]/main/section/article/section/section[1]/div[1]/a")).click();
		System.out.println("Current Page Title: " + driver.getTitle());
		Thread.sleep(30000);
		System.out.println("Book loaded successfully");
	}
	
	public void clickViewAll(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/main/section/section[2]/section/div[2]/div/section/div[1]/a"))
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
