package com.ushnish.book.reader.load.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLoader {

	public void loadPage(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("");
		System.out.println("Current Page Title: " + driver.getTitle());
	}

	public void signIn(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div[1]/main/section/div[1]/section/section/form/button")).click();

	}

	public void stopDriver(WebDriver driver) {
		driver.close();
		driver.quit();
	}

}
