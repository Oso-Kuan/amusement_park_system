package com.easy.service;

import com.easy.bean.AmusementFacility;
import com.easy.bean.AmusementType;
import com.easy.bean.User;
import com.easy.util.Page;

import java.util.List;

public interface IAmusementFacilityService {
	int getCount(AmusementFacility amusementfacility);

	List<AmusementFacility> getAmusementFacility(AmusementFacility amusementfacility, Page page);

	AmusementFacility getAmusementFacilityByID(int id);

	int delAmusementFacility(int id);

	int editAmusementFacility(AmusementFacility amusementfacility);

	List<String> getAllType();

	int amusementfacilityImg(AmusementFacility amusementfacility);

	List<AmusementType> getAmusementFacilityAmusementType();

}
