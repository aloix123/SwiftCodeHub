package com.example.swiftcode;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.service.SwiftCodeService;
import com.example.swiftcode.util.ReturnHttpUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/swift-codes/")
public class SwiftCodeController {

    private SwiftCodeService swiftCodeService;

    public SwiftCodeController(SwiftCodeService getSwiftCodeDetailsService) {
        this.swiftCodeService = getSwiftCodeDetailsService;
    }

    @GetMapping("{swift-code}")
    public ResponseEntity<?> getSwiftCode(@PathVariable("swift-code") String swiftCode) {
        return ReturnHttpUtil.execute(swiftCodeService.getDetailsOfSingleOne(swiftCode), HttpStatus.OK);
    }

    @GetMapping("country/{countryISO2code}")
    public ResponseEntity<?> getSwiftCodeByCountry(@PathVariable("countryISO2code") String countryISO2code) {
        return ReturnHttpUtil.execute(swiftCodeService.getDetailsOfAllByCountry(countryISO2code), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> putCodeToDatabase(@RequestBody BranchWithcountryNameDto branchWithNameDto){
        swiftCodeService.putSwiftCode(branchWithNameDto);
        return ReturnHttpUtil.executeWithAddedMessage();
    }

    @DeleteMapping("{swift-code}")
    public ResponseEntity<?> deleteSwiftCode(@PathVariable("swift-code") String swiftCode){

        swiftCodeService.deleteSwiftCode(swiftCode);
        return ReturnHttpUtil.executeWithDeletedMessage();
    }
}
