package com.qabugs.qabugs.controller;

import com.qabugs.qabugs.dto.TestCaseDto;
import com.qabugs.qabugs.model.TestCaseEntity;
import com.qabugs.qabugs.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseEntity> save(@RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.save(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseEntity>> findAll(@RequestParam(value = "last_update", required = false) String date) {
        return date == null ? ResponseEntity.ok(testCaseService.findAll()) : ResponseEntity.ok(testCaseService.findAllAfterThatDate(LocalDate.parse(date)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseEntity> findById(@PathVariable Long id) {
        return testCaseService.findById(id)
                .map(testCase -> ResponseEntity.ok().body(testCase))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return testCaseService.findById(id)
                .map(testCase -> {
                    testCaseService.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseEntity> update(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return testCaseService.findById(id)
                .map(testCase -> ResponseEntity.ok(testCaseService.update(testCaseDto, id)))
                .orElse(ResponseEntity.notFound().build());
    }
}
