package io.ggammu.study.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MemberDto {
    private String name;
    private int age;

    public MemberDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
