package com.qabugs.qabugs.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "test_case")
public class TestCaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_case", updatable = false, unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean tested;

    @Column(nullable = false)
    private boolean passed;

    @Column(name = "number_of_tries", nullable = false)
    private int numberOfTries;

    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;
}
