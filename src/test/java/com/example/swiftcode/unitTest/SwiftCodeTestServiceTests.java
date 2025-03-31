package com.example.swiftcode.unitTest;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.exception.NoCountryException;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import com.example.swiftcode.service.SwiftCodeService;
import com.example.swiftcode.service.getSwiftCodeService.GetSwiftCodeHeadquarterDetailsService;
import com.example.swiftcode.service.getSwiftCodeService.GetSwiftcodeFullBranchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SwiftCodeServiceTest {

    @Mock
    private JpaSwiftCodeRepository swiftCodeRepository;

    @Mock
    private GetSwiftCodeHeadquarterDetailsService getSwiftCodeHeadquarterDetailsService;

    @Mock
    private GetSwiftcodeFullBranchService getSwiftcodeFullBranchService;

    @InjectMocks
    private SwiftCodeService swiftCodeService;

    @BeforeEach
    void setUp() {
        swiftCodeService = new SwiftCodeService(swiftCodeRepository);
    }

    @Test
    void testPutSwiftCode() {
        BranchWithcountryNameDto dto = new BranchWithcountryNameDto();
        dto.setCountryISO2("PL");
        dto.setSwiftCode("SW12345");
        dto.setAddress("WARSAW");
        dto.setCountryName("POLAND");
        dto.setBankName("POLISH NATIONAL BANK");
        dto.setHeadquarter(false);
        swiftCodeService.putSwiftCode(dto);
        verify(swiftCodeRepository, times(1)).save(any(SwiftCodeEntity.class));
    }

    @Test
    void testDeleteSwiftCode_Success() {
        String swiftCode = "SW12345";
        SwiftCodeEntity mockEntity = new SwiftCodeEntity();
        mockEntity.setSwiftCode(swiftCode);
        mockEntity.setCountryIso2Code("PL");

        when(swiftCodeRepository.findAllBySwiftCode(swiftCode))
                .thenReturn(List.of(mockEntity));

        doNothing().when(swiftCodeRepository).deleteAll(any(List.class));

        assertDoesNotThrow(() -> swiftCodeService.deleteSwiftCode(swiftCode));

        verify(swiftCodeRepository, times(1)).findAllBySwiftCode(swiftCode);
        verify(swiftCodeRepository, times(1)).deleteAll(any(List.class));
    }

    @Test
    void testGetDetailsOfAllByCountry() {
        String existingCountryISO2 = "PL";
        String nonExistingCountryISO2 = "]]";

        SwiftCodeEntity mockedEntity = new SwiftCodeEntity();
        mockedEntity.setSwiftCode("PL12345");
        mockedEntity.setCountryIso2Code("PL");
        mockedEntity.setCountryName("Poland");
        mockedEntity.setAddress("Warsaw");
        mockedEntity.setCodeType("NATIONAL");
        mockedEntity.setName("Polish National Bank");


        when(swiftCodeRepository.findAllByCountryIso2Code(existingCountryISO2))
                .thenReturn(List.of(mockedEntity));

        when(swiftCodeRepository.findAllByCountryIso2Code(nonExistingCountryISO2))
                .thenReturn(List.of());

        Object result = assertDoesNotThrow(() -> swiftCodeService.getDetailsOfAllByCountry(existingCountryISO2));
        assertNotNull(result);

        NoCountryException exception = assertThrows(NoCountryException.class,
                () -> swiftCodeService.getDetailsOfAllByCountry(nonExistingCountryISO2));
        assertEquals("No country found for ISO2 code: ]]",
                exception.getMessage());

        verify(swiftCodeRepository, times(1)).findAllByCountryIso2Code(existingCountryISO2);
        verify(swiftCodeRepository, times(1)).findAllByCountryIso2Code(nonExistingCountryISO2);
    }

}
