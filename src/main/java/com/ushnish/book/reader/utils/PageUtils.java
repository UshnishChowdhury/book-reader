package com.ushnish.book.reader.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PrintOptions;

public class PageUtils {

	public Path makeBookDirectory(String bookName) {
		bookName = "./".concat(bookName);
		Path path = Paths.get(bookName);
		try {
			Files.createDirectories(path);
			System.out.println("Directory created successfully: " + path.toString());
		} catch (IOException e) {
			System.err.println("Failed to create directory!" + e.getMessage());

		}
		return path;
	}

	public Pdf printPdf(WebDriver driver) {
		Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());
		return pdf;
	}
	
	public String generatePdfFileName(Path path, int fileNumber) {
		return path.toString() + "/" + fileNumber + ".pdf";
	}

}
