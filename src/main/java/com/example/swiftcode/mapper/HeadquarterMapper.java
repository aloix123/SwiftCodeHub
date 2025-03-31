package com.example.swiftcode.mapper;

import com.example.swiftcode.dto.HeadquarterDto;
import com.example.swiftcode.module.SwiftCodeEntity;

public class HeadquarterMapper {
    public static HeadquarterDto toDto(SwiftCodeEntity entity){
        HeadquarterDto dto = new HeadquarterDto();
        dto.setHeadquarter(entity.isHeadquarter());
        dto.setAddress(entity.getAddress());
        dto.setBankName(entity.getName());
        dto.setCountryISO2(entity.getCountryIso2Code());
        dto.setSwiftCode(entity.getSwiftCode());
        dto.setCountryName(entity.getCountryName());
        return dto;
    }
}
