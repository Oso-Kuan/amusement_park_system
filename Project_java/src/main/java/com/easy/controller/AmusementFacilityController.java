package com.easy.controller;

import com.alibaba.excel.EasyExcel;
import com.easy.bean.AmusementFacility;
import com.easy.bean.AmusementType;
import com.easy.bean.User;
import com.easy.common.CommonResult;
import com.easy.config.EasyConfig;
import com.easy.config.EasyWebConfig;
import com.easy.dao.IAmusementFacilityDao;
import com.easy.excel.EasyObjExcelListener;
import com.easy.service.IAmusementFacilityService;
import com.easy.util.Page;
import com.easy.util.UploadFileUtil;

import org.ehcache.core.Ehcache.GetAllFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class AmusementFacilityController {

	@Autowired
	private IAmusementFacilityService facilityService;

	@Autowired
	IAmusementFacilityDao dao;

	@GetMapping("amusementfacility")
	public CommonResult getAmusementFacility(AmusementFacility amusementfacility, Page page) {
		List<AmusementFacility> list = facilityService.getAmusementFacility(amusementfacility, page);
		int count = facilityService.getCount(amusementfacility);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@GetMapping("getamusementfacilityamusementtype")
	public CommonResult getAmusementFacilityAmusementType() {
		List<AmusementType> list = facilityService.getAmusementFacilityAmusementType();
		return CommonResult.success(list);
	}

	@PostMapping("amusementfacilityjson")
	public CommonResult addAmusementFacility(@RequestBody AmusementFacility amusementfacility) {
		dao.addAmusementFacility(amusementfacility);
		// amusementfacility=facilityService.getAmusementFacilityByID(amusementfacility.getId());
		return CommonResult.success(amusementfacility);
	}

	@DeleteMapping("amusementfacility/{id}")
	public CommonResult delAmusementFacility(@PathVariable int id) {
		int count = facilityService.delAmusementFacility(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("amusementfacilityjson")
	public CommonResult editAmusementFacilityJson(@RequestBody AmusementFacility amusementfacility) {
		int count = facilityService.editAmusementFacility(amusementfacility);
		// amusementfacility=facilityService.getAmusementFacilityByID(amusementfacility.getId());
		return CommonResult.success(amusementfacility);
	}

	@PutMapping("amusementfacility")
	public String editAmusementFacility(AmusementFacility amusementfacility) {
		dao.editAmusementFacility(amusementfacility);
		return "success";
	}

	@PutMapping("amusementfacilityitem")
	public String editAmusementFacilityItem(AmusementFacility amusementfacility) {
		dao.editAmusementFacilityItem(amusementfacility);
		return "success";
	}

	@GetMapping("amusementfacility/type")
	public List<String> getAllType() {
		return facilityService.getAllType();
	}

	@PostMapping("amusementfacilityimg")
	public CommonResult uploadImg(@RequestParam("file") MultipartFile file) {
		// 存储文件
		String newName = UploadFileUtil.uploadfile(file);
		// 将文件地址存入数据库
		// 返回上传文件的地址 or 返回上传图片的设施数据
		return CommonResult.success(EasyWebConfig.IMAGE_PATH + newName);
	}

	@PutMapping("amusementfacilityimg")
	public CommonResult amusementfacilityImg(AmusementFacility amusementfacility) {
		facilityService.amusementfacilityImg(amusementfacility);
		System.out.println(amusementfacility.getId());
		System.out.println(amusementfacility.getImg());
		return CommonResult.success(amusementfacility);
	}

}
