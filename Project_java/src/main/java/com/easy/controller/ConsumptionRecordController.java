package com.easy.controller;

import com.easy.bean.Bill;
import com.easy.bean.ConsumptionRecord;
import com.easy.bean.Ticket;
import com.easy.common.CommonResult;
import com.easy.dao.IConsumptionRecordDao;
import com.easy.service.IConsumptionRecordService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class ConsumptionRecordController {

	@Autowired
	private IConsumptionRecordService recordService;

	@Autowired
	private IConsumptionRecordDao recordDao;

	@GetMapping("consumptionrecord")
	public CommonResult getConsumptionRecord(ConsumptionRecord consumptionrecord, Page page) {
		List<ConsumptionRecord> list = recordService.getConsumptionRecord(consumptionrecord, page);
		int count = recordService.getCount(consumptionrecord);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@GetMapping("getallprice")
	public CommonResult getAllPrice(ConsumptionRecord consumptionrecord) {
		List<BigDecimal> price = recordService.getAllPrice(consumptionrecord);
		return CommonResult.success(price);
	}
	
	@GetMapping("getalltime")
	public CommonResult getAllTime(ConsumptionRecord consumptionrecord) {
		List<LocalDate> time = recordService.getAllTime(consumptionrecord);
		return CommonResult.success(time);
	}

	@GetMapping("getbill")
	public CommonResult getConsumptionRecordBill() {
		List<Bill> list = recordService.getConsumptionRecordBill();
		return CommonResult.success(list);
	}

	@GetMapping("getticket")
	public CommonResult getConsumptionRecordTicket() {
		List<Ticket> list = recordService.getConsumptionRecordTicket();
		return CommonResult.success(list);
	}

	@PostMapping("consumptionrecordjson")
	public CommonResult addConsumptionRecord(@RequestBody ConsumptionRecord consumptionrecord) {
		BigDecimal actualPrice = recordService.getActualPrice(consumptionrecord);
		consumptionrecord.setActualprice(actualPrice);
		recordDao.addConsumptionRecord(consumptionrecord);
		return CommonResult.success(consumptionrecord);
	}

	@DeleteMapping("consumptionrecord/{id}")
	public CommonResult delConsumptionRecord(@PathVariable int id) {
		int count = recordService.delConsumptionRecord(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("consumptionrecordjson")
	public CommonResult editConsumptionRecord(@RequestBody ConsumptionRecord consumptionrecord) {
		BigDecimal actualPrice = recordService.getActualPrice(consumptionrecord);
		consumptionrecord.setActualprice(actualPrice);
		int count = recordService.editConsumptionRecord(consumptionrecord);
		return CommonResult.success(consumptionrecord);
	}
}
