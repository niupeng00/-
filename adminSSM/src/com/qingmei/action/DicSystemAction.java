package com.qingmei.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.qingmei.entity.DicSystem;
import com.qingmei.entity.PagesInfo;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.DicSystemService;

/**
 * 系统代码管理的ACTION类 
 * @author 汤慧龙
 * @vertion 创建日期2017年4月13日
 */
@RequestMapping("/dic/system")
@Controller
public class DicSystemAction extends BaseAction {
	@Resource
	private DicSystemService dicSystemService;
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list.html")
	public String list( HttpServletRequest request,Model model) throws Exception{
        //System.out.println("============");
	    //第一步，接收客户端请求参数，列表参数：1、当前页码，2、查询条件值		
		String title =this.getRequestValue(request,"title");//接收客户端查询条件
		int pageNum =this.getRequestInteger(request, "pn", 1);
		
        //第二步，调用业务逻辑,执行查询
		int pageSize =this.getPageSize(this.getUserFromSession(request));
    	List<DicSystem> list =dicSystemService.findList(title,pageNum,pageSize);
    	
    	//分页：利用mybatis插件分页
    	Page<?> page =(Page<?>)list;
    	PagesInfo pagesInfo =new PagesInfo(page);//把分页信息放入自己封装的类里
    	model.addAttribute("page", pagesInfo.getPagesHtml("?pn=**"));//获取分页条html
    	//----分页结束    	
    	
    	//第三步，把结果放入request容器，传递给jsp让jsp展现数据，这里model是控制器的实例变量，
        model.addAttribute("list",list);//当前页要展现的详细数据记录list
        model.addAttribute("title", title);
		return "dic/sysList"; ///WEB-INF/pages/dic/sysList.jsp
	}
	
	
	
	
	/**
	 * 编辑页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit.html")
	public String edit(HttpServletRequest request,Model model) throws Exception{
	    //第一步，接收客户端请求的参数记录id
		Integer id =null;		
		try{
			id =Integer.valueOf(this.getRequestValue(request,"id"));
		}catch(Exception e){
			
		}
		//第二步、调用业务逻辑
        DicSystem obj =null;
		if(id!=null)obj =dicSystemService.getDicSystem(id);//通过id取实体对象
				
		if(obj==null)obj =new DicSystem();//如果实体对象空，是新增，新建个对象
		
		//第三步、把对象传给jsp，放入request容器，本质是setAttribute
        model.addAttribute("obj", obj);
		
		return "dic/sysEdit";
	}
	
	/**
	 * 系统代码保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editSave.html")
	public void editSave(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//第一步,获取请求参数
		Integer id =this.getRequestInteger(request,"id",0);
		String title =this.getRequestValue(request,"title");
		String code =this.getRequestValue(request,"code");
		
        DicSystem dicSystem =dicSystemService.getDicSystem(id);
        if(dicSystem==null){
        	
        	//新增的情况，这里先判断代码是否重复
        	dicSystem =dicSystemService.getDicSystem(code);
        	if(dicSystem!=null){
        		//代码重复，返回
        		this.sendMessage(response,"alert('代码重复，不能保存')","js");
        		
        	}
        	dicSystem =new DicSystem();//新增，new一个实体实例
        }
        dicSystem.setDescription(title);
        dicSystem.setCode(code);
        dicSystemService.save(dicSystem);
		
		this.sendMessage(response,"alert('保存成功');document.location='edit.html?id="+dicSystem.getId()+"';", "js");
			
	}
	

	/**
	 * 删除系统代码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete.html")
	public String delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		String[] ids =request.getParameterValues("ch");//待删除的id,多条
		
		dicSystemService.delete(ids);
		
		this.sendMessage(response,"alert('删除成功');document.location='list.html';", "js");
		
		return null;
	}
}
