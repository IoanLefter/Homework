package com.homework.homework17;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Singer {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Album album;

}