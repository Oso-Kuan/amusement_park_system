package com.easy.bean;

public class Category {
	private int id;
	private int ticketid;
	private int amusementfacilityid;
	private AmusementFacility amusementfacility;
	private Ticket ticket;

	public int getAmusementfacilityid() {
		return amusementfacilityid;
	}

	public void setAmusementfacilityid(int amusementfacilityid) {
		this.amusementfacilityid = amusementfacilityid;
	}

	public AmusementFacility getAmusementfacility() {
		return amusementfacility;
	}

	public void setAmusementfacility(AmusementFacility amusementfacility) {
		this.amusementfacility = amusementfacility;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
}
