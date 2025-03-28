package com.example.swiftcode.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity

public class SwiftCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_iso2_code", nullable = false, length = 2)
    private String countryIso2Code;

    @Column(name = "swift_code", nullable = false, unique = true, length = 11)
    private String swiftCode;

    @Column(name = "code_type", nullable = false)
    private String codeType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "town_name")
    private String townName;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "time_zone")
    private String timeZone;

    public SwiftCodeEntity(String countryIso2Code, String swiftCode, String codeType, String name,
                           String address, String townName, String countryName, String timeZone) {
        this.countryIso2Code = countryIso2Code;
        this.swiftCode = swiftCode;
        this.codeType = codeType;
        this.name = name;
        this.address = address;
        this.townName = townName;
        this.countryName = countryName;
        this.timeZone = timeZone;
    }

    public String getCountryIso2Code() {
        return countryIso2Code;
    }

    public void setCountryIso2Code(String countryIso2Code) {
        this.countryIso2Code = countryIso2Code;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public SwiftCodeEntity(){}

    public boolean isHeadquarter(){
        String specialHeadquarterIdentifier="XXX";
        return this.swiftCode.endsWith(specialHeadquarterIdentifier);
    }
}
