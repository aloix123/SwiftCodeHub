package com.example.swiftcode.integrityTest;

import com.example.swiftcode.dto.BranchWithcountryNameDto;
import com.example.swiftcode.exception.Iso2CodeException;
import com.example.swiftcode.exception.NoCountryException;
import com.example.swiftcode.exception.SomeFieldsAreNull;
import com.example.swiftcode.module.SwiftCodeEntity;
import com.example.swiftcode.repository.JpaSwiftCodeRepository;
import com.example.swiftcode.service.SwiftCodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Loads the full Spring Boot application context
@Transactional  // Rolls back transactions after each test (limits side-effects)
@Rollback// Ensures the database is reset after each test
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SwiftCodeServiceIntegrationTests {

    @Autowired
    private SwiftCodeService swiftCodeService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JpaSwiftCodeRepository swiftCodeRepository;


    @Test
    void testGetDetailsOfAllByCountry_withExistingCountry() {
        // Arrange: Insert mock data into the database
        SwiftCodeEntity mockEntity = new SwiftCodeEntity();
        mockEntity.setSwiftCode("PL12345");
        mockEntity.setCountryIso2Code("PL");
        mockEntity.setCountryName("Poland");
        mockEntity.setAddress("Warsaw");
        mockEntity.setCodeType("NATIONAL");
        mockEntity.setName("Polish National Bank");
        swiftCodeRepository.save(mockEntity);

        Object result = swiftCodeService.getDetailsOfAllByCountry("PL");

        assertNotNull(result);

    }

    @Test
    void testIfUserCantAddSomeEmptyFields(){
        BranchWithcountryNameDto swiftCodeEntity = new BranchWithcountryNameDto();
        swiftCodeEntity.setCountryISO2("US");
        assertThrows(SomeFieldsAreNull.class,
                () -> swiftCodeService.putSwiftCode(swiftCodeEntity));

    }


    @Test
    void testGetDetailsOfAllByCountry_withNonExistingCountry() {
        // Act & Assert: Call the service with a non-existing country and expect an exception
        Exception exception = assertThrows(NoCountryException.class,
                () -> swiftCodeService.getDetailsOfAllByCountry("]]"));

        assertTrue(exception.getMessage().contains("No country found"));
    }
    @Test
    void testIso2CodeValidation() {
        BranchWithcountryNameDto swiftCodeEntity = new BranchWithcountryNameDto();
        swiftCodeEntity.setCountryISO2("U");
        assertThrows(Iso2CodeException.class,
                () -> swiftCodeService.putSwiftCode(swiftCodeEntity));
    }
    @Test
    void testAddAndDeleteSwiftCodeIntegration() {
        // Arrange: Add a new SwiftCode entity
        SwiftCodeEntity mockEntity = new SwiftCodeEntity();
        mockEntity.setSwiftCode("PL12345");
        mockEntity.setCountryIso2Code("VV");
        mockEntity.setCountryName("Poland");
        mockEntity.setAddress("Wd");
        mockEntity.setCodeType("NATIONAL");
        mockEntity.setName("Polish National Bank");
        swiftCodeRepository.save(mockEntity);

        // Act: Fetch and verify it exists in the system
        List<SwiftCodeEntity> usEntities = swiftCodeRepository.findAllByCountryIso2Code("VV");
        assertEquals(1, usEntities.size());

        // Act: Delete SwiftCode from the database
        swiftCodeService.deleteSwiftCode("PL12345");

        // Assert: Verify it has been removed
        List<SwiftCodeEntity> usEntitiesAfterDelete = swiftCodeRepository.findAllByCountryIso2Code("VV");
        assertTrue(usEntitiesAfterDelete.isEmpty());
    }

    @Test
    void testGetDetailsOfSingleSwiftCodeWithBranches() {
        SwiftCodeEntity mockEntity = new SwiftCodeEntity();
        mockEntity.setSwiftCode("PL12345");
        mockEntity.setCountryIso2Code("US");
        mockEntity.setCountryName("Poland");
        mockEntity.setAddress("Warsaw");
        mockEntity.setCodeType("NATIONAL");
        mockEntity.setName("Polish National Bank");
        swiftCodeRepository.save(mockEntity);

        // Act: Call the service to get details of the SwiftCode
        Object result = swiftCodeService.getDetailsOfSingleOne("PL12345");

        // Assert: Validate the result
        assertNotNull(result);
    }

    @Test
    void testIfSomeDataIsNotUpperCase(){
        BranchWithcountryNameDto swiftCodeEntity = new BranchWithcountryNameDto();
        swiftCodeEntity.setCountryISO2("pl");
        swiftCodeEntity.setSwiftCode("SW12345");
        swiftCodeEntity.setAddress("pkpdsf");
        swiftCodeEntity.setCountryName("poksfa");
        swiftCodeEntity.setBankName("POLISH Nnatoiao BANK");
        swiftCodeEntity.setHeadquarter(false);
        assertDoesNotThrow(() ->swiftCodeService.putSwiftCode(swiftCodeEntity));
    }
}