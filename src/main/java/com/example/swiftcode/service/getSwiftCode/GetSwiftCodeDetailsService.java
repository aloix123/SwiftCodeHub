package com.example.swiftcode.service.getSwiftCode;

import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetSwiftCodeDetailsService {
    private  JpaSwiftCodeRepository swiftCodeRepository;
    private  GetSwiftCodeHeadquarterDetailsService getSwiftCodeHeadquarterDetailsService;
    private GetSwiftcodeFullBranchService getSwiftcodeFullBranchService;
    public GetSwiftCodeDetailsService(JpaSwiftCodeRepository swiftCodeRepository) {
        this.swiftCodeRepository = swiftCodeRepository;
        this.getSwiftCodeHeadquarterDetailsService = new GetSwiftCodeHeadquarterDetailsService(swiftCodeRepository);
        this.getSwiftcodeFullBranchService = new GetSwiftcodeFullBranchService(swiftCodeRepository);
    }

    public Object execute(String swiftCode) {
        if(swiftCodeRepository.doesSwiftCodehaveBranches(swiftCode)) {
            getSwiftCodeHeadquarterDetailsService.getByCode(swiftCode);
        }
        return getSwiftcodeFullBranchService.getByCode(swiftCode);
    }
}
