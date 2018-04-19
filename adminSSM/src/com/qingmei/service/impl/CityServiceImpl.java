package com.qingmei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qingmei.dao.DicSiteMapper;
import com.qingmei.entity.DicSite;
import com.qingmei.entity.DicSiteExample;
import com.qingmei.service.DicCityService;

@Service
public class CityServiceImpl  implements  DicCityService{

	@Autowired
	private  DicSiteMapper  dsm;
	
	@Override
	public List<DicSite> findList(int pageNum, int pageSize) {
		 
		PageHelper.startPage(pageNum, pageSize);
		
		return this.dsm.selectByExample(null);
		
		 
	}

	@Override
	public DicSite getCityById(Integer id) {
		
		return this.dsm.selectByPrimaryKey(id);
		
		
	}

	@Override
	public DicSite getCityBySortNo(Integer sortNo) {
		DicSiteExample  dse = new DicSiteExample();
		dse.createCriteria().andSortNoEqualTo(sortNo);
		
		List<DicSite>  dss= this.dsm.selectByExample(dse);
		
		
		
		return dss.size()>0 ?dss.get(0):null;
	}

	@Override
	public void save(DicSite dicSite) {
		 
		 
		
		if (dicSite.getId() ==null)
			this.dsm.insertSelective(dicSite);
	    	else this.dsm.updateByPrimaryKey(dicSite);
		
	}

}
