package com.qabugs.qabugs.service;

import com.qabugs.qabugs.dto.TestCaseDto;
import com.qabugs.qabugs.model.TestCaseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TestCaseServiceInterface {
    TestCaseEntity save(TestCaseDto testCaseDto);
    List<TestCaseEntity> findAll();
    TestCaseEntity update(TestCaseDto testCaseDto, Long id);
    void delete(Long id);
    Optional<TestCaseEntity> findById(Long id);
    List<TestCaseEntity> findAllAfterThatDate(LocalDate date);
}
