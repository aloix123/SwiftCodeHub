package com.example.swiftcode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BranchWithcountryNameDto extends BranchDto {
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public BranchWithcountryNameDto() {}

    public BranchWithcountryNameDto(String address, String bankName, String countryISO2, boolean isHeadquarter, String swiftCode, String countryName) {
        super(address, bankName, countryISO2, isHeadquarter, swiftCode);
        this.countryName = countryName;
    }
}
