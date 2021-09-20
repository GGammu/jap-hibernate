package io.ggammu.study.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "ALBUM")
@Entity
public class Album extends Item {
    String artist;
    String etc;
}
