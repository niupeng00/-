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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.qingmei.entity.DicDepartment;
import com.qingmei.entity.PagesInfo;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.DicDepartmentService;

/**
 * 部门代码管理
 * 
 * @author 汤慧龙
 * @vertion 创建日期2017年7月8日
 */
@RequestMapping("/dic/department")
@Controller
public class DepartmentAction extends BaseAction {
	@Resource
	private DicDepartmentService dicDepartmentService;

	
//	public static void main(String[] args) {
//		String sss=  "[{'id':'8','sortNo':1,'description':'ssss'},{'id':'2','sortNo':2,'description':'财务部'},{'id':'9','sortNo':3,'description':'sdfsdfsfd'},{'id':'1','sortNo':4,'description':'abc'},{'id':'5','sortNo':5,'description':'制作部'},{'id':'3','sortNo':6,'description':'研发部'},{'id':'4','sortNo':7,'description':'行政部'},{'id':'6','sortNo':8,'description':'ddd'},{'id':'7','sortNo':9,'description':'fffff'},{'id':'10','sortNo':10,'description':'sdfsdfsfd'},{'id':'11','sortNo':11,'description':'gggg'}]";
//		List<DicDepartment> list = new ArrayList<DicDepartment>(); 
//		 JSONArray jsonArray = JSONArray.fromObject(sss);//把String转换为json 
//		 list = (List<DicDepartment>) jsonArray.toCollection(jsonArray,DicDepartment.class );//这里的t是Class<T> 
//
//		 for(DicDepartment d:list){
//			 System.out.println(d.getDescription() );
//		 }
//	}
	@RequestMapping("saveDepartOrders")	
	public void saveDepartOrders(String departs,
			HttpServletResponse response) throws Exception {		
		
		System.out.println(departs  );
		 List<DicDepartment> list = new ArrayList<DicDepartment>(); 
		 JSONArray jsonArray = JSONArray.fromObject(departs);//把String转换为json 
		 list = (List<DicDepartment>) JSONArray.toCollection(jsonArray, DicDepartment.class);//这里的t是Class<T> 

//		 for(DicDepartment  dept:list){
//			 System.out.println(dept.getDescription()+dept.getSortNo() );
//		 }
		 
		this.dicDepartmentService.sortDepartment(list);       
        
		super.sendMessage(response, "alert('保存成功');"
				+ "document.location='list.html';", "js");

	}
	
	
	@RequestMapping("deleteDepartment.html")
	public void deleteDepartment(String  ch, HttpServletResponse resp) throws Exception{
		//System.out.println("---------------"+ch);
		
		this.dicDepartmentService.deleteDepartments(ch);
		this.sendMessage(resp, "alert('保存成功');"
				+ "document.location='list.html';", "js");
		
	}

	@RequestMapping("departmentSort.html")
	public String getDepartmentSortList(Model mm) {
		List<DicDepartment> depts = this.dicDepartmentService.findList(1, 999);
		mm.addAttribute("list", depts);

		return "department/departmentSort";
	}

	@RequestMapping("departmentEdit.html")
	public String getDepartById(HttpServletRequest request, Model model) {
		Integer id = this.getRequestInteger(request, "id", 0);
		DicDepartment ddd = null;  //xxxxx
		int a;                     //yyy
		if (id != 0) {
			ddd = dicDepartmentService.getDepartById(id);
		}
		/*  sdfdfsfsd */
		if (ddd == null)//
			ddd = new DicDepartment();
	
		model.addAttribute("depart", ddd);
		return "department/departEdit";
	}

	/**
	 * 部门信息保存
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editSave.html")
	public void editSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 第一步,获取请求参数
		Integer id = this.getRequestInteger(request, "id", -1);
		String desc = this.getRequestValue(request, "description");
		Integer sortNo = this.getRequestInteger(request, "sortNo", -1);

		DicDepartment dicDepart = dicDepartmentService.getDepartById(id);
		if (dicDepart == null) {

			// 新增的情况，这里先判断代码是否重复
			dicDepart = dicDepartmentService.getDepartBySortNo(sortNo);
			if (dicDepart != null) {
				// 代码重复，返回
				this.sendMessage(response, "alert('代码重复，不能保存')", "js");

			}
			dicDepart = new DicDepartment();// 新增，new一个实体实例
		}
		dicDepart.setDescription(desc);
		if (id != -1) {
			dicDepart.setId(id);
		}

		dicDepart.setSortNo(sortNo);

		dicDepartmentService.save(dicDepart);

		this.sendMessage(response, "alert('保存成功');"
				+ "document.location='list.html';", "js");

	}

	@RequestMapping("/list.html")
	public String list(HttpServletRequest request, Model model)
			throws Exception {

		int pageNum = this.getRequestInteger(request, "pn", 1);
		int pageSize = this.getPageSize(this.getUserFromSession(request));

		List<DicDepartment> list = dicDepartmentService.findList(pageNum,
				pageSize);

		// 分页：利用mybatis插件分页
		Page<?> page = (Page<?>) list;
		PagesInfo pagesInfo = new PagesInfo(page);// 把分页信息放入自己封装的类里
		model.addAttribute("page", pagesInfo.getPagesHtml("?pn=**"));// 获取分页条html
		// ----分页结束

		model.addAttribute("list", list);
		return "department/departmentList";
	}
}
