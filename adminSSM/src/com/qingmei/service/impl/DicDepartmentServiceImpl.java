package com.qingmei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qingmei.dao.DicDepartmentMapper;
import com.qingmei.entity.DicDepartment;
import com.qingmei.entity.DicDepartmentExample;
import com.qingmei.service.DicDepartmentService;
@Service("dicDepartmentService")
public class DicDepartmentServiceImpl implements DicDepartmentService {
    @Resource
	private DicDepartmentMapper dicDepartmentMapper;

    @Override
    public  void save(DicDepartment  depart){
    	if (depart.getId() ==null)
    	   dicDepartmentMapper.insert(depart);
    	else dicDepartmentMapper.updateByPrimaryKey(depart);
    	
    }
    
    
    //根据sortNo 查询数据库 ，看有没有占用sortNo
    public DicDepartment getDepartBySortNo(Integer sortNo){
    	   
    	return  null;
    }

    //修改部门表单界面使用。根据部门id获得部门信息  放到界面待修改
    public  DicDepartment  getDepartById(Integer id){    	
    	return  dicDepartmentMapper.selectByPrimaryKey(id);
    	
    }
    
	@Override
	public List<DicDepartment> findList(Integer pageNo,Integer pageSize){
		
		PageHelper.startPage(pageNo, pageSize);
		
	    DicDepartmentExample  de = new DicDepartmentExample();
		de.setOrderByClause("sort_no"); 
	    
		return dicDepartmentMapper.selectByExample(de) ;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void sortDepartment(List<DicDepartment> sss) {
        for(DicDepartment  di:sss){
        	this.dicDepartmentMapper.updateByPrimaryKey(di);
        }
       
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteDepartments(String ids) {
		for(String  id:ids.split(",")){ //ids:  2,3,4....
			this.dicDepartmentMapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
		
	}

}
