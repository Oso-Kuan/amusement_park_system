package com.easy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.easy.bean.AmusementType;
import com.easy.util.Page;

@Mapper
public interface IAmusementTypeDao {
	int getCount(@Param("amusementtype")AmusementType amusementType);
	List<AmusementType> getAmusementType(@Param("amusementtype")AmusementType amusementType,@Param("page")Page page);
	AmusementType getAmusementTypeID(int id);
	int addAmusementType(AmusementType amusementType);
	int addList(List<AmusementType> amusementType);
	int delAmusementType(int id);
	int editAmusementType(AmusementType amusementType);
	int editAmusementTypeItem(AmusementType amusementType);
	int edit(@Param("id") int id,@Param("amusementtype")AmusementType amusementType);
}
