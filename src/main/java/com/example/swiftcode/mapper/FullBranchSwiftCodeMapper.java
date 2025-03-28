package com.example.swiftcode.mapper;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.module.SwiftCodeEntity;

public class FullBranchSwiftCodeMapper {
    public static BranchWithcountryNameDto toDto(SwiftCodeEntity entity){
        BranchWithcountryNameDto dto = new BranchWithcountryNameDto();
        dto.setAddress(entity.getAddress());
        dto.setCountryName(entity.getCountryName());
        dto.setSwiftCode(entity.getSwiftCode());
        dto.setHeadquarter(entity.isHeadquarter());
        dto.setBankName(entity.getName());
        dto.setCountryISO2(entity.getCountryIso2Code());
        return dto;

    }
}
