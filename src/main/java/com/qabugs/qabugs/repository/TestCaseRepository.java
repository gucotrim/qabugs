package com.qabugs.qabugs.repository;

import com.qabugs.qabugs.model.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TestCaseRepository extends JpaRepository<TestCaseEntity, Long> {
    @Query("SELECT t FROM TestCaseEntity t WHERE t.lastUpdate >= :date")
    List<TestCaseEntity> findAllAfterThatDate(@Param("date") LocalDate date);
}
