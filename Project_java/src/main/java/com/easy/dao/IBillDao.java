package com.easy.dao;

import com.easy.bean.Bill;
import com.easy.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IBillDao {
	int getCount(@Param("bill") Bill bill);

	List<Bill> getBill(@Param("bill") Bill bill, @Param("page") Page page);

	Bill getBillByID(int id);

	int addBill(Bill bill);

	int addList(List<Bill> bills);

	int delBill(int id);

	int editBill(Bill bill);

	int editBillItem(Bill bill);

	int edit(@Param("id") int id, @Param("bill") Bill bill);
}
