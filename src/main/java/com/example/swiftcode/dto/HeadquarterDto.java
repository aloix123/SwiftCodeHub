package com.example.swiftcode.dto;


import java.util.List;

public class HeadquarterDto extends BranchWithcountryNameDto {

    private List<BranchDto> branches;
    public HeadquarterDto() {}

    public HeadquarterDto(List<BranchDto> branches) {
        this.branches = branches;
    }

    public HeadquarterDto(String address, String bankName, String countryISO2,
                          boolean isHeadquarter, String swiftCode, List<BranchDto> branches,String countryName) {
        super(address, bankName, countryISO2, isHeadquarter, swiftCode,countryName);
        this.branches = branches;
    }

    public List<BranchDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDto> branches) {
        this.branches = branches;
    }
}
