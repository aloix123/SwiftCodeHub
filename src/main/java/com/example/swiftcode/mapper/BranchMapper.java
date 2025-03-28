package com.example.swiftcode.mapper;

import com.example.swiftcode.dto.BranchDto;
import com.example.swiftcode.module.SwiftCodeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BranchMapper {
    public static BranchDto toDto(SwiftCodeEntity entity) {
        BranchDto dto = new BranchDto();
        dto.setAddress(entity.getAddress());
        dto.setHeadquarter(entity.isHeadquarter());
        dto.setBankName(entity.getName());
        dto.setSwiftCode(entity.getSwiftCode());
        dto.setCountryISO2(entity.getCountryIso2Code());
        return dto;
    }
    public static List<BranchDto> ListToDto(List<SwiftCodeEntity> entities) {
        return entities.stream().map(BranchMapper::toDto).toList();
    }
}
