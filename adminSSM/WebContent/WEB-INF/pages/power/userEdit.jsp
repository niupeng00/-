<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户编辑 - ${sysTitle}</title>
<link href="${commRoot}/css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}/js/jquery.js"></script>
</head>
<body class="pagePP">
<div class="tit_01"><div>当前操作：</div><div>系统管理</div><div class="jt"></div><div>用户管理</div><div class="jt"></div><div>用户编辑</div></div>
<form action="userSave.html" id="WF" method="post"><input type="hidden" name="id" id="id" value="${obj.id}"/>
<div class="editDD contCon">
<div class="titleD">用户编辑</div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">
   
   <tr><td class="lab">用户名(登录用)：</td>  
       <td><input type="text" name="userName" id="username" value="${obj.userName}"   class="text f t3" /><span class="red">*</span></td>
   </tr>
   <tr><td class="lab">用户名（汉字）：</td>  
       <td><input type="text" name="fullName" id="fullName" value="${obj.fullName}"   class="text f t3" /><span class="red">*</span></td>
   </tr>
   
   <tr><td class="lab">email：</td>  
       <td><input type="text" name="email" id="email" value="${obj.email}" class="text f t3" /></td>
   </tr>
   <tr><td class="lab">手机：</td>  
       <td><input type="text" name="mobile" id="mobile" value="${obj.mobile}" class="text f t3" /></td>
   </tr>
   <tr><td class="lab">每页显示记录数：</td>
   <c:set var="pageSize" value="20"/>
      <c:if test="${obj.pageSize>0}">
           <c:set var="pageSize" value="${obj.pageSize}"/>
      </c:if> 
       <td><input type="text" name="pageSize" id="pagesize" value="${pageSize}" class="text f t3" /><span class="red">*</span></td>
   </tr>
   <tr><td class="lab">所属部门：</td>  
       <td><select id="depart" name="departmentId"><option value="">=====</option>
       <c:forEach items="${departmentA }" var="row">
          <option   value="${row.id }">${row.description}</option>
       </c:forEach>
       
       </select></td>
   </tr>
   <tr><td class="lab">新密码：</td>  
       <td><input type="password" name="password" id="pwd0" value="" class="text f t3" /></td>
   </tr>
   <tr><td class="lab">确认新密码：</td>  
       <td><input type="password" name="newpwd" id="newpwd" value="" class="text f t3" /></td>
   </tr>
   <tr><td class="lab">用户状态：</td>  <c:set var="isValid" value="1"/><c:if test="${obj.isValid!=null && obj.isValid=='0'}"><c:set var="isValid" value="${obj.isValid}"/></c:if>
       <td><label>
       <input type="radio" value="1" name="isValid" id="r0"<c:if test="${isValid=='1'}"> checked="checked"</c:if>/>激活</label>
       <label class="leftMar2"><input type="radio" value="0" name="isValid" id="r1"<c:if test="${isValid=='0'}"> checked="checked"</c:if>/>注销</label></td>
   </tr>   
   
   <tr><td class="lab">用户角色：</td>  
       <td>
       <c:forEach items="${roleList}" var="row">
          <label class="rightMar"><input type="checkbox" name="roleIds"  value="${row.id}"/>${row.roleName}</label>
       </c:forEach>
       </td>
   </tr>
   
   <tr><td class="lab">备注：</td>  
       <td><textarea id="note" name="note" rows="5" cols="60" class="text f">${obj.note}</textarea></td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" id="cbSave" value="保存"/> <a class="button" href="list.html">返回</a>
  
</div>
</div>

</form>


<div class="endDD"></div>
<script type="text/javascript">
$(document).ready(function(){
	$("#WF").on("submit",function(){
		if($('#username').val()==""){
			alert("用户名必须输入");
			$('#username').focus();
			return false;
		}
		if($('#pagesize').val()==""){
			alert("每页显示记录数必须输入");
			$('#pagesize').focus();
			return false;
		}
		var pwd=$("#pwd0").val();
		if(pwd!=""){
			if(pwd!=$("#newpwd").val()){
				alert("两次密码输入不一致，请修改");
				return false;
			}
		}
		$.post("editSave.html",$("#WF").serializeArray(),function(ans){});
		return false;
	});
	
	$("#depart").val("${obj.departmentId}");
	<c:forEach items="${userRoleList}" var="row">
	  $(":checkbox[name=roleIds][value=${row.roleId}]").prop("checked",true);
	</c:forEach>
});
</script>
</body>
</html>