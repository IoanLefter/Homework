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
public class Album {

    private long id;

    private String name;

    private String description;

    private LocalDate releaseDate;
}