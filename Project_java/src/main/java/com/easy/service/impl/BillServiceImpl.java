package com.easy.service.impl;

import com.easy.bean.Bill;
import com.easy.dao.IBillDao;
import com.easy.service.IBillService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private IBillDao dao;

	public int getCount(Bill bill) {
		return dao.getCount(bill);
	}

	public List<Bill> getBill(Bill bill, Page page) {
		return dao.getBill(bill, page);
	}

	public Bill getBillByID(int id) {
		return dao.getBillByID(id);
	}

	public int addBill(Bill bill) {
		return dao.addBill(bill);
	}

	public int addList(List<Bill> bills) {
		return dao.addList(bills);
	}

	public int delBill(int id) {
		return dao.delBill(id);
	}

	public int editBill(Bill bill) {
		return dao.editBill(bill);
	}

	public int editBillItem(Bill bill) {
		return dao.editBillItem(bill);
	}

	public int edit(int id, Bill bill) {
		return dao.edit(id, bill);
	}
}
