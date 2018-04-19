package com.qingmei.service;

import java.util.List;

import com.qingmei.entity.DicDepartment;

/**
 * 用户service接口
 * @author 汤慧龙
 * @vertion 创建日期2017年4月13日
 */
public interface DicDepartmentService{
    
	
	void deleteDepartments(String ids);
	
	public void sortDepartment(List<DicDepartment> sss);
	public  void save(DicDepartment  depart);
	public DicDepartment getDepartBySortNo(Integer sortNo);
	 public  DicDepartment  getDepartById(Integer id);
	List<DicDepartment> findList(Integer pageNo,Integer pageSize);
    
}
