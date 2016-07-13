package com.walmart.store.recruiting.ticket.domain;

import java.util.Hashtable;
import java.util.List;

//import VenueReservation.Seat;

/**
 * This POJO contains the data relevant to a successful seat hold request, including the seat hold id which
 * may be used later to permanently reserve the seats.
 */
public class SeatHold {

    private String id;
    private int numSeats;
    
    public static Hashtable<String, List<Seat>> getHeldSeatsMap() {
		return heldSeatsMap;
	}

	public static void setHeldSeatsMap(Hashtable<String, List<Seat>> heldSeatsMap) {
		SeatHold.heldSeatsMap = heldSeatsMap;
	}

	//mapped the seathold with list of seats on hold
    public static Hashtable<String,List<Seat>> heldSeatsMap = new Hashtable<String,List<Seat>>();
    

    /**
     * Constructor.
     *
     * @param id the unique hold identifier
     * @param numSeats the number of seats that were held.
     */
    public SeatHold(String id, int numSeats) {
        this.id = id;
        this.numSeats = numSeats;
        //heldSeatsMap.put(id, seats);
    }

    /**
     * @return the seat hold (reservation) id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the number of seats that are being held
     */
    public int getNumSeats() {
        return numSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatHold seatHold = (SeatHold) o;

        return id.equals(seatHold.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
