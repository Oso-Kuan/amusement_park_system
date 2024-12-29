package com.easy.dao;

import com.easy.bean.Ticket;
import com.easy.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ITicketDao {
	int getCount(@Param("ticket") Ticket ticket);

	List<Ticket> getTicket(@Param("ticket") Ticket ticket, @Param("page") Page page);

	Ticket getTicketByID(int id);

	int addTicket(Ticket ticket);

	int addList(List<Ticket> ticket);

	int delTicket(int id);

	int editTicket(Ticket ticket);

	int editTicketItem(Ticket ticket);

	int edit(@Param("id") int id, @Param("ticket") Ticket ticket);
}
