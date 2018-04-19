package com.qingmei.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.qingmei.dao.AdminRoleModuleMapper;
import com.qingmei.dao.AdminUserMapper;
import com.qingmei.dao.AdminUserRoleMapper;
import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminUser;
import com.qingmei.entity.AdminUserExample;
import com.qingmei.entity.AdminUserRole;
import com.qingmei.entity.AdminUserRoleExample;
import com.qingmei.entity.PagesInfo;
import com.qingmei.service.AdminUserService;
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
	@Resource
	private AdminUserMapper adminUserMapper;
	@Resource
    private AdminUserRoleMapper adminUserRoleMapper;
	@Resource
	private AdminRoleModuleMapper  adminRoleModuleMapper;
	
	
	 


	@Override
	public void save(AdminUser adminUser) {
		if(adminUser.getId()==null)this.adminUserMapper.insert(adminUser);
		else this.adminUserMapper.updateByPrimaryKey(adminUser);
	}
   
    /**
     * Finds a user by their username.
     * @param username
     * @return User a populated user object
     */
	@Override
    public AdminUser getUserByUsername(String username){
		AdminUserExample  aue = new AdminUserExample();
		aue.createCriteria().andUserNameEqualTo(username);
		List<AdminUser> us= adminUserMapper.selectByExample(aue);
    	return us.size()>0?us.get(0):null;
    }

	@Override
	public boolean updatePassword(String userName,String newpasswd){
		AdminUser user = this.getUserByUsername(userName);
		if(user==null)return false;
		user.setPassword(newpasswd);
		adminUserMapper.updateByPrimaryKey(user);
		
		return true;
	}
	
	
	/**
	 * 用户登录
	 */
	@Override
	public String saveUserLogin(HttpServletRequest request,String username,String password)
	{
	    AdminUser user =this.getUserByUsername(username);
//	    String aa=user.getDicDepartment().getDescription();
//	    System.out.println(aa+"=======");
	    if(user==null)return "1";//用户名错误
	    
	    if(!user.getPassword().equals(password))return "2";//密码错误
	    
	    if(!user.getIsValid().equals("1"))return "3";//注销用户
	    
	    //增加用户登录次数+1
	    user.setLoginNum(user.getLoginNum()+1);
	    user.setLoginTime(new Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
	    
	    adminUserMapper.updateByPrimaryKey(user);
	    
	    //把用户的一些信息放入session
	    HttpSession session =request.getSession(true);	    
	    session.setAttribute("userObj",user);
	    
	    
	    // 记录用户为在线状态。
	    //Global.addOnlineUser(session, user, HandTool.getRemoteIP(request));
	    
	    
	    return "0";
	}
	
	
	//查询导航树的数据
	
	@Override
	public List<AdminModule> findUserPermission(HttpServletRequest request)
	{
		HttpSession session =request.getSession(true);
		AdminUser user =(AdminUser)session.getAttribute("userObj");
	    	    
	    //登录后提取信息放入session
		Map<String, Object> pars =new HashMap<String, Object>();
		pars.put("userId", user.getId());
		
		return this.adminRoleModuleMapper.selectModualByUserId(user.getId());
	    
	}
	
	/**
	 * 用户登出
	 */
	@Override
	public void userLogout(HttpServletRequest request){
		HttpSession session =request.getSession(true);
	    
	    session.setAttribute("userObj",null);
	    session.setAttribute("userModuleStr",null);
	}
	
	/**
	 * 用户管理中，取用户列表
	 */
	@Override
    public PagesInfo findPages(int currentPage,int pageSize,Map<String,Object> pars)
	{
		
		PagesInfo userList =null;//----------adminUserMapper.findPages(currentPage,pageSize,pars);
		
		return userList;
	}
    
    
    
    /**
     * 
     * @param user
     * @param userRoleAdd
     * @param userRoleDelete
     * @return 1保存成功，0失败
     */
    public int saveUserEdit(AdminUser user,String[]  roleIds){
    			
    	//保存编辑用户信息
    	AdminUser u=null;
    	if (user.getId()!=null){
    		
    		u= adminUserMapper.selectByPrimaryKey(user.getId());
    		
    		
    		BeanUtils.copyProperties(user,u,"loginNum","qq","loginTime","createBy");//合并user的属性到u上
    		System.out.println("u.getLoginNum() :"+ u.getLoginNum() );
    	}
        this.save(u);
        
          
        
        //保存用户角色前，先删除次用户原有角色
        
        AdminUserRoleExample  aure= new AdminUserRoleExample();
        aure.createCriteria().andUserIdEqualTo(user.getId());
        
        adminUserRoleMapper.deleteByExample(aure);
        
        //保存用户对应角色信息        
        for(String id:roleIds ){
        	AdminUserRole  aur = new AdminUserRole();
        	aur.setRoleId( Integer.parseInt(id ));
        	aur.setUserId(user.getId());
        	
        	adminUserRoleMapper.insert(aur);	
        }
        
 
        
        return 1;
    }

	@Override
	public AdminUser findUserById(Integer uId) {
		  
		 return this.adminUserMapper.selectByPrimaryKey(uId);
		
	}

	@Override
	public List<AdminUser> getAllUsers(Integer rId, String isValid) {
		
		 
		
		return  null;
		 
	}

	 

	 

}
