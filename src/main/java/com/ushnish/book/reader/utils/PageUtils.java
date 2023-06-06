package com.ushnish.book.reader.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PageUtils {

	public String[] spiltText(String content) {
		String[] lines = content.split(System.lineSeparator());
		return lines;
	}

	public void writeLines(String lines, String fileName) throws FileNotFoundException, IOException {
		fileName = fileName.concat(".docx");
		try (XWPFDocument doc = new XWPFDocument()) {
			XWPFParagraph paragraph = doc.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runLines = paragraph.createRun();
			runLines.setFontSize(12);
			runLines.setFontFamily("New Roman");
			runLines.setText(lines);
			try (FileOutputStream out = new FileOutputStream(fileName)) {
				doc.write(out);
			}
		}
	}

}
