package com.easy.service;

import com.easy.bean.Bill;
import com.easy.bean.ConsumptionRecord;
import com.easy.bean.Ticket;
import com.easy.util.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IConsumptionRecordService {
	int getCount(ConsumptionRecord consumptionrecord);

	List<ConsumptionRecord> getConsumptionRecord(ConsumptionRecord consumptionrecord, Page page);

	ConsumptionRecord getConsumptionRecordByID(int id);

	int delConsumptionRecord(int id);

	int editConsumptionRecord(ConsumptionRecord consumptionrecord);

	List<Bill> getConsumptionRecordBill();

	List<Ticket> getConsumptionRecordTicket();

	BigDecimal getActualPrice(ConsumptionRecord consumptionrecord);

	List<BigDecimal> getAllPrice(ConsumptionRecord consumptionrecord);

	List<LocalDate> getAllTime(ConsumptionRecord consumptionrecord);
}
