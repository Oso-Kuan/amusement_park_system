package com.easy.controller;

import com.easy.bean.AmusementFacility;
import com.easy.bean.Bill;
import com.easy.bean.Category;
import com.easy.bean.Ticket;
import com.easy.common.CommonResult;
import com.easy.dao.ICategoryDao;
import com.easy.service.ICategoryService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private ICategoryDao categoryDao;

	@GetMapping("category")
	public CommonResult getCategory(Category category, Page page) {
		List<Category> list = categoryService.getCategory(category, page);
		int count = categoryService.getCount(category);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@GetMapping("getcategoryamusementfacility")
	public CommonResult getCategoryAmusementFacility() {
		List<AmusementFacility> list = categoryService.getCategoryAmusementFacility();
		return CommonResult.success(list);
	}

	@GetMapping("getcategoryticket")
	public CommonResult getCategoryTicket() {
		List<Ticket> list = categoryService.getCategoryTicket();
		return CommonResult.success(list);
	}

	@PostMapping("categoryjson")
	public CommonResult addCategory(@RequestBody Category category) {
		categoryDao.addCategory(category);
		return CommonResult.success(category);
	}

	@DeleteMapping("category/{id}")
	public CommonResult delCategory(@PathVariable int id) {
		int count = categoryService.delCategory(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("categoryjson")
	public CommonResult editCategory(@RequestBody Category category) {
		int count = categoryService.editCategory(category);
		return CommonResult.success(category);
	}
}
