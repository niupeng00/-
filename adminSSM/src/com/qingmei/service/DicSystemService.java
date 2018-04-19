package com.qingmei.service;

import java.util.List;

import com.qingmei.entity.DicSystem;

/**
 * 用户service接口
 * @author 汤慧龙
 * @vertion 创建日期2017年4月13日
 */
public interface DicSystemService{
    
	//常规方法：取一对象，保存，删除，这是
	
	public DicSystem getDicSystem(Integer id);//取一对象
    
    public int save(DicSystem dicSystem);//保存
    
    public int delete(Integer id);//删除
	
	//以下是特殊的需要单独加的
    public DicSystem getDicSystem(String systemCode);

    /**
     * 删除
     * @param id数组
     */
    public int delete(String[] ids);
    
    

    public List<DicSystem> findList(String title,int pageNum,int pageSize);
    
	public List<DicSystem> findAll();
}
