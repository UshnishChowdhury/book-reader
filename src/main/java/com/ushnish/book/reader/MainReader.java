package com.ushnish.book.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PrintOptions;

import com.ushnish.book.reader.initialize.ChromeInitializer;
import com.ushnish.book.reader.load.page.BookPageLoader;
import com.ushnish.book.reader.load.page.PageLoader;
import com.ushnish.book.reader.utils.PageUtils;

public class MainReader {

	public static void main(String args[]) throws InterruptedException, FileNotFoundException, IOException {
		ChromeInitializer initializer = new ChromeInitializer();
		PageLoader pageLoader = new PageLoader();
		BookPageLoader bookPageLoader = new BookPageLoader();
		PageUtils utils = new PageUtils();
		WebDriver requiredDriver = initializer.initialize();
		pageLoader.loadPage(requiredDriver);
		pageLoader.signIn(requiredDriver);
		bookPageLoader.goToBook(requiredDriver);
		Path bookPath = utils.makeBookDirectory("The Handbook of Public Sector Communication");
		
		Pdf pdf = ((PrintsPage) requiredDriver).print(new PrintOptions());
		Files.write(Paths.get("./trial.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()),
				StandardOpenOption.CREATE);
		
		pageLoader.stopDriver(requiredDriver);
	}
}
