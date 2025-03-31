package com.example.swiftcode.service;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.exception.*;
import com.example.swiftcode.mapper.BranchByCountryMapper;
import com.example.swiftcode.mapper.FullBranchSwiftCodeMapper;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import com.example.swiftcode.service.getSwiftCodeService.GetSwiftCodeHeadquarterDetailsService;
import com.example.swiftcode.service.getSwiftCodeService.GetSwiftcodeFullBranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwiftCodeService {
    private  JpaSwiftCodeRepository swiftCodeRepository;
    private GetSwiftCodeHeadquarterDetailsService getSwiftCodeHeadquarterDetailsService;
    private GetSwiftcodeFullBranchService getSwiftcodeFullBranchService;
    private PutSwiftCodeService putSwiftCodeService;
    public SwiftCodeService(JpaSwiftCodeRepository swiftCodeRepository) {
        this.swiftCodeRepository = swiftCodeRepository;
        this.getSwiftCodeHeadquarterDetailsService = new GetSwiftCodeHeadquarterDetailsService(swiftCodeRepository);
        this.getSwiftcodeFullBranchService = new GetSwiftcodeFullBranchService(swiftCodeRepository);
        this.putSwiftCodeService = new PutSwiftCodeService(swiftCodeRepository);
    }

    public Object getDetailsOfSingleOne(String swiftCode) {
        if(swiftCodeRepository.doesSwiftCodehaveBranches(swiftCode)) {
            return getSwiftCodeHeadquarterDetailsService.getByCode(swiftCode);
        }
        return getSwiftcodeFullBranchService.getByCode(swiftCode);
    }

    public Object getDetailsOfAllByCountry(String isoCode) {
        List<SwiftCodeEntity> codes = swiftCodeRepository.findAllByCountryIso2Code(isoCode);
        if (codes.isEmpty()) {
            throw new NoCountryException("No country found for ISO2 code: " + isoCode);
        }

        return BranchByCountryMapper.ListtoDto(codes);
    }

    public void putSwiftCode(BranchWithcountryNameDto dto) {
        putSwiftCodeService.execute(dto);
    }

    public void deleteSwiftCode(String swiftCode) {
            List<SwiftCodeEntity> entities = swiftCodeRepository.findAllBySwiftCode(swiftCode);

            if (entities.isEmpty()) {
                throw new SwiftCodeNotfound();
            }

            swiftCodeRepository.deleteAll(entities);
        }
    }

