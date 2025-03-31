package com.example.swiftcode.service;

import com.example.swiftcode.util.SheetHelper;
import com.example.swiftcode.util.SwiftCodeBuilder;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Component
public class CodeXlsParser implements CommandLineRunner {
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


    @Override
    public void run(String... args) throws Exception {
        try {
            String xlsxFilePath = "files/Interns_2025_SWIFT_CODES.xlsx";
            List<SwiftCodeEntity> swiftCodes = swiftCodeRepository.findAll();
            if (swiftCodes.isEmpty()) {
                parseXlsxFileToDatabase(xlsxFilePath);
            } else {
                System.out.println("Data already exists in the database.");
            }
        } catch (Exception e) {
            System.err.println("Error in CommandLineRunner: " + e.getMessage());
            e.printStackTrace();
        }





    }





}