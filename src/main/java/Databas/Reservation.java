package Databas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Reservation {
    String reservationsID;
    String användarID;
    String fysiskKopiaID;
    LocalDate reservationsDatum;

    public Reservation(String användarID, String fysisskKopiaID) {
        this.användarID = användarID;
        this.fysiskKopiaID = fysisskKopiaID;
        this.reservationsDatum = LocalDate.now();
    }

    public void skapaReservationSQL() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement sqlSkapaReservation = connection.createStatement();

            String insertReservation = "INSERT INTO reservation (reservationsDatum, AnvändarId, FysiskkopiaID) " +
                    "VALUES ('" + reservationsDatum + "', " + användarID + ", " + fysiskKopiaID + ");";

            sqlSkapaReservation.executeUpdate(insertReservation);

        }catch (SQLException e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    public String getAnvändarID() {
        return användarID;
    }

    public void setAnvändarID(String användarID) {
        this.användarID = användarID;
    }

    public String getFysisskKopiaID() {
        return fysiskKopiaID;
    }

    public void setFysisskKopiaID(String fysisskKopiaID) {
        this.fysiskKopiaID = fysisskKopiaID;
    }

    public LocalDate getReservationsDatum() {
        return reservationsDatum;
    }

    public void setReservationsDatum(LocalDate reservationsDatum) {
        this.reservationsDatum = reservationsDatum;
    }
}
