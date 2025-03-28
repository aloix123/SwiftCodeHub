package com.example.swiftcode.helper;

import com.example.swiftcode.module.SwiftCodeEntity;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

import static com.example.swiftcode.helper.SheetHelper.getCellValue;

public class SwiftCodeBuilder {

    public static SwiftCodeEntity buildFromRow(Row row) {
            String countryIso2Code = getCellValue(row.getCell(0));
            String swiftCode = getCellValue(row.getCell(1));
            String codeType = getCellValue(row.getCell(2));
            String name = getCellValue(row.getCell(3));
            String address = getCellValue(row.getCell(4));
            String townName = getCellValue(row.getCell(5));
            String countryName = getCellValue(row.getCell(6));
            String timeZone = getCellValue(row.getCell(7));

            return new SwiftCodeEntity(countryIso2Code, swiftCode, codeType, name,
                    address, townName, countryName, timeZone);

    }
}
