package com.easy.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bean.AmusementType;
import com.easy.common.CommonResult;
import com.easy.dao.IAmusementTypeDao;
import com.easy.service.IAmusementTypeService;
import com.easy.util.Page;

@RestController
@CrossOrigin
public class AmusementTypeController {
	@Autowired
	private IAmusementTypeService amusementTypeService;
	
	@Autowired
	private IAmusementTypeDao amusementTypeDao;
	
	@GetMapping("amusementtype")
	public CommonResult getAmusementType(AmusementType amusementType,Page page) {
		List<AmusementType> list =amusementTypeService.getAmusementType(amusementType,page);
		int count = amusementTypeService.getCount(amusementType);
		HashMap map = new HashMap();
		map.put("list",list);
		map.put("count",count);
		return CommonResult.success(map);
	}
	
	@PostMapping("amusementtypejson")
	public CommonResult addAmusementType(@RequestBody AmusementType amusementType) {
		amusementTypeDao.addAmusementType(amusementType);
		return CommonResult.success(amusementType);
	}
	
	@DeleteMapping("amusementtype/{id}")
	public CommonResult delAmusementType(@PathVariable int id) {
		int count=amusementTypeService.delAmusementType(id);
		if(count>0) {
			return CommonResult.success();
		}else {
			return CommonResult.fail();
		}
	}
	
	@PutMapping("amusementtypejson")
	public CommonResult editAmusementType(@RequestBody AmusementType amusementType) {
		int count=amusementTypeService.editAmusementType(amusementType);
		return CommonResult.success(amusementType);
	}
}
