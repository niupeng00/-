package com.qingmei.service;

import java.util.List;

import com.qingmei.entity.DicDepartment;
import com.qingmei.entity.DicSite;

public interface DicCityService {

	List<DicSite> findList(int pageNum, int pageSize);

	DicSite getCityById(Integer id);

	DicSite getCityBySortNo(Integer sortNo);

	void save(DicSite dicSite);
   
}
