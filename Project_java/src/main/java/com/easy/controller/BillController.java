package com.easy.controller;

import com.easy.bean.Bill;
import com.easy.common.CommonResult;
import com.easy.dao.IBillDao;
import com.easy.service.IBillService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class BillController {

	@Autowired
	private IBillService billService;

	@Autowired
	private IBillDao billDao;

	@GetMapping("bill")
	public CommonResult getBill(Bill bill, Page page) {
		List<Bill> list = billService.getBill(bill, page);
		int count = billService.getCount(bill);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@PostMapping("billjson")
	public CommonResult addBill(@RequestBody Bill bill) {
		billDao.addBill(bill);
		return CommonResult.success(bill);
	}

	@DeleteMapping("bill/{id}")
	public CommonResult delBill(@PathVariable int id) {
		int count = billService.delBill(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("billjson")
	public CommonResult editBill(@RequestBody Bill bill) {
		int count = billService.editBill(bill);
		return CommonResult.success(bill);
	}
}
