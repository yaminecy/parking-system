package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;


public class FareCalculatorService {

    public void calculateFare(Ticket ticket) {
        if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
            throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
        }
        /**
         *  @param getOutTime is counted in Milliseconds due to date calculation issue, which gives negative values.
         */
        int oneSecond = 1000; // Second in milliseconds
        int halfAnHour = 1800000; // halfAnHour in milliseconds
        long inHour = ticket.getInTime().getTime() / oneSecond;
        long outHour = ticket.getOutTime().getTime() / oneSecond;
        float a = (outHour - inHour);
        float duration = a / 3600;


        //Free fo 30 minutes.
        if (ticket.getOutTime().getTime() - ticket.getInTime().getTime() <= halfAnHour) {
            System.out.println("Less than 30 Minutes 'It's free' ");
            // -5% discount for recurrent customers
        } else if (ticket.isRecurrentCustomer) {
            switch (ticket.getParkingSpot().getParkingType()) {
                case CAR: {
                    ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR * Fare.DISCOUNT);
                    System.out.println(" You've got -5% discount");
                    break;
                }
                case BIKE: {
                    ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR * Fare.DISCOUNT);
                    System.out.println(" You've got -5% discount");
                    break;
                }
            }
        } else {          // Normal fare calculation
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
