package com.example.swiftcode.service;

import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class SwiftCodeService {
    private JpaSwiftCodeRepository jpaSwiftCodeRepository;

    SwiftCodeService(JpaSwiftCodeRepository jpaSwiftCodeRepository) {
        this.jpaSwiftCodeRepository = jpaSwiftCodeRepository;
    }



    
}
