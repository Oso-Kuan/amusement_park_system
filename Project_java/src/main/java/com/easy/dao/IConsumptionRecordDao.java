package com.easy.dao;

import com.easy.bean.Bill;
import com.easy.bean.ConsumptionRecord;
import com.easy.bean.Ticket;
import com.easy.util.Page;

import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface IConsumptionRecordDao {
	int getCount(@Param("consumptionrecord") ConsumptionRecord consumptionrecord);

	List<ConsumptionRecord> getConsumptionRecord(@Param("consumptionrecord") ConsumptionRecord consumptionrecord,
			@Param("page") Page page);

	ConsumptionRecord getConsumptionRecordByID(int id);

	int addConsumptionRecord(ConsumptionRecord consumptionrecord);

	int addList(List<ConsumptionRecord> consumptionrecords);

	int delConsumptionRecord(int id);

	int editConsumptionRecord(ConsumptionRecord consumptionrecord);

	int editConsumptionRecordItem(ConsumptionRecord consumptionrecord);

	int edit(@Param("id") int id, @Param("consumptionrecord") ConsumptionRecord consumptionrecord);

	List<Bill> getConsumptionRecordBill();

	List<Ticket> getConsumptionRecordTicket();

	BigDecimal getPrice(int ticketid);

	BigDecimal getDiscount(int billid);

	BigDecimal getActualPrice(ConsumptionRecord consumptionrecord);

	List<BigDecimal> getAllPrice(ConsumptionRecord consumptionrecord);

	List<LocalDate> getAllTime(ConsumptionRecord consumptionrecord);
}
