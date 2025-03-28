package com.example.swiftcode.service.getSwiftCode;

import com.example.swiftcode.dto.BranchDto;
import com.example.swiftcode.dto.HeadquarterDto;
import com.example.swiftcode.mapper.BranchMapper;
import com.example.swiftcode.mapper.HeadquarterMapper;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSwiftCodeHeadquarterDetailsService {
    private JpaSwiftCodeRepository jpaSwiftCodeRepository;

    GetSwiftCodeHeadquarterDetailsService(JpaSwiftCodeRepository jpaSwiftCodeRepository) {
        this.jpaSwiftCodeRepository = jpaSwiftCodeRepository;
    }

    public HeadquarterDto getByCode(String code) {
        SwiftCodeEntity entity=jpaSwiftCodeRepository.findSwiftCodeEntityBySwiftCode(code);
        HeadquarterDto headquarterDto= HeadquarterMapper.toDto(entity);
        List<SwiftCodeEntity> entityBranches=jpaSwiftCodeRepository.findBranchesBySwiftCode(code);
        List<BranchDto> branches=BranchMapper.ListToDto(entityBranches);
        headquarterDto.setBranches(branches);
        return headquarterDto;

    }
}
