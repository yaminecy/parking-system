package com.parkit.parkingsystem.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TicketTest {
    @DisplayName("Test ticket in time and out time are not equals")
    @Test
    public void ticketSpotFalseEquals() {
        Ticket ticketIn = new Ticket();
        ticketIn.getInTime();
        Ticket ticketOut = new Ticket();
        ticketOut.getOutTime();

        assertNotEquals(ticketIn, ticketOut);

    }

    @DisplayName("Test the ticket set vehicle number equals the ticket get vehicle number ")
    @Test
    public void ticketSpotTrueEquals() {
        Ticket ticket = new Ticket();
        ticket.setVehicleRegNumber("ABCDEF");

        assertEquals("ABCDEF", ticket.getVehicleRegNumber());
    }

}