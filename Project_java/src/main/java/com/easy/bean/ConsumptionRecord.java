package com.easy.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConsumptionRecord {
	private int id;
	private int billid;
	private int ticketid;
	private BigDecimal actualprice;
	private int number;
	private LocalDate time;
	private Bill bill;
	private Ticket ticket;
	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public BigDecimal getActualprice() {
		return actualprice;
	}

	public void setActualprice(BigDecimal actualprice) {
		this.actualprice = actualprice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
