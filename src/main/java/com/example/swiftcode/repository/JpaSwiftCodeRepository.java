package com.example.swiftcode.repository;

import com.example.swiftcode.module.SwiftCodeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSwiftCodeRepository extends JpaRepository<SwiftCodeEntity,Long> {
    @Query("SELECT COUNT(s) > 0 FROM SwiftCodeEntity s " +
            "WHERE s.swiftCode LIKE CONCAT(SUBSTRING(:swiftCode, 1, 8), '%') " +
            "AND s.swiftCode <> :swiftCode")
    boolean doesSwiftCodehaveBranches(@Param("swiftCode") String swiftCode);


    SwiftCodeEntity findSwiftCodeEntityBySwiftCode(String swiftCode);

    @Query("SELECT s FROM SwiftCodeEntity s " +
            "WHERE s.swiftCode LIKE CONCAT(SUBSTRING(:swiftCode, 1, 8), '%') " +
            "AND s.swiftCode NOT LIKE CONCAT(SUBSTRING(:swiftCode, 1, 8), 'XXX')")
    List<SwiftCodeEntity> findBranchesBySwiftCode(String swiftCode);

    List<SwiftCodeEntity> findAllByCountryIso2Code(String countryIso2Code);

    @Transactional
    void deleteSwiftCodeEntityBySwiftCode(String swiftCode);

    List<SwiftCodeEntity> findAllBySwiftCode(String swiftCode);
}
