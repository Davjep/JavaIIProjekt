package Databas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void skapaReservationSQL() {
        Reservation reservation = new Reservation("456891", "3");
        System.out.println(reservation.getReservationsDatum());
        System.out.println(reservation.getAnvändarID());
        System.out.println(reservation.getFysisskKopiaID());
        reservation.skapaReservationSQL();

    }
}