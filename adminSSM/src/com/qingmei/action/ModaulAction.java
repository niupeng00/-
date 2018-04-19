package com.qingmei.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.qingmei.entity.AdminModule;
import com.qingmei.entity.PagesInfo;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.AdminModuleService;

@RequestMapping("/sys/module")
@Controller
public class ModaulAction extends  BaseAction {
	
	@Resource
	private AdminModuleService   moduleService;

	@RequestMapping("list.html") // localhost/adminSSM/sys/module/list.html
	public String getListData(Model  map,HttpServletRequest  request){
		
		Integer  mId = this.getRequestInteger(request, "treeKey", null);
		
		//从页面取分页的参数(第几页)
		Integer pageNum = this.getRequestInteger(request, "pn", 1);
		
		//从session取登录用户属性(pageSize)上取  分页大小
		Integer pageSize = this.getUserFromSession(request).getPageSize();
		
		System.out.println(mId);
		System.out.println(pageNum);
		System.out.println(pageSize);
		
		//查询顶级模块列表
		List<AdminModule> topModules= this.moduleService.getTopLeveList();
		
		//查询所有模块列表
		List<AdminModule> modules= this.moduleService.getAllList(mId,pageNum,pageSize);
		
		//分页：利用mybatis插件分页
    	Page<?> page =(Page<?>)modules;
    	PagesInfo pagesInfo =new PagesInfo(page);//把分页信息放入自己封装的类里
    	map.addAttribute("pages", pagesInfo.getPagesHtml("?pn=**"));//获取分页条html
    	  
		
		map.addAttribute("treeKeyA",topModules);
		map.addAttribute("list",modules);
		
		map.addAttribute("treeKey",mId);
		
		return "power/moduleList";
	}
	
	//保存module数据
	@RequestMapping("saveEdit.html")
	public  String  saveModule(@ModelAttribute AdminModule eeee, HttpServletRequest request){
		
		
//		AdminModule ddd = new AdminModule();
//		ddd.setIconurl(super.getRequestValue(request, "iconurl", "") );
//		ddd.setModuleName(super.getRequestValue(request, "moduleName", "菜单名称未定") );
//		ddd.setParentId(super.getRequestInteger( request, "parentId", null) );
//		ddd.setShoworder(super.getRequestValue( request, "showorder", "0"  ) );
//		ddd.setUrl( super.getRequestValue( request, "url", "/"  ) );
		
		this.moduleService.saveModule(eeee);
		
		
		return "forward:list.html";
	}
	
	
	//查询待修改数据
	@RequestMapping("getEdit.html")
	public String getModualById(HttpServletRequest request, Model model) {
		Integer id = this.getRequestInteger(request, "id", 0);
		AdminModule ddd = null;   
		
		if (id != 0) {//修改
			ddd = moduleService.getModuleById(id);
		}
		 
		model.addAttribute("module", ddd);
		
		
		//查询顶级模块列表
		List<AdminModule> topModules= this.moduleService.getTopLeveList();
		model.addAttribute("topModuleList", topModules);		
				
		return "power/moduleEdit";
	} 
}
