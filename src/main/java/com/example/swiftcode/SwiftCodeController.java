package com.example.swiftcode;

import com.example.swiftcode.service.SwiftCodeService;
import com.example.swiftcode.service.getSwiftCode.GetSwiftCodeDetailsService;
import com.example.swiftcode.util.ReturnHttpUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/swift-codes/")
public class SwiftCodeController {
    private GetSwiftCodeDetailsService getSwiftCodeDetailsService;

    public SwiftCodeController(GetSwiftCodeDetailsService getSwiftCodeDetailsService) {
        this.getSwiftCodeDetailsService = getSwiftCodeDetailsService;
    }

    @GetMapping("{swift-code}")
    public ResponseEntity<?> getSwiftCode(@PathVariable("swift-code") String swiftCode) {
        return ReturnHttpUtil.execute(getSwiftCodeDetailsService.execute(swiftCode), HttpStatus.OK);
    }
}
