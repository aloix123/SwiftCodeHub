package com.example.swiftcode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BranchDto {
    private String address;
    private String bankName;
    private String countryISO2;
    private boolean isHeadquarter;
    private String swiftCode;

    public BranchDto() {}
    public BranchDto(String address, String bankName, String countryISO2, boolean isHeadquarter, String swiftCode) {
        this.address = address;
        this.bankName = bankName;
        this.countryISO2 = countryISO2;
        this.isHeadquarter = isHeadquarter;
        this.swiftCode = swiftCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountryISO2() {
        return countryISO2;
    }

    public void setCountryISO2(String countryISO2) {
        this.countryISO2 = countryISO2;
    }

    public boolean isHeadquarter() {
        return isHeadquarter;
    }

    public void setHeadquarter(boolean headquarter) {
        isHeadquarter = headquarter;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
