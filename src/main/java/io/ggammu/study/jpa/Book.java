package io.ggammu.study.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "BOOK")
@Entity
public class Book extends Item{
    String author;
    String isbn;
}
