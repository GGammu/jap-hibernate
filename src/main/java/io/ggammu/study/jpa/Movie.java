package io.ggammu.study.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "MOVIE")
@Entity
public class Movie extends Item{
    private String director;
    private String actor;
}
