package com.easy.service.impl;

import com.easy.bean.AmusementFacility;
import com.easy.bean.AmusementType;
import com.easy.bean.User;
import com.easy.dao.IAmusementFacilityDao;
import com.easy.service.IAmusementFacilityService;
import com.easy.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmusementFacilityServiceImpl implements IAmusementFacilityService {
	@Autowired
	IAmusementFacilityDao dao;

	public int getCount(AmusementFacility amusementfacility) {
		return dao.getCount(amusementfacility);
	}

	public List<AmusementFacility> getAmusementFacility(AmusementFacility amusementfacility, Page page) {
		return dao.getAmusementFacility(amusementfacility, page);
	}

	public int delAmusementFacility(int id) {
		int count = dao.delAmusementFacility(id);
		return count;
	}

	public int editAmusementFacility(AmusementFacility amusementfacility) {
		int count = dao.editAmusementFacility(amusementfacility);
		return count;
	}

	public AmusementFacility getAmusementFacilityByID(int id) {
		return dao.getAmusementFacilityByID(id);
	}

	public List<String> getAllType() {
		return dao.getAllType();
	}

	public int amusementfacilityImg(AmusementFacility amusementfacility) {
		return dao.amusementfacilityImg(amusementfacility);
	}

	public List<AmusementType> getAmusementFacilityAmusementType() {
		return dao.getAmusementFacilityAmusementType();
	}


}
