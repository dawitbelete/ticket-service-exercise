package com.walmart.store.recruiting.ticket.main;

import com.walmart.store.recruiting.ticket.domain.Venue;
import com.walmart.store.recruiting.ticket.service.impl.TicketServiceImpl;


public class TicketMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Venue venue=new Venue(1,10,20);
		System.out.println(venue.getRows());
		System.out.println(venue.getMaxSeats());
		
		TicketServiceImpl ticketservice=new TicketServiceImpl(venue);
		ticketservice.findAndHoldSeats(10);
		
		//ticketservice.reserveSeats(10);
		System.out.println(venue.getMaxSeats());
		System.out.println(ticketservice.numSeatsAvailable());
		
		

	}

}
