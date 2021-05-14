package com.parkit.parkingsystem.dao;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TicketDAOTest {

    public static final String vehicleReg = "TEST";

    @DisplayName("Test if ticket is saved in database")
    @Test
    public void saveTicketTest() {

        // GIVEN
        Ticket ticket = new Ticket();
        Date inTime = new Date();
        inTime.setTime(System.currentTimeMillis() - (60 * 60 * 1000));
        ticket.setInTime(inTime);
        ticket.setParkingSpot(new ParkingSpot(2, ParkingType.CAR, false));
        ticket.setVehicleRegNumber(vehicleReg);
        ticket.setPrice(0);
        // WHEN
        TicketDAO ticketDAO = new TicketDAO();
        boolean result = ticketDAO.saveTicket(ticket);
        // THEN
        assertEquals(false, result);
    }

    @DisplayName("Test returning a ticket from database")
    @Test
    public void getTicketTest() {

        // GIVEN
        TicketDAO ticketDAO = new TicketDAO();
        // WHEN
        Ticket ticketReturned = ticketDAO.getTicket(vehicleReg);
        // THEN
        assertEquals(ticketReturned.getClass(), Ticket.class);
    }

    @DisplayName("Test ticket updating in database")
    @Test
    public void updateTicketTest() {

        // GIVEN
        TicketDAO ticketDAO = new TicketDAO();
        // WHEN
        Ticket ticketReturned = ticketDAO.getTicket(vehicleReg);
        ticketReturned.setOutTime(new Date(System.currentTimeMillis()));
        // THEN
        assertEquals(true, ticketDAO.updateTicket(ticketReturned));
    }


}