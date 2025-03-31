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

    public SwiftCodeService(JpaSwiftCodeRepository swiftCodeRepository) {
        this.swiftCodeRepository = swiftCodeRepository;
        this.getSwiftCodeHeadquarterDetailsService = new GetSwiftCodeHeadquarterDetailsService(swiftCodeRepository);
        this.getSwiftcodeFullBranchService = new GetSwiftcodeFullBranchService(swiftCodeRepository);
    }

    public Object getDetailsOfSingleOne(String swiftCode) {
        if(swiftCodeRepository.doesSwiftCodehaveBranches(swiftCode)) {
            return getSwiftCodeHeadquarterDetailsService.getByCode(swiftCode);
        }
        return getSwiftcodeFullBranchService.getByCode(swiftCode);
    }

    public Object getDetailsOfAllByCountry(String swiftCode) {
        List<SwiftCodeEntity> codes = swiftCodeRepository.findAllByCountryIso2Code(swiftCode);
        if (codes.isEmpty()) {
            throw new NoCountryException("No country found for ISO2 code: " + swiftCode);
        }
        return BranchByCountryMapper.ListtoDto(codes);
    }

    public void putSwiftCode(BranchWithcountryNameDto dto) {
        if(dto.getCountryISO2().length()!=2){
            throw new Iso2CodeException(
                    "Invalid ISO2 code: " + dto.getCountryISO2());
        }
        if(dto.isSomethingEmpty()){
            throw new SomeFieldsAreNull();
        }

        if(dto.isSomeDataLowwerCase()){
            throw new SomeFieldsAreLowwerCase();
        }
        swiftCodeRepository.save(FullBranchSwiftCodeMapper.toEntity(dto));
    }

    public void deleteSwiftCode(String swiftCode) {
            List<SwiftCodeEntity> entities = swiftCodeRepository.findAllBySwiftCode(swiftCode);

            if (entities.isEmpty()) {
                throw new SwiftCodeNotfound();
            }

            swiftCodeRepository.deleteAll(entities);
        }
    }

