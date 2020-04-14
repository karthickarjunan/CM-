package com.cm.checkin;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataUtility {

	public static String ReadExcelData(String sheetname, String TestCaseName, String HeadingName) throws IOException {

		String Sheetname = sheetname;

		String testCaseName = TestCaseName;

		String headingName = HeadingName;

		Cell cell;

		int rowValue;

		int colValue;
		
		String cellValueFetched = "";

		String InputFile = "C:\\Users\\jeeva\\eclipse-workspace1\\CM-ApplicationAutomation\\testData.xlsx";

		FileInputStream file = new FileInputStream(new File(InputFile));

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet(sheetname);

		DataFormatter formatter = new DataFormatter();

		Iterator<Row> rowIterator = sheet.iterator();

		Iterator<Row> rowIterator1 = sheet.iterator();

		Iterator<Row> rowIterator2 = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {

				cell = cellIterator.next();

				switch (cell.getCellType()) {

				
				case NUMERIC:

					String cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());

					if (cellValue.equalsIgnoreCase(headingName)) {

						colValue = cell.getColumnIndex();

						while (rowIterator1.hasNext()) {

							Row rowiterator1 = rowIterator1.next();

							Iterator<Cell> cellIterator1 = rowiterator1.cellIterator();

							while (cellIterator1.hasNext()) {

								Cell cellInner = cellIterator1.next();

								if (cellInner.getStringCellValue().equalsIgnoreCase(testCaseName)) {

									rowValue = cellInner.getRowIndex();

									cellInner = sheet.getRow(rowValue).createCell(colValue);

									XSSFCell cellValue1 = workbook.getSheet(Sheetname).getRow(rowValue)
											.getCell(colValue);

									cellValueFetched = formatter.formatCellValue(cellValue1);

									System.out.println(
											"Data Fetched Successfully from the numeric Sheet" + cellValueFetched);

								}

							}

						}

					}

					break;

					
				case STRING:

					if (cell.getStringCellValue().equalsIgnoreCase(headingName)) {

						colValue = cell.getColumnIndex();

						while (rowIterator2.hasNext()) {

							Row rowiterator2 = rowIterator2.next();

							Iterator<Cell> cellIterator2 = rowiterator2.cellIterator();

							while (cellIterator2.hasNext()) {

								Cell cellInner = cellIterator2.next();

								if (cellInner.getStringCellValue().equalsIgnoreCase(testCaseName)) {

									rowValue = cellInner.getRowIndex();

									XSSFCell cellvalue = workbook.getSheet(Sheetname).getRow(rowValue)
											.getCell(colValue);

									cellValueFetched = formatter.formatCellValue(cellvalue);

									System.out.println(
											"Data Fetched Successfully from the numeric Sheet" + cellValueFetched);

								}

							}

						}

					}

					break;

				}

			}

		}

		return cellValueFetched;

	}

}
