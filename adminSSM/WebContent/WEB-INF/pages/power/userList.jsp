<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理 - ${sysTitle}</title>
<link href="${commRoot}css/main.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${commRoot}js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}js/main.js"></script>
</head>
<body class="pagePP">
	<div class="tit_01">
		<div>当前操作：</div>
		<div>系统管理</div>
		<div class="jt"></div>
		<div>用户管理</div>
	</div>

	<div class="queryDD">
		角色：<select id="roleid" onchange="query()"><option value="">---全部---</option>
			<c:forEach items="${roles}" var="row">
				<option value="${row.id}">${row.roleName}</option>
			</c:forEach>
		</select> <label class="leftMar2"><input type="radio" value="1"
			name="isvalid" checked id="r0" />有效用户</label> <label><input
			type="radio" value="0" name="isvalid" id="r1" />注销用户</label> <input
			type="button" value="查询" id="cbQuery" class="button leftMar2" /> <input
			type="button" value="添加" id="cbAdd" class="button" />
	</div>

	<div id="myList" class="gridDD topMar">

		<table align="center" cellpadding="1" cellspacing="1" class="w100">
			<tr class="head">
				<th></th>
				<th>用户名</th>
				<th>部门</th>
				<th>手机</th>
				<th>登录次数</th>
				<th>上次登录时间</th>
				<th>创建时间</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			<c:set var="odd" value="${true}" />
			<c:set var="index" value="0" />
			<c:forEach items="${list}" var="row">
				<c:set var="odd" value="${!odd}" />
				<c:set var="index" value="${index+1}" />
				<tr class="row<c:if test="${odd==true}">0</c:if>">
					<td noWrap class="tdwM">${index}</td>
					<td nowrap class="tdwM">${row.userName}</td>
					<td nowrap class="tdwL"></td>
					<td nowrap class="tdwM">${row.mobile}</td>
					<td nowrap class="tdwM">${row.loginNum}</td>
					<td nowrap class="tdwL">${row.loginTime}</td>
					<td nowrap class="tdwL">${row.createTime}</td>
					<td nowrap class="tdwL">${row.note}</td>
					<td nowrap class="tdwM">[<a href="getEditUserInfo.html?uId=${row.id}">编辑</a>]
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="pagenum">${pages}</div>
 
 
 
 
		<script type="text/javascript">
			function query() {
				actionPost("", {					
					roleid : $("#roleid").val(),
					isValid : $("input[name=isvalid]:checked").val()
				}, function(ans) {
					//$("#myList").html(ans);
				});
			}
			$(document).ready(function() {
				$("input[name=isvalid]").bind("click", function() {
					query();
				})
				$("#cbAdd").bind("click", function() {
					// 
					document.location = 'getEditUserInfo.html';
				});
				$("#cbQuery").bind("click", function() {
					query();
				});
			});
		</script>
</body>
</html>