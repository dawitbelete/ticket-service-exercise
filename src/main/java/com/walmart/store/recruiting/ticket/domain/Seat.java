package com.walmart.store.recruiting.ticket.domain;

public class Seat {
	int venueid;
	boolean available;
	boolean hold;
	boolean reserved;
	
	public Seat(int id,boolean available,boolean hold,boolean reserved){
		this.venueid=id;
		this.available=available;
		this.hold=hold;
		this.reserved=reserved;
	}	

	public int getVenueid() {
		return venueid;
	}

	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isHold() {
		return hold;
	}

	public void setHold(boolean hold) {
		this.hold = hold;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

}
