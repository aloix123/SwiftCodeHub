package com.example.swiftcode.service;

import com.example.swiftcode.exception.ISO2CodeDoesNotExist;
import com.example.swiftcode.exception.NoCountryException;
import com.example.swiftcode.mapper.BranchByCountryMapper;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import com.example.swiftcode.util.Iso2CodeHelper;

import java.util.List;

public class GetDetailsOfAllByConutryService {
    private JpaSwiftCodeRepository swiftCodeRepository;

    GetDetailsOfAllByConutryService(JpaSwiftCodeRepository jpaSwiftCodeRepository) {
        this.swiftCodeRepository = jpaSwiftCodeRepository;
    }

    public Object execute(String isoCode){
        List<SwiftCodeEntity> codes = swiftCodeRepository.findAllByCountryIso2Code(isoCode);
        if (codes.isEmpty()) {
            throw new NoCountryException("empty iso" + isoCode);
        }
        if(!Iso2CodeHelper.isIso2CodeValid(isoCode)){
            throw new ISO2CodeDoesNotExist(isoCode);
        }
        return BranchByCountryMapper.ListtoDto(codes);
    }
}
