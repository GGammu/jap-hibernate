package io.ggammu.study.jpa;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
