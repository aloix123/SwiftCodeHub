package com.example.swiftcode.service.getSwiftCode;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.mapper.FullBranchSwiftCodeMapper;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetSwiftcodeFullBranchService {
    private JpaSwiftCodeRepository jpaSwiftCodeRepository;

    GetSwiftcodeFullBranchService(JpaSwiftCodeRepository jpaSwiftCodeRepository) {
        this.jpaSwiftCodeRepository = jpaSwiftCodeRepository;
    }
    public BranchWithcountryNameDto getByCode(String swiftcode) {
          SwiftCodeEntity entity=jpaSwiftCodeRepository.findSwiftCodeEntityBySwiftCode(swiftcode);
          return FullBranchSwiftCodeMapper.toDto(entity);
    }
}
