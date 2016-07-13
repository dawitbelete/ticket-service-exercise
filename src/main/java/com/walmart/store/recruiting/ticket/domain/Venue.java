package com.walmart.store.recruiting.ticket.domain;

import java.util.ArrayList;
import java.util.List;

//import VenueReservation.Seat;

/**
 * This class represents a venue where customers can buy tickets to see a show.
 * Our Venue seating is rectangular to simplify things.
 */
public class Venue {

    private final int id;
    private final int rows;
    private final int seatsPerRow;
    
  
    Seat[]seats;

    public Venue(int id, int rows, int seatsPerRow) {
        this.id = id;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    
    
    //I have created all the seats to be available at the first time
    seats=new Seat[(rows * seatsPerRow)];
	for (int seatNo = 1; seatNo <= rows * seatsPerRow; seatNo++) {
		
		seats[seatNo]= new Seat(id, true, false, false);
	}
    }   
    
    
    /**
     * @return the number of rows of seats in the venue
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the number of seats in each row
     */
    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    /**
     * @return the total number of seats in the venue
     */
    public int getMaxSeats() {
        return rows * seatsPerRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        return id == venue.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
