package com.easy.service.impl;

import com.easy.bean.Ticket;
import com.easy.dao.ITicketDao;
import com.easy.service.ITicketService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
	@Autowired
	private ITicketDao dao;

	public int getCount(Ticket ticket) {
		return dao.getCount(ticket);
	}

	public List<Ticket> getTicket(Ticket ticket, Page page) {
		return dao.getTicket(ticket, page);
	}

	public int delTicket(int id) {
		return dao.delTicket(id);
	}

	public int editTicket(Ticket ticket) {
		return dao.editTicket(ticket);
	}

	public Ticket getTicketByID(int id) {
		return dao.getTicketByID(id);
	}

	public int addTicket(Ticket ticket) {
		return dao.addTicket(ticket);
	}

	public int addList(List<Ticket> ticket) {
		return dao.addList(ticket);
	}
}
