package com.easy.dao;

import com.easy.bean.AmusementFacility;
import com.easy.bean.Category;
import com.easy.bean.Ticket;
import com.easy.util.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ICategoryDao {
	int getCount(@Param("category") Category category);

	List<Category> getCategory(@Param("category") Category category, @Param("page") Page page);

	Category getCategoryByID(int id);

	int addCategory(Category category);

	int addList(List<Category> category);

	int delCategory(int id);

	int editCategory(Category category);

	int editCategoryItem(Category category);

	int edit(@Param("id") int id, @Param("category") Category category);

	List<AmusementFacility> getCategoryAmusementFacility();

	List<Ticket> getCategoryTicket();

}
