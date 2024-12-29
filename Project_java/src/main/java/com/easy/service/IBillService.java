package com.easy.service;

import com.easy.bean.Bill;
import com.easy.util.Page;

import java.util.List;

public interface IBillService {
	int getCount(Bill bill);

	List<Bill> getBill(Bill bill, Page page);

	Bill getBillByID(int id);

	int addBill(Bill bill);

	int addList(List<Bill> bills);

	int delBill(int id);

	int editBill(Bill bill);
}
