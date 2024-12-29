package com.easy.service;

import com.easy.bean.Staff;
import com.easy.util.Page;

import java.util.List;

public interface IStaffService {
	int getCount(Staff staff);

	List<Staff> getStaff(Staff staff, Page page);

	Staff getStaffByID(int id);

	int delStaff(int id);

	int editStaff(Staff staff);

	int addStaff(Staff staff);

	int addList(List<Staff> staff);
}
