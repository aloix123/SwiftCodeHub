package com.example.swiftcode.mapper;

import com.example.swiftcode.dto.BranchDetailsForCountryDto;
import com.example.swiftcode.dto.BranchDto;
import com.example.swiftcode.module.SwiftCodeEntity;

import java.util.List;

public class BranchByCountryMapper {

    public static BranchDetailsForCountryDto ListtoDto(List<SwiftCodeEntity> entities){
        BranchDetailsForCountryDto dto = new BranchDetailsForCountryDto();
        dto.setCountryISO2(entities.get(0).getCountryIso2Code());
        dto.setCountryName(entities.get(0).getCountryName());
        List<BranchDto> swiftCodes=BranchMapper.ListToDto(entities);
        dto.setSwiftCodes(swiftCodes);
        return dto;

    }
}
