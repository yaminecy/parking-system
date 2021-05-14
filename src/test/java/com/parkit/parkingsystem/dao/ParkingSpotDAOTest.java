package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ParkingSpotDAOTest {

    @DisplayName("Test if the next slot is available")
        @Test
        void getNextAvailableSlot() {
            ParkingSpotDAO parkingSpotDAO=new ParkingSpotDAO();
            ParkingType parkingType=ParkingType.CAR;
            int firstParkingFree=parkingSpotDAO.ParkingFree();
            assertEquals(parkingSpotDAO.getNextAvailableSlot(parkingType),firstParkingFree);
        }
    @DisplayName("Test if the parking spot non availability is updated")
        @Test
        void updateParkingTest() {
            ParkingSpot parkingSpot=new ParkingSpot(1,ParkingType.CAR,false);
            ParkingSpotDAO parkingSpotDAO=new ParkingSpotDAO();
            parkingSpot.setId(2);
            parkingSpot.setAvailable(false);
            assertEquals(parkingSpotDAO.updateParking(parkingSpot),true);
        }
    }
