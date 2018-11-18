package com.fis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Akhil Garg Class to print PDF file
 */
public class GeneratePdf {
	/** The resulting PDF file. */
	static Date date = new Date();
	static SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-YYYY_hhmmss");
	static String strDate = simpleFormat.format(date);
	Calendar cal = Calendar.getInstance();
	Date d = cal.getTime();
	public static final String RESULT = "E:/PdfFile_" + strDate + ".pdf";

	/**
	 * Main method.
	 * 
	 * @param args
	 *            no arguments needed
	 * @throws DocumentException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, DocumentException {
		Scanner scanner = new Scanner(System.in);
		String sequence = null;
		int startNumber = 0, lastNumber = 0;
		boolean validateInputs = true;
		try {
			while (validateInputs) {
				System.out.println("");
				System.out.println("*******************Welcome To PDF Generation Program: By AKHIL GARG*******************");
				System.out.println("");
				System.out.println("		Please provide following inputs.");
				System.out.println("");
				while (validateInputs) {
					System.out.print("		1.Enter start sequence: ");
					sequence = scanner.nextLine();
					if (sequence != null && !("").equalsIgnoreCase(sequence.trim())) {
						validateInputs = false;
					} else {
						System.out.println("		Please provide valid input.");
					}
				}
				validateInputs = true;
				while (validateInputs) {
					System.out.print("		2.Enter first number: ");
					String s = scanner.nextLine();
					try {
						startNumber = Integer.parseInt(s.trim());
						validateInputs = false;
					} catch (NumberFormatException e) {
						System.out.println("		Please enter only digits.");
					}
				}
				validateInputs = true;
				while (validateInputs) {
					System.out.print("		3.Enter last number: ");
					String s = scanner.nextLine();
					try {
						lastNumber = Integer.parseInt(s.trim());
						// lastNumber = scanner.nextInt();
						validateInputs = false;
					} catch (NumberFormatException e) {
						System.out.println("		Please enter only digits.");
					}
				}
				if (lastNumber > startNumber) {
					new GeneratePdf().createPdf(sequence.trim(), startNumber, lastNumber, RESULT);
					System.out.println("");
					System.out.println("		Pdf generated at location: " + RESULT);
					System.out.println("");
					System.out.println("*******************PDF Generation Process Successfully Completed********************");
					System.out.println("");
				} else {
					System.out.println("		Range provided is invalid.Please provide all inputs again.");
					validateInputs = true;
				}
			}
		} catch (Exception e) {
			System.out.println("		Error occurred while generating PDF.Please try after sometime.");
		}
	}

	/**
	 * Creates a PDF with information about the movies
	 * 
	 * @param filename
	 *            the name of the PDF file that will be created.
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdf(String str, int start, int end, String filename) throws IOException, DocumentException {
		// step 1
		Document document = new Document(PageSize.A4);
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		// step 3
		document.open();
		// step 4
		document.add(createTable(str, start, end));
		// step 5
		document.close();
	}

	/**
	 * Method to create PDF File
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return PdfPTable object containing table
	 */
	public static PdfPTable createTable(String str, int start, int end) {
		PdfPTable table = new PdfPTable(5);
		PdfPCell cell = new PdfPCell();
		Phrase phrase = new Phrase("");
		for (int i = start; i <= end; i++) {
			phrase = new Phrase(str + "-" + i);
			cell = new PdfPCell();
			table.setWidthPercentage(100);
			cell.setMinimumHeight(21);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPhrase(phrase);
			cell.setBorderWidth(1);

			
			
			table.addCell(cell);
			
			
		}
		return table;
	}
}
