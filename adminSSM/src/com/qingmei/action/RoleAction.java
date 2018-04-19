package com.qingmei.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingmei.entity.AdminModule;
import com.qingmei.entity.AdminRole;
import com.qingmei.entity.AdminRoleModule;
import com.qingmei.parent.BaseAction;
import com.qingmei.service.AdminModuleService;
import com.qingmei.service.AdminRoleService;

@Controller
@RequestMapping("/sys/role")
public class RoleAction extends BaseAction {
	@Resource
	private AdminRoleService adminRoleService;
	@Resource
	private AdminModuleService adminModuleService;

	@RequestMapping("list.html")
	public String getRoleList(Model model) {

		List<AdminRole> roles = adminRoleService.getAllRoles();
		model.addAttribute("list", roles);

		return "power/roleList";
	}

	@RequestMapping("powerSave.html")
	public void saveRolePower(String rId, String modules,
			HttpServletResponse resp, HttpServletRequest request)
			throws Exception {
 
		adminRoleService.savePower(rId, modules );

		this.sendMessage(resp, "alert('保存成功');document.location = 'list.html';", "js");

		return;

	}

	@RequestMapping("getRolePowerBefore.html")
	public String getRolePowerBefore(HttpServletRequest request) {
		Integer id = this.getRequestInteger(request, "id", 0);
				 
		AdminRole role = null;
		// 从数据库查role实体
		if (id > 0)
			role = adminRoleService.getAdminRole(id);

		// 不应该为空
		if (role == null)
			role = new AdminRole();
		
		request.setAttribute("nowRole", role);

		return "power/rolePower";
	}

	// 查询角色的当前modules
	@RequestMapping("getRolePower.html")
	public void getRolePower(HttpServletResponse response,
			HttpServletRequest request) {

		// 从页面获得roleId
		Integer id = this.getRequestInteger(request, "id", 0);

		// 所有模块代码
		List<AdminModule> mList = adminModuleService.getList();

		// 角色的权限
		List<AdminRoleModule> pList = adminRoleService.findRoleModules(id);

		// System.out.println("pList.size()"+pList.size());

		// 角色对应的模块实体的checked属性设置为true
		Set<Integer> mIds = new HashSet<Integer>();

		for (AdminRoleModule arm : pList) {
			mIds.add(arm.getModuleId());
		}

		for (AdminModule am : mList) {
			if (mIds.contains(am.getId())) {
				am.setChecked(true);

			}
		}

		JSONArray json = JSONArray.fromObject(mList);
		super.sendMessageJson(response, json.toString());

	}

}
