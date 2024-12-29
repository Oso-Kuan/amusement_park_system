package com.easy.dao;

import com.easy.bean.AmusementFacility;
import com.easy.bean.AmusementType;
import com.easy.bean.User;
import com.easy.util.Page;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAmusementFacilityDao {
	int getCount(@Param("amusementfacility") AmusementFacility amusementfacility);

	List<AmusementFacility> getAmusementFacility(@Param("amusementfacility") AmusementFacility amusementfacility,
			@Param("page") Page page);

	AmusementFacility getAmusementFacilityByID(int id);

	int addAmusementFacility(AmusementFacility amusementfacility);

	int addList(List<AmusementFacility> amusementfacilities);

	int delAmusementFacility(int id);

	int editAmusementFacility(AmusementFacility amusementfacility);

	int editAmusementFacilityItem(AmusementFacility amusementfacility);

	int edit(@Param("id") int id, @Param("amusementfacility") AmusementFacility amusementfacility);

	List<String> getAllType();

	int amusementfacilityImg(AmusementFacility amusementfacility);

	List<AmusementType> getAmusementFacilityAmusementType();

}
