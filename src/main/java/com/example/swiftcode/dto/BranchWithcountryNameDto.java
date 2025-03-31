package com.example.swiftcode.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "address",
        "bankName",
        "countryISO2",
        "countryName",
        "isHeadquarter",
        "swiftCode"
})

public class BranchWithcountryNameDto extends BranchDto {
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName.toUpperCase();
    }
    public BranchWithcountryNameDto() {}

    public BranchWithcountryNameDto(String address, String bankName, String countryISO2, boolean isHeadquarter, String swiftCode, String countryName) {
        super(address, bankName, countryISO2, isHeadquarter, swiftCode);
        this.countryName = countryName;
    }

    public boolean isSomethingEmpty(){
        if(countryName==null || getBankName()==null || getSwiftCode()==null ||getCountryISO2()==null ){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSomeDataLowwerCase(){
        if(countryName.equals(countryName.toUpperCase()) &&  getSwiftCode().equals(getSwiftCode().toUpperCase()) &&getCountryISO2().equals(getCountryISO2().toUpperCase()) ){
            return false;
        }
        else {
            return true;
        }
    }
}
