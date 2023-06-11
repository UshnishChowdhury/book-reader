package com.ushnish.book.reader.print.page;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;

import com.ushnish.book.reader.utils.PageUtils;

public class Printer {

	private PageUtils getPageUtils() {
		return new PageUtils();
	}

	public void printPage(Pdf pdfFile, int fileNumber, Path path) throws IOException {
		PageUtils utils = getPageUtils();
		String generatedFileName = utils.generatePdfFileName(path, fileNumber);
		Files.write(Paths.get(generatedFileName), OutputType.BYTES.convertFromBase64Png(pdfFile.getContent()),
				StandardOpenOption.CREATE);
		System.out.println("File printed successfully : " + generatedFileName);
	}

}
