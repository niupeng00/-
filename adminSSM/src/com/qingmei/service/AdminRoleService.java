package com.qingmei.service;

import java.util.List;

import com.qingmei.entity.AdminRole;
import com.qingmei.entity.AdminRoleModule;

public interface AdminRoleService {
	
	List<AdminRole> getAllRoles();
	void savePower(String rAdd,String rDelete);

	AdminRole getAdminRole(Integer id);

	List<AdminRoleModule> findRoleModules(Integer id);

}
