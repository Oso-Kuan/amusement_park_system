package com.easy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.bean.AmusementType;
import com.easy.dao.IAmusementTypeDao;
import com.easy.service.IAmusementTypeService;
import com.easy.util.Page;

@Service
public class AmusementTypeServiceImpl implements IAmusementTypeService{
	
	@Autowired
	private IAmusementTypeDao dao;
	
	public int getCount(AmusementType amusementType) {
		return dao.getCount(amusementType);
	}

	public List<AmusementType> getAmusementType(AmusementType amusementType, Page page) {
		return dao.getAmusementType(amusementType, page);
	}

	public AmusementType getAmusementTypeByID(int id) {
		return dao.getAmusementTypeID(id);
	}

	public int delAmusementType(int id) {
		return dao.delAmusementType(id);
	}

	public int editAmusementType(AmusementType amusementType) {
		return dao.editAmusementType(amusementType);
	}

	public int addAmusementType(AmusementType amusementType) {
		return dao.addAmusementType(amusementType);
	}

	public int addList(List<AmusementType> amusementType) {
		return dao.addList(amusementType);
	}

}
