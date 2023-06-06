package com.ushnish.book.reader.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

}
