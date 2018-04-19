package com.qingmei.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminRole;
import com.qingmei.entity.AdminUser;
import com.qingmei.entity.DicDepartment;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.AdminLogService;
import com.qingmei.service.AdminRoleService;
import com.qingmei.service.AdminUserService;
import com.qingmei.service.DicDepartmentService;
import com.qingmei.util.VerifyCodeUtils;

/**
 * 登录、主页
 * @author 汤慧龙
 * @version 创建日期2017年4月28日
 */
// @RequestMapping("/login")
@Controller
public class LoginAction extends BaseAction {  /*** BaseAction父类介绍  ***/
	
	/***  Resource注解和autowried注解区别 ***/
	@Resource
	DicDepartmentService  deaprtService;
	 
	@Resource 
	AdminRoleService  roleService;
	
	@Resource
	private AdminUserService adminUserService;
	@Resource
	private AdminLogService adminLogService;
	
	
	@RequestMapping("sys/user/list.html")
	public String  getUserList(HttpServletRequest request, Model model){
		
		Integer rId= this.getRequestInteger(request, "roleid", 1);   
		String isValid = this.getRequestValue(request, "isValid","1");
		
		List<AdminUser> users= adminUserService.getAllUsers(rId,isValid);
		model.addAttribute("list",users);
		
		return "power/userList";
	}
	
	
	//保存用户信息
	@RequestMapping("sys/user/editSave.html")
	public  void saveEditUser(AdminUser user,String[] roleIds,
			HttpServletResponse  response) throws Exception{
		
		adminUserService.saveUserEdit(user, roleIds);
		
		this.sendMessage(response, "alert('保存成功');window.location.href='userList.html';", "js");
		
		//return "userList";
	}
	
	//根据用户id查询用户信息给界面编辑使用
	@RequestMapping("sys/user/getEditUserInfo.html")
	public  String  getEditUserById( HttpServletRequest  request,
			Model map){
		Integer uId = this.getRequestInteger(request, "uId", 0);
		
		AdminUser au= adminUserService.findUserById(uId);
		map.addAttribute("obj", au);
		
		
		//departmentA
		List<DicDepartment>  departs= deaprtService.findList(1, 999);
		map.addAttribute("departmentA", departs);
		
		//roleList
		List<AdminRole> ars= roleService.getAllRoles();
		map.addAttribute("roleList", ars);
		
		return "power/userEdit";
	}
	
	
	/**
	 * 登录初始页
	 * @return
	 */
	@RequestMapping("index.html")
	public String signInPage(HttpServletRequest request) throws Exception{
		
		return "index";
	}
	

	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("varifyImage.html")
	public String showVarifyImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        //response.setContentType("image/jpeg");
        
//        ServletContext context =request.getServletContext();
//        WebApplicationContext attr = (WebApplicationContext)context.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC");  
        
          
        //生成随机字串  1233456667 abcdfsfdssf
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        HttpSession session = request.getSession();  
        session.setAttribute("varifyCode", verifyCode.toLowerCase());  
        //生成图片  
        int w = 100, h = 28;  
        try{   /*** 生成随机数功能函数  ***/
        	VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        }catch(Exception e){
        	
        }
        
        
        //界面不进行跳转，
        return null;
	}
	
	/**
	 * 登录判断
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login.html")
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		/**** getRequestValue父类的辅助函数   ****/
		String username =this.getRequestValue(request, "username");
        String password =this.getRequestValue(request, "pwd");
        String checkc =this.getRequestValue(request, "checkc");
        String passwordEncode = password;
        /***加密后再和数据库的值比较  MD5.encodeString(password); 
         * 用户注册 123、用户修改模块？？  ***/
    	try{
    		
    		HttpSession session = request.getSession(true);
    		String checkc2 =this.getValue(session.getAttribute("varifyCode"));
    		if(!checkc2.equals(checkc)){
    			//系统正常运行，请打开下句验证码校验
    			return this.sendMessage(response,"messBox(2,'验证码错误!!!');renewSec();","js");
    		}
    		
    		//登录验证 
	        String ret =adminUserService.saveUserLogin(request,username,passwordEncode);
	        
	        if(ret.equals("0")){
	        	//登录成功   记录登录日志
	        	adminLogService.saveSysLog(request, "login", "0", "0", "");
	        }
	        
	        StringBuffer script =new StringBuffer();
	        if(ret.equals("0"))script.append("document.location='main.html';");/**** 成功的跳转在这里***/
	        else if(ret.equals("1"))script.append("alert('用户名错误');");
	        else if(ret.equals("2"))script.append("alert('密码错误');");
	        else if(ret.equals("3"))script.append("alert('该用户已注销，请与系统管理员联系');");
	        
	        return this.sendMessage(response,script.toString(),"js");
	        
    	}catch(Exception e){
    		logger.error(e.getMessage(),e);
    	}
		return null; /**** 直接写http相应流 ，不用spring视图解析器  ***/
	}
	
//	 public static void main(String[] args) {  
//         
//	        Map<String, String> map = new HashMap<String, String>();  
//	          
//	        map.put("001", "apple");  
//	        map.put("002", "pear");  
//	        map.put("003", "orange");  
//	        map.put("004", "banana");  
//	          
//	        JSONObject json = JSONObject.fromObject(map);  
//	          
//	        System.out.println(json.toString());  
//	    }  
	
	//ajax返回ztree树需要的数据
	@RequestMapping("ztreeData.html")
	public void  getZtreeData(HttpServletRequest  request,  HttpServletResponse response){
//		int b=100;
//		float a=b;
//		b= Math.round(a);
		
		List<AdminModule> ms = this.adminUserService.findUserPermission(request);
		
		JSONArray json = JSONArray.fromObject(ms);  		
		super.sendMessageJson(response,json.toString() );
		
		
	}
	
	/**
	 * 主页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("main.html")
	public String main(HttpServletRequest request,HttpServletResponse response,Model model) {
		AdminUser user =this.getUserFromSession(request);
		if(user==null){			
			return "redirect:/";//返回网站根。 webxml的欢迎页
		}
		
		List<AdminModule> list =adminUserService.findUserPermission(request);
		 
		
        model.addAttribute("module",list);
        model.addAttribute("user", user);
		
		return "main";
	}
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping("logout.html")
	public String logout(HttpServletRequest request) {        
        adminUserService.userLogout(request);  
        
        return "redirect:/";//+request.getServletContext().getAttribute("mainRoot");
	}
}
