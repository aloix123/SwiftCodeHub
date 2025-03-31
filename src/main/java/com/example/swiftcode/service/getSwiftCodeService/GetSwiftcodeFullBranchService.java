package com.example.swiftcode.service.getSwiftCodeService;

import com.example.swiftcode.SwiftCodeController;
import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.exception.SwiftCodeNotfound;
import com.example.swiftcode.mapper.FullBranchSwiftCodeMapper;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSwiftcodeFullBranchService {
    private JpaSwiftCodeRepository jpaSwiftCodeRepository;

    public GetSwiftcodeFullBranchService(JpaSwiftCodeRepository jpaSwiftCodeRepository) {
        this.jpaSwiftCodeRepository = jpaSwiftCodeRepository;
    }
    public BranchWithcountryNameDto getByCode(String swiftcode) {
          SwiftCodeEntity entity=jpaSwiftCodeRepository.findSwiftCodeEntityBySwiftCode(swiftcode);
          if(entity==null){
              throw new SwiftCodeNotfound();
          }
          return FullBranchSwiftCodeMapper.toDto(entity);
    }
}
