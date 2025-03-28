package com.example.swiftcode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class HeadquarterDto extends BranchDto {
    private List<BranchDto> branches;
    public HeadquarterDto() {}

    public HeadquarterDto(List<BranchDto> branches) {
        this.branches = branches;
    }

    public HeadquarterDto(String address, String bankName, String countryISO2, boolean isHeadquarter, String swiftCode, List<BranchDto> branches) {
        super(address, bankName, countryISO2, isHeadquarter, swiftCode);
        this.branches = branches;
    }

    public List<BranchDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDto> branches) {
        this.branches = branches;
    }
}
