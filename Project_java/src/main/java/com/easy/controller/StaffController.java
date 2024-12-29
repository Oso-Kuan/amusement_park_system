package com.easy.controller;

import com.alibaba.excel.EasyExcel;
import com.easy.bean.AmusementFacility;
import com.easy.bean.Staff;
import com.easy.common.CommonResult;
import com.easy.dao.IStaffDao;
import com.easy.excel.EasyObjExcelListener;
import com.easy.service.IStaffService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class StaffController {

	@Autowired
	private IStaffService staffService;

	@Autowired
	private IStaffDao staffDao;

	@GetMapping("staff")
	public CommonResult getStaff(Staff staff, Page page) {
		List<Staff> list = staffService.getStaff(staff, page);
		int count = staffService.getCount(staff);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@PostMapping("staffjson")
	public CommonResult addStaff(@RequestBody Staff staff) {
		staffDao.addStaff(staff);
		return CommonResult.success(staff);
	}

	@DeleteMapping("staff/{id}")
	public CommonResult delStaff(@PathVariable int id) {
		int count = staffService.delStaff(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("staffjson")
	public CommonResult editStaff(@RequestBody Staff staff) {
		int count = staffService.editStaff(staff);
		return CommonResult.success(staff);
	}

	@PostMapping("staffexcel")
	public CommonResult staffexcel(@RequestParam("file") MultipartFile file) throws IOException {
		EasyObjExcelListener<Staff> staffListener = new EasyObjExcelListener<Staff>();
		InputStream fis = file.getInputStream();
		EasyExcel.read(fis, Staff.class, staffListener).sheet(0).doRead();
		System.out.println(staffListener.list);
		return CommonResult.success(staffListener.list);
	}
}
