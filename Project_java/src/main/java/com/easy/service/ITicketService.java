package com.easy.service;

import com.easy.bean.Ticket;
import com.easy.util.Page;

import java.util.List;

public interface ITicketService {
	int getCount(Ticket ticket);

	List<Ticket> getTicket(Ticket ticket, Page page);

	Ticket getTicketByID(int id);

	int delTicket(int id);

	int editTicket(Ticket ticket);

	int addTicket(Ticket ticket);

	int addList(List<Ticket> ticket);
}
