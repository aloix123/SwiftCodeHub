package com.example.swiftcode.service;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.exception.ISO2CodeDoesNotExist;
import com.example.swiftcode.exception.Iso2CodeException;
import com.example.swiftcode.exception.SomeFieldsAreLowwerCase;
import com.example.swiftcode.exception.SomeFieldsAreNull;
import com.example.swiftcode.mapper.FullBranchSwiftCodeMapper;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import com.example.swiftcode.util.Iso2CodeHelper;

import java.util.Arrays;
import java.util.Locale;

public class PutSwiftCodeService {
    private JpaSwiftCodeRepository swiftCodeRepository;

    PutSwiftCodeService(JpaSwiftCodeRepository swiftCodeRepository){
        this.swiftCodeRepository=swiftCodeRepository;
    }
    public void execute(BranchWithcountryNameDto dto){
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

        if(!Iso2CodeHelper.isIso2CodeValid(dto.getCountryISO2())){
            throw new ISO2CodeDoesNotExist(dto.getCountryISO2());
        }

        swiftCodeRepository.save(FullBranchSwiftCodeMapper.toEntity(dto));
    }


}
