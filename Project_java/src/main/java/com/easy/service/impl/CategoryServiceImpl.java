package com.easy.service.impl;

import com.easy.bean.AmusementFacility;
import com.easy.bean.Category;
import com.easy.bean.Ticket;
import com.easy.dao.ICategoryDao;
import com.easy.service.ICategoryService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryDao dao;

	public int getCount(Category category) {
		return dao.getCount(category);
	}

	public List<Category> getCategory(Category category, Page page) {
		return dao.getCategory(category, page);
	}

	public int delCategory(int id) {
		return dao.delCategory(id);
	}

	public int editCategory(Category category) {
		return dao.editCategory(category);
	}

	public Category getCategoryByID(int id) {
		return dao.getCategoryByID(id);
	}

	public int addCategory(Category category) {
		return dao.addCategory(category);
	}

	public int addList(List<Category> category) {
		return dao.addList(category);
	}

	public List<AmusementFacility> getCategoryAmusementFacility() {
		return dao.getCategoryAmusementFacility();
	}

	public List<Ticket> getCategoryTicket() {
		return dao.getCategoryTicket();
	}

}
