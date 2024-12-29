package com.easy.service.impl;

import com.easy.bean.Bill;
import com.easy.bean.ConsumptionRecord;
import com.easy.bean.Ticket;
import com.easy.dao.IConsumptionRecordDao;
import com.easy.service.IConsumptionRecordService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ConsumptionRecordServiceImpl implements IConsumptionRecordService {
	@Autowired
	IConsumptionRecordDao dao;

	public int getCount(ConsumptionRecord consumptionrecord) {
		return dao.getCount(consumptionrecord);
	}

	public List<ConsumptionRecord> getConsumptionRecord(ConsumptionRecord consumptionrecord, Page page) {
		return dao.getConsumptionRecord(consumptionrecord, page);
	}

	public int delConsumptionRecord(int id) {
		return dao.delConsumptionRecord(id);
	}

	public int editConsumptionRecord(ConsumptionRecord consumptionrecord) {
		return dao.editConsumptionRecord(consumptionrecord);
	}

	public ConsumptionRecord getConsumptionRecordByID(int id) {
		return dao.getConsumptionRecordByID(id);
	}

	public List<Bill> getConsumptionRecordBill() {
		return dao.getConsumptionRecordBill();
	}

	public List<Ticket> getConsumptionRecordTicket() {
		return dao.getConsumptionRecordTicket();
	}

	@Transactional
	public BigDecimal getActualPrice(ConsumptionRecord consumptionrecord) {
		BigDecimal aaaprice = dao.getPrice(consumptionrecord.getTicketid());
		System.out.println(aaaprice);
		BigDecimal aaadiscount = dao.getDiscount(consumptionrecord.getBillid());
		System.out.println(aaadiscount);
		BigDecimal result = aaaprice.multiply(aaadiscount);
		System.out.println(result);
		return result;
	}

	public List<BigDecimal> getAllPrice(ConsumptionRecord consumptionrecord) {
		return dao.getAllPrice(consumptionrecord);
	}

	public List<LocalDate> getAllTime(ConsumptionRecord consumptionrecord) {
		return dao.getAllTime(consumptionrecord);
	}

}
