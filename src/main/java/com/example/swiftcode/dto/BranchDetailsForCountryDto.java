package com.example.swiftcode.dto;

import java.util.List;

public class BranchDetailsForCountryDto {
    private String countryISO2;
    private String countryName;
    private List<BranchDto> swiftCodes;

    public BranchDetailsForCountryDto(String countryISO2, String countryName, List<BranchDto> swiftCodes) {
        this.countryISO2 = countryISO2;
        this.countryName = countryName;
        this.swiftCodes = swiftCodes;
    }
    public BranchDetailsForCountryDto(){}

    public String getCountryISO2() {
        return countryISO2;
    }

    public void setCountryISO2(String countryISO2) {
        this.countryISO2 = countryISO2.toUpperCase();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName.toUpperCase();
    }

    public List<BranchDto> getSwiftCodes() {
        return swiftCodes;
    }

    public void setSwiftCodes(List<BranchDto> swiftCodes) {
        this.swiftCodes = swiftCodes;
    }
}
