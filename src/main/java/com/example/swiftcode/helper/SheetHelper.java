package com.example.swiftcode.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Component
public class SheetHelper {

    public static Iterator<Row> getRowsFromSheet(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);
        return sheet.iterator();
    }

    public static void skipHeader(Iterator<Row> iterator){
        if(iterator.hasNext()){
            Row row = iterator.next();
        }
    }

    public static String getCellValue(Cell cell) {
        return (cell != null) ? cell.getStringCellValue().trim() : "";
    }

}
