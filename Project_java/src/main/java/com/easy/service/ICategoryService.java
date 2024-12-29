package com.easy.service;

import com.easy.bean.AmusementFacility;
import com.easy.bean.Category;
import com.easy.bean.Ticket;
import com.easy.util.Page;

import java.util.List;

public interface ICategoryService {
	int getCount(Category category);

	List<Category> getCategory(Category category, Page page);

	Category getCategoryByID(int id);

	int delCategory(int id);

	int editCategory(Category category);

	int addCategory(Category category);

	int addList(List<Category> category);

	List<AmusementFacility> getCategoryAmusementFacility();

	List<Ticket> getCategoryTicket();
}
