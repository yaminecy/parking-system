package com.parkit.parkingsystem.model;

import com.parkit.parkingsystem.constants.ParkingType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSpotTest {

    @DisplayName("Test two  available parking car spots are equals ")
    @Test
    public void ParkingSpotTrueEquals() {
        ParkingSpot parkingSpotCar = new ParkingSpot(1, ParkingType.CAR, true);
        ParkingSpot parkingSpotCar2 = new ParkingSpot(1, ParkingType.CAR, true);

        assertTrue(parkingSpotCar.equals(parkingSpotCar2));
    }

    @DisplayName("Test two  available parking car and Bike spots are not equals ")
    @Test
    public void ParkingSpotFalseEquals() {
        ParkingSpot parkingSpotCar = new ParkingSpot(1, ParkingType.CAR, true);
        ParkingSpot parkingSpotBike = new ParkingSpot(2, ParkingType.BIKE, true);

        assertFalse(parkingSpotCar.equals(parkingSpotBike));
    }

}