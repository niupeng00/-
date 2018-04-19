package com.qingmei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qingmei.dao.AdminModuleMapper;
import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminModuleExample;
import com.qingmei.service.AdminModuleService;

@Service
public class AdminModuleServiceImpl implements AdminModuleService {

	@Resource
	private AdminModuleMapper  amDao;
	
	
	
	@Override
	public List<AdminModule> getList( ) {		
		AdminModuleExample ame = new AdminModuleExample();
		ame.setOrderByClause(" showorder desc ");		 
		return this.amDao.selectByExample(ame);
	}



	@Override
	public List<AdminModule> getTopLeveList() {
		AdminModuleExample ame = new AdminModuleExample();
		ame.createCriteria().andParentIdIsNull();
		return    amDao.selectByExample(ame);
		
	}



	@Override
	public List<AdminModule> getAllList(Integer mId,Integer pn,Integer ps) {		 
		PageHelper.startPage(pn, ps); //分页空间 要求的固定写法
		
		//TODO
    	AdminModuleExample ame = new AdminModuleExample();
 		if(mId != null)
    	    ame.createCriteria().andParentIdEqualTo(mId);
		
		return this.amDao.selectByExample(ame);
		
		
		//return  null; // amDao.getAllList( (mId==0?"":mId) +"%");
	}



	@Override
	public AdminModule getModuleById(Integer id) {
		return this.amDao.selectByPrimaryKey(id);
		
	}



	@Override
	public void saveModule(AdminModule eeee) {
		this.amDao.insertSelective(eeee);
		
	}



	 

}
