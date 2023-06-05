package com.ushnish.book.reader.load.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class PageLoader {

	public void loadPage(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.oreilly.com/member/login");
		System.out.println("Current Page Title: " + driver.getTitle());
	}

	public void signIn(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys(System.getenv("IBM_USERNAME"));
		driver.findElement(By.xpath("/html/body/div[1]/main/section/div[1]/section/section/form/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/main/section/div[1]/section/section/section/button")).click();
		driver.findElement(By.xpath("//*[@id=\"credsDiv\"]")).click();
		driver.findElement(By.name("username")).sendKeys(System.getenv("IBM_USERNAME"));
		driver.findElement(By.xpath("//*[@id=\"password-input\"]")).sendKeys(System.getenv("IBM_PASSWORD"));
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(40000);
		System.out.println("Current Page Title: " + driver.getTitle());
	}

	public void stopDriver(WebDriver driver) {
		driver.close();
		driver.quit();
	}

}
