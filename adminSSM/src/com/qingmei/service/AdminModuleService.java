package com.qingmei.service;

import java.util.List;

import com.qingmei.entity.AdminModule;

public interface AdminModuleService {

	List<AdminModule> getList( );

	List<AdminModule> getTopLeveList();

	

	List<AdminModule> getAllList(Integer mId, Integer pageNum, Integer pageSize);

	AdminModule getModuleById(Integer id);

	void saveModule(AdminModule eeee);

}
