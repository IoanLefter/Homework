package com.homework.homework14.ex4;

import java.util.Iterator;

public class CinemaReservationService {
    public static void main(String[] args) throws Exception {

        Cinema movieplex = new Cinema("Movieplex");
        movieplex.getSeats().stream()
                .forEach(System.out::println);
        System.out.println();

//reserve seat A1
        reserveSeatInCinema(movieplex, "A1");
        //try to reserve a taken seat
        try {
            reserveSeatInCinema(movieplex, "A1");
        } catch (Exception e) {
            System.out.println(e);
        }
        //reserve multiple seats
        reserveSeatInCinema(movieplex, "A2");
        reserveSeatInCinema(movieplex, "A5");
        reserveSeatInCinema(movieplex, "C5");
        reserveSeatInCinema(movieplex, "D5");
        //Cancel reservation for D5
        cancelReservationInCinema(movieplex, "D5");
        //reserve again D5
        reserveSeatInCinema(movieplex, "D5");

        showReservedSeats(movieplex);


    }

    private static void showReservedSeats(Cinema cinema) {
        cinema.getSeats().stream()
                .filter(seat -> seat.isReserved() == true)
                .forEach(System.out::println);
    }

    private static void reserveSeatInCinema(Cinema cinema, String seatNo) throws Exception {
        Iterator<Seat> itr = cinema.getSeats().iterator();
        while (itr.hasNext()) {
            Seat next = itr.next();
            if (next.getSeatNumber().equals(seatNo)) {
                next.reserveSeat();
            }
        }
    }

    private static void cancelReservationInCinema(Cinema cinema, String seatNo) {
        Iterator<Seat> itr = cinema.getSeats().iterator();
        while (itr.hasNext()) {
            Seat next = itr.next();
            if (next.getSeatNumber().equals(seatNo)) {
                next.setReserved(false);
                System.out.println("Reservation for seat " + seatNo + " was canceled.");
            }
        }
    }
}
