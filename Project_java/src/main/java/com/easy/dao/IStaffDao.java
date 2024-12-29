package com.easy.dao;

import com.easy.bean.Staff;
import com.easy.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IStaffDao {
	int getCount(@Param("staff") Staff staff);

	List<Staff> getStaff(@Param("staff") Staff staff, @Param("page") Page page);

	Staff getStaffByID(int id);

	int addStaff(Staff staff);

	int addList(List<Staff> staff);

	int delStaff(int id);

	int editStaff(Staff staff);

	int editStaffItem(Staff staff);

	int edit(@Param("id") int id, @Param("staff") Staff staff);
}
