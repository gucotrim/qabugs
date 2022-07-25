package com.qabugs.qabugs.service;

import com.qabugs.qabugs.dto.TestCaseDto;
import com.qabugs.qabugs.model.TestCaseEntity;
import com.qabugs.qabugs.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements TestCaseServiceInterface {

    private final TestCaseRepository repository;

    public TestCaseService(TestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestCaseEntity save(TestCaseDto testCaseDto) {
        return repository.save(TestCaseEntity.builder()
                .description(testCaseDto.getDescription())
                .tested(testCaseDto.isTested())
                .passed(testCaseDto.isPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(testCaseDto.getLastUpdate())
                .build());
    }

    @Override
    public List<TestCaseEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TestCaseEntity update(TestCaseDto testCaseDto, Long id) {
        TestCaseEntity testCaseEntity = repository.getReferenceById(id);
        testCaseEntity.setDescription(testCaseDto.getDescription());
        testCaseEntity.setTested(testCaseDto.isTested());
        testCaseEntity.setPassed(testCaseDto.isPassed());
        testCaseEntity.setNumberOfTries(testCaseDto.getNumberOfTries());
        testCaseEntity.setLastUpdate(testCaseDto.getLastUpdate());

        return repository.save(testCaseEntity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<TestCaseEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TestCaseEntity> findAllAfterThatDate(LocalDate date) {
        return repository.findAllAfterThatDate(date);
    }
}
