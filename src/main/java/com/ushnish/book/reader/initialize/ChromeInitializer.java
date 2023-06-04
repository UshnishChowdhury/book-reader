package com.ushnish.book.reader.initialize;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeInitializer {

	public WebDriver initialize() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "67");
		chromeOptions.setCapability("platformName", "Windows XP");
		WebDriver driver = new RemoteWebDriver(new URL("http://www.example.com"), chromeOptions);
		return driver;
	}

}
