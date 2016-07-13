package com.walmart.store.recruiting.ticket.service.impl;

import com.walmart.store.recruiting.ticket.domain.SeatHold;
import com.walmart.store.recruiting.ticket.domain.Venue;
import com.walmart.store.recruiting.ticket.service.TicketService;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/**
 * A ticket service implementation.
 */
public class TicketServiceImpl implements TicketService {

    private int seatsAvailable;
    private int seatsReserved;
    private Map<String, SeatHold> seatHoldMap = new HashMap<>();

    public TicketServiceImpl(Venue venue) {
        seatsAvailable = venue.getMaxSeats();
    }

    @Override
    public int numSeatsAvailable() {
        return seatsAvailable;
    }

    public int numSeatsReserved() {
        return this.seatsReserved;
    }

    @Override
    public Optional<SeatHold> findAndHoldSeats(int numSeats) {
    	
        Optional<SeatHold> optionalSeatHold = Optional.empty();
      
       // List<Seat> seatsToBeHold = new ArrayList<Seat>();
	
	
		
        if (seatsAvailable >= numSeats) {
            String holdId = generateId();
//            for(int i=0;i<numSeats;i++){
//            	seatsToBeHold.add(optionalSeatHold.get().setHeldSeatsMap(heldSeatsMap);;
//            }
            SeatHold seatHold = new SeatHold(holdId, numSeats);
            optionalSeatHold = Optional.of(seatHold);
            
            
            
            
            seatHoldMap.put(holdId, seatHold);
            seatsAvailable -= numSeats;
        } 
      
   
        expiration(optionalSeatHold);
        return optionalSeatHold;
    }

    private void expiration(Optional<SeatHold> optionalSeatHold) {
    	
		//make a timer for expiration
    	Timer timer=new Timer();
    	
    	timer.schedule(new TimerTask() {
    		  @Override
    		  public void run() {
    		       			  
    			  for(int i=0;i<optionalSeatHold.get().getNumSeats();i++){
    				  optionalSeatHold.get().getNumSeats();
    				  //On this loop i was to make the seats to setAvailable to true
    				  
    			  }
    			  
    		  }
    		}, 5*1000);
		
	}

	@Override
    public Optional<String> reserveSeats(String seatHoldId) {
        Optional<String> optionalReservation = Optional.empty();;
        SeatHold seatHold = seatHoldMap.get(seatHoldId);
        if (seatHold != null) {
            seatsReserved += seatHold.getNumSeats();
            optionalReservation =  Optional.of(seatHold.getId());
            seatHoldMap.remove(seatHoldId);
        }

        return optionalReservation;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
