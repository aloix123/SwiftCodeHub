package com.example.swiftcode.service;

import com.example.swiftcode.util.SheetHelper;
import com.example.swiftcode.util.SwiftCodeBuilder;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;

@Component
public class CodeXlsParser {
    private final JpaSwiftCodeRepository swiftCodeRepository;

    public CodeXlsParser(JpaSwiftCodeRepository swiftCodeRepository) {
        this.swiftCodeRepository = swiftCodeRepository;
    }

    public void parseXlsxFileToDatabase(String filePath) throws IOException {
        Iterator<Row> rowIterator = SheetHelper.getRowsFromSheet(filePath);
        SheetHelper.skipHeader(rowIterator);
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            SwiftCodeEntity entity = SwiftCodeBuilder.buildFromRow(row);
            swiftCodeRepository.save(entity);
        }
    }

    @PostConstruct
    public void init() throws IOException {
        // Path to your XLSX file
        String filePath = "src/main/resources/files/Interns_2025_SWIFT_CODES.xlsx";

        // Call the parse method to load the data into the database
        parseXlsxFileToDatabase(filePath);
    }




}