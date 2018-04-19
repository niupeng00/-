package com.qingmei.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qingmei.dao.AdminLogMapper;
import com.qingmei.entity.AdminLog;
import com.qingmei.entity.AdminLogExample;
import com.qingmei.entity.AdminUser;
import com.qingmei.service.AdminLogService;
import com.qingmei.util.HandTool;
@Service("adminLogService")
public class AdminLogServiceImpl implements
		AdminLogService {
	@Resource
	private AdminLogMapper adminLogMapper;



	@Override
	public int save(AdminLog adminLog) {
		if(adminLog.getId()==null)return adminLogMapper.insert(adminLog);
		else return adminLogMapper.updateByPrimaryKey(adminLog);
	}

	
	/**
	 * 
	 * @param request 
	 * @param logTypeCode: 日志类型代码
	 * @param updateType： 操作类型，1新增，2修改，3删除
	 * @param targetID：目标数据id，没有则填0
	 * @param note：备注
	 * @return  1正确，0错误
	 */
	public String saveSysLog(HttpServletRequest request, String logTypeCode, String updateType, String targetID, String note){
		//if(!(updateType.equals("1") ||updateType.equals("2") ||updateType.equals("3")))return "0";
		Object obj =request.getSession().getAttribute("userObj");
		if(obj==null)return "0";
		
		AdminUser user =(AdminUser)obj;
		AdminLog sysLog =new AdminLog();
		sysLog.setIp(HandTool.getRemoteIP(request));
		sysLog.setLogtypeCode(logTypeCode);
		sysLog.setUpdateType(updateType);
		sysLog.setUserName(user.getUserName());
		sysLog.setTargetId(targetID);
		sysLog.setNote(note);
		sysLog.setCreateTime(new Date() );
		
		save(sysLog);
		
		return "1";
	}


	@Override
    public List<AdminLog> findPages(int currentPage,int pageSize,Map<String,Object> pars)
	{
		PageHelper.startPage(currentPage, pageSize);
		AdminLogExample  ale = new AdminLogExample();
		ale.setOrderByClause("create_Time desc");
		
		
		return adminLogMapper.selectByExample(ale); 
		
	}


	@Override
	public AdminLog getAdminLog(Integer logId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}