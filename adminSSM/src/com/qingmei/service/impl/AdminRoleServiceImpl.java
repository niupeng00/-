package com.qingmei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qingmei.dao.AdminRoleMapper;
import com.qingmei.dao.AdminRoleModuleMapper;
import com.qingmei.entity.AdminRole;
import com.qingmei.entity.AdminRoleExample;
import com.qingmei.entity.AdminRoleModule;
import com.qingmei.entity.AdminRoleModuleExample;
import com.qingmei.service.AdminRoleService;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

	@Resource
	private AdminRoleMapper  roleDao;	
	
	@Resource
	private AdminRoleModuleMapper  rmDao;
	
	@Override
	public AdminRole getAdminRole(Integer id) {
		
		return this.roleDao.selectByPrimaryKey(id);
			
	}

	@Override
	public List<AdminRoleModule> findRoleModules(Integer id) {
		
		AdminRoleModuleExample  arme = new AdminRoleModuleExample();
		arme.createCriteria().andRoleIdEqualTo(id);
		
		List<AdminRoleModule>  list= this.rmDao.selectByExample(arme);
		
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void savePower(String roleId,String mIds) {				
		//删除旧数据
		AdminRoleModuleExample example = new AdminRoleModuleExample();
		example.createCriteria().andRoleIdEqualTo(Integer.parseInt(  roleId) );
		rmDao.deleteByExample(example );
		
		//保存界面新增打钩的项
		for(String mId :mIds.split(",")){
			if (mId != null && !mId.trim().equals("")){
				AdminRoleModule  rm= new AdminRoleModule();
				
				rm.setModuleId( Integer.parseInt(mId));
				rm.setRoleId( Integer.parseInt(  roleId));
				 
				
				rmDao.insert(rm);
			}
		}
		
		
		
		 
		
	}

	@Override
	public List<AdminRole> getAllRoles() {
		
		AdminRoleExample  are = new AdminRoleExample();
		are.setOrderByClause("create_Time asc");
		
		return this.roleDao.selectByExample(are);
		
	}
	
	
	
	
	
	
	
	

}
