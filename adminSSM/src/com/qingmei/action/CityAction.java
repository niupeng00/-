/****
 * 文件名； 部门管理功能控制器类
 * 版本号；1.0
 * 作者；   啧啧啧
 * 生成日期；2017-08-13
     模块功能:  响应用户界面。。。。请求
                           注册
     
 * 修改记录：  
 * 
 *     2017-08-20 增加注册功能。 啦啦啦
 *     2017-08-20 增加注册功能。 啦啦啦
 *     2017-08-20 增加注册功能。 啦啦啦
 *     2017-08-20 删除注册功能。 啦啦啦
 * ***/


package com.qingmei.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.qingmei.entity.DicDepartment;
import com.qingmei.entity.DicSite;
import com.qingmei.entity.PagesInfo;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.DicCityService;

/**
 * 部门代码管理
 * 
 * @author 汤慧龙
 * @vertion 创建日期2017年7月8日
 */
@RequestMapping("/dic/city")
@Controller
public class CityAction extends BaseAction {
	@Autowired
	private DicCityService dicCityService;
   

	@RequestMapping("/list.html")
	public String list(HttpServletRequest request, Model model)
			throws Exception {

		int pageNum = this.getRequestInteger(request, "pn", 1);
		int pageSize = this.getPageSize(this.getUserFromSession(request));

		List<DicSite> list = dicCityService.findList(pageNum,
				pageSize);

		// 分页：利用mybatis插件分页
		Page<?> page = (Page<?>) list;
		PagesInfo pagesInfo = new PagesInfo(page);// 把分页信息放入自己封装的类里
		model.addAttribute("page", pagesInfo.getPagesHtml("?pn=**"));// 获取分页条html
		// ----分页结束

		model.addAttribute("list", list);
		return "city/cityList";
	}
	
	
	
	
	@RequestMapping("cityEdit.html")
	public String getDepartById(HttpServletRequest request, Model model) {
		Integer id = this.getRequestInteger(request, "id", 0);
		DicSite ddd = new DicSite();   
		                    
		if (id != 0) { //修改时 需要先查询出数据库的数据   返回给界面修改
			ddd = dicCityService.getCityById(id);
		}
		 
		 
		model.addAttribute("depart", ddd);
		return "city/cityEdit";
	}
	
	
	@RequestMapping("/editSave.html")
	public void editSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 第一步,获取请求参数
		Integer id = this.getRequestInteger(request, "id", -1);
		String desc = this.getRequestValue(request, "description");
		Integer sortNo = this.getRequestInteger(request, "sortNo", -1);

		DicSite dicSite = dicCityService.getCityById(id);
		if (dicSite == null) {

			// 新增的情况，这里先判断代码是否重复
			dicSite = dicCityService.getCityBySortNo(sortNo);
			if (dicSite != null) {
				// 代码重复，返回
				this.sendMessage(response, "alert('代码重复，不能保存')", "js");

			}
			dicSite = new DicSite();// 新增，new一个实体实例
		}
		dicSite.setDescription(desc);
		
		
		if (id != -1) {
			dicSite.setId(id);
		}

		dicSite.setSortNo(sortNo);
		
		
		//TODO  界面增加input框  输入 disSIte的属性字段
		dicSite.setAreaCode("111");
		dicSite.setCode("111");
		dicSite.setDescriptionCut("石");
		dicSite.setFirstChar("SJZ");
		dicSite.setPostCode("050000");
		dicSite.setSiteParent("1");
		dicSite.setZoneCode("8");

		dicCityService.save(dicSite);

		this.sendMessage(response, "alert('保存成功');"
				+ "document.location='list.html';", "js");

	}
	
	
}
