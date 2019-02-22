package com.utils.utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

/**
 * @author Marcos Santiago Leonardo
 * Meltsan Solutions
 * Description: lee un archivo de excel
 * Date: 2/22/19
 */
public class ExcelReader {
    public static final String PATH_FILE = "/Users/lMarcoss/Downloads/data.xls";

    public static void main(String[] args) {
        try {
            fileReader(PATH_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    private static void fileReader(String pathFile) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(PATH_FILE));
        System.out.println("SHEETS: " + workbook.getNumberOfSheets());


        // Leer hojas o sábanas del excel
        for (Sheet sheet : workbook) {
            System.out.println(sheet.getSheetName());
        }

        // leer primer hoja
        Sheet sheet = workbook.getSheetAt(0);

        // filas de una hola
        for (Row row : sheet) {
            for (Cell cell : row) {
                readCellByType(cell);
            }
        }

    }

    private static void readCellByType(Cell cell) {
        try {
            try {
                System.out.println("cell.getRichStringCellValue():" + cell.getRichStringCellValue());
            } catch (Exception e) {
            }
            try {
                System.out.println("cell.getDateCellValue(): " + cell.getDateCellValue());
            } catch (Exception e) {
            }
            try {
                System.out.println("cell.getCellStyle(): " + cell.getCellStyle());
            } catch (Exception e) {
            }
            try {
                System.out.println("cell.getCellType():" + cell.getCellType());
            } catch (Exception e) {
            }
            try {
                System.out.println("cell.getCellFormula(): " + cell.getCellFormula());
            } catch (Exception e) {
            }
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    System.out.println("NUMERIC");
                    System.out.println(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    System.out.println("BOOLEAN");
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case STRING:
                    System.out.println("STRING");
                    System.out.println(cell.getRichStringCellValue());
                    break;
                case FORMULA:
                    System.out.println("FORMULA");
                    System.out.println(cell.getCellFormula());
                    break;
                case BLANK:
                    System.out.println("BLANK");
                    System.out.println();
                    break;
                case _NONE:
                    System.out.println("_NONE");
                    break;
                default:
                    System.out.println("default");

            }
        } catch (Exception e) {
        }
    }
}
