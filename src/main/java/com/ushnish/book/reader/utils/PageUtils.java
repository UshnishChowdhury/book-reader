package com.ushnish.book.reader.utils;

public class PageUtils {
	
	public String[] spiltText(String content) {
		String[] lines = content.split(System.lineSeparator());
		return lines;
	}

}
