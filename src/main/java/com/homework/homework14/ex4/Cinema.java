package com.homework.homework14.ex4;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Cinema {
    private String name;
    private Set<Seat> seats = new HashSet<>();

    public Cinema(String name) {
        this.name = name;

        int numberOfSeatsPerRow = 10;
        int numberOfRows = 10;

        int lastRow = 'A' + (numberOfRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNumber = 1; seatNumber <= numberOfSeatsPerRow; seatNumber++) {
                this.seats.add(new Seat(row + String.valueOf(seatNumber)));
            }
        }
    }

}


