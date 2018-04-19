package com.qingmei.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminUser;
import com.qingmei.entity.PagesInfo;


/**
 * 用户service接口
 * @author 汤慧龙
 * @vertion 创建日期2016年11月7日
 */
public interface AdminUserService{
	
	List<AdminUser> getAllUsers(Integer rId,String isValid);
    
	AdminUser  findUserById(Integer uId);
	
    /**
     * 保存
     * @param adminUser
     */
    public void save(AdminUser adminUser);
    

    /**
     * Finds a user by their username.
     * @param username
     * @return User a populated user object
     */
    public AdminUser getUserByUsername(String username);

	public boolean updatePassword(String username,String newpasswd);
	
	
	/**
	 * 用户登录：
	 * @param username
	 * @param newpasswd
	 * @return：0成功，1用户名错误，2密码错误
	 */
	public String saveUserLogin(HttpServletRequest request,String username,String newpasswd);
	
	public void userLogout(HttpServletRequest request);
	
	/**
	 * 用户功能菜单展现时调用
	 * @param request
	 * @return
	 */
	public List<AdminModule> findUserPermission(HttpServletRequest request);
	
	public int saveUserEdit(AdminUser user,String[] roleIds);
	
	public PagesInfo findPages(int currentPage,int pageSize,Map<String,Object> pars);
    
    
}
