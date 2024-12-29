package com.easy.service.impl;

import com.easy.bean.Staff;
import com.easy.dao.IStaffDao;
import com.easy.service.IStaffService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao dao;

	public int getCount(Staff staff) {
		return dao.getCount(staff);
	}

	public List<Staff> getStaff(Staff staff, Page page) {
		return dao.getStaff(staff, page);
	}

	public int delStaff(int id) {
		return dao.delStaff(id);
	}

	public int editStaff(Staff staff) {
		return dao.editStaff(staff);
	}

	public Staff getStaffByID(int id) {
		return dao.getStaffByID(id);
	}

	public int addStaff(Staff staff) {
		return dao.addStaff(staff);
	}

	public int addList(List<Staff> staff) {
		return dao.addList(staff);
	}
}
