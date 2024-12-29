package com.easy.service;

import java.util.List;

import com.easy.bean.AmusementType;
import com.easy.util.Page;

public interface IAmusementTypeService {
	int getCount(AmusementType amusementType);
	List<AmusementType> getAmusementType(AmusementType amusementType,Page page);
	AmusementType getAmusementTypeByID(int id);
	int delAmusementType(int id);
	int editAmusementType(AmusementType amusementType);
	int addAmusementType(AmusementType amusementType);
	int addList(List<AmusementType> amusementType);
}
