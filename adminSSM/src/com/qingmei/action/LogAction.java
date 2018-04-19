package com.qingmei.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.qingmei.entity.AdminLog;
import com.qingmei.entity.PagesInfo;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.AdminLogService;

@RequestMapping("/sys/log")
@Controller
public class LogAction extends BaseAction{

	@Resource
	private AdminLogService   alService;
	
	@RequestMapping("list.html")
	public String  getRoleList(HttpServletRequest request, Model model){
		String logType = this.getRequestValue(request, "logType","%");
		
        int pageNum =this.getRequestInteger(request, "pn", 1);
		int pageSize =this.getPageSize(this.getUserFromSession(request));
		
		Map<String,Object> pars = new HashMap<>();
		pars.put("logType", logType);
		
		List<AdminLog> list= alService.findPages(pageNum, pageSize, pars)  ;
		model.addAttribute("list",list);
		
		//分页：利用mybatis插件分页
    	Page<?> page =(Page<?>)list;
    	PagesInfo pagesInfo =new PagesInfo(page);//把分页信息放入自己封装的类里
    	model.addAttribute("page", pagesInfo.getPagesHtml("?pn=**"));//获取分页条html
    	    	
		
		return "power/logList";
	}
}
