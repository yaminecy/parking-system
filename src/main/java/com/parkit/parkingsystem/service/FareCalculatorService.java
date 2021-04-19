package com.parkit.parkingsystem.service;


import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.Ticket;



public class FareCalculatorService extends TicketDAO {

    public void calculateFare(Ticket ticket) {
        if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
            throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
        }

        int inHour = ticket.getInTime().getHours();
        int outHour = ticket.getOutTime().getHours();



        //TODO: Some tests are failing here. Need to check if this logic is correct
        int duration = outHour - inHour;



        long halfAnHour= 1800000; // conversion of 30 minutes to milliseconds.

        //Free fo 30 minutes.

        if (ticket.getOutTime().getTime() - ticket.getInTime().getTime() <= halfAnHour) {
            System.out.println("Less than 30 Minutes 'It's free' ");
            // -5% for recurrent customers
        } else if (RecurentCustomer(ticket)){
            switch (ticket.getParkingSpot().getParkingType()) {
                case CAR: {
                    ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR*0.95);
                    System.out.println(" You've got -5% discount");
                    break;
                }
                case BIKE: {
                    ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR*0.95);
                    System.out.println(" You've got -5% discount");
                    break;
                }
            }}else{
                switch (ticket.getParkingSpot().getParkingType()) {
                    case CAR: {
                        ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
                        break;
                    }
                    case BIKE: {
                        ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Unkown Parking Type");
                }
            }
        }
    }
