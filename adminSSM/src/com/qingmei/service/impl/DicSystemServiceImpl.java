package com.qingmei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qingmei.dao.DicSystemMapper;
import com.qingmei.entity.DicSystem;
import com.qingmei.entity.DicSystemExample;
import com.qingmei.service.DicSystemService;
@Service("dicSystemService")
public class DicSystemServiceImpl implements DicSystemService {
    @Resource
	private DicSystemMapper dicSystemMapper;


	@Override
	public DicSystem getDicSystem(Integer id) {
		return this.dicSystemMapper.selectByPrimaryKey(id);
	}
	@Override
	public DicSystem getDicSystem(String systemCode){
		  
		return dicSystemMapper.selectByPrimaryKey(Integer.parseInt( systemCode)  );// .selectByExample(dse);
	}
	

	@Override
	public int delete(Integer id) {
		return dicSystemMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public int delete(String[] ids) {
		Integer id;
		for(int i=0;i<ids.length;i++){
			try{
				id =Integer.valueOf(ids[i]);
			}catch(Exception e){
				id =0;
			}
			if(id>0){				
				dicSystemMapper.deleteByPrimaryKey(id);
			}
		}
		return 1;
	}

	@Override
	public int save(DicSystem dicSystem) {
		if(dicSystem.getId()==null){
			//id为空的是新增
			return this.dicSystemMapper.insert(dicSystem);
		}else{
			//修改
			return this.dicSystemMapper.updateByPrimaryKey(dicSystem);
		}
	}

	
	/**
	 * 用户管理中，取用户列表
	 */
	@Override
	public List<DicSystem> findList(String title,int pageNum,int pageSize){
		if(title=="")
			PageHelper.startPage(pageNum, pageSize);
		
		DicSystemExample  dse = new DicSystemExample();
		dse.createCriteria().andCodeEqualTo(title);
		
		return  dicSystemMapper.selectByExample(dse);
	}
    
	public List<DicSystem> findAll(){
	    return dicSystemMapper.selectByExample(null);
	}

}
