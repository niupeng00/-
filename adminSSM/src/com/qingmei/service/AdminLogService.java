/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * <p><a href="RoleManager.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
package com.qingmei.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.qingmei.entity.AdminLog;
import com.qingmei.entity.PagesInfo;

public interface AdminLogService{

    
    public AdminLog getAdminLog(Integer logId);
    
    public int save(AdminLog adminLog);
    
    
    public String saveSysLog(HttpServletRequest request, String logTypeCode, String updateType, String targetID, String note);
    
    public List<AdminLog> findPages(int currentPage,int pageSize,Map<String,Object> pars);
}
