package com.homework.homework14.ex3;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Hobby {
    private String nameOfHobby;
    private int frequency;
    private List<Address> addressList;
}
