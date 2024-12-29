package com.easy.controller;

import com.easy.bean.Ticket;
import com.easy.common.CommonResult;
import com.easy.dao.ITicketDao;
import com.easy.service.ITicketService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class TicketController {

	@Autowired
	private ITicketService ticketService;

	@Autowired
	private ITicketDao ticketDao;

	@GetMapping("ticket")
	public CommonResult getTickets(Ticket ticket, Page page) {
		List<Ticket> list = ticketService.getTicket(ticket, page);
		int count = ticketService.getCount(ticket);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@PostMapping("ticketjson")
	public CommonResult addTicket(@RequestBody Ticket ticket) {
		ticketDao.addTicket(ticket);
		return CommonResult.success(ticket);
	}

	@DeleteMapping("ticket/{id}")
	public CommonResult delTicket(@PathVariable int id) {
		int count = ticketService.delTicket(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("ticketjson")
	public CommonResult editTicket(@RequestBody Ticket ticket) {
		int count = ticketService.editTicket(ticket);
		return CommonResult.success(ticket);
	}
}
