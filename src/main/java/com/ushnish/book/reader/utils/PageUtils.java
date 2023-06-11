package com.ushnish.book.reader.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PrintOptions;

public class PageUtils {

	public Path makeBookDirectory(String bookName) {
		bookName = "./".concat(bookName);
		Path path = Paths.get(bookName);
		try {
			if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS))
				Files.createDirectories(path);
			System.out.println("Directory created successfully: " + path.toString());
		} catch (IOException e) {
			System.err.println("Failed to create directory!" + e.getMessage());

		}
		return path;
	}

	public Pdf printPdf(WebDriver driver) {
		Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());
		System.out.println("PDF printed successfully: " + driver.getTitle());
		return pdf;
	}

	public String generatePdfFileName(Path path, int fileNumber) {
		return path.toString() + "/" + fileNumber + ".pdf";
	}

	public void waitForProcess(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	public String getAbsolutePathOfBookDirectory(Path bookPath) {
		String absolutePathOfFiles = bookPath.toAbsolutePath().toString().replace("\\.", "");
		return absolutePathOfFiles;
	}

	public File[] sortFiles(File[] listOfFiles) {
		Arrays.sort(listOfFiles, new Comparator<File>() {
			@Override
			public int compare(File firstFile, File secondFile) {
				int number1 = extractNumber(firstFile.getName());
				int number2 = extractNumber(secondFile.getName());
				return number1 - number2;
			}

			private int extractNumber(String name) {
				int i = 0;
				try {
					int endPoint = name.lastIndexOf('.');
					String pageNumber = name.substring(0, endPoint);
					i = Integer.parseInt(pageNumber);
				} catch (Exception e) {
					i = 0;
				}
				return i;
			}
		});
		return listOfFiles;
	}
}
