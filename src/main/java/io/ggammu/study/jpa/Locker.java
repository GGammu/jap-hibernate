package io.ggammu.study.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Locker {
    @Id
    @GeneratedValue
    @Column(name = "locker_id")
    private Long id;
    private String name;
}
