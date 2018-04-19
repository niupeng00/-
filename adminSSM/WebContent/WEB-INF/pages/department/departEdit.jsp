<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta  charset="utf-8" />
<title>部门信息维护 - ${sysTitle}</title>
<link href="${commRoot}css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}js/main.js"></script>
</head>
<body class="pagePP">  
<div class="tit_01"><div>当前操作：</div><div>部门信息维护管理</div><div class="jt"></div><div>部门信息维护</div><div class="jt"></div><div>部门信息维护</div></div>
<form action="editSave.html" method="post" name="WF" id="WF">
<div class="editDD contCon">
<div class="titleD">部门信息维护</div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">
   <tr><td class="lab">名称：</td>  
       <td><input type="text" class="text f t2"  id="title"   name="description"  value="${depart.description}"/><span class="red">*</span></td>
             <input type="hidden" id="code" name="id" value="${depart.id}" />
   </tr>   
    <tr><td class="lab">排序：</td>  
       <td><input type="text" class="text f t3"  id="sortNo"   name="sortNo"  value="${depart.sortNo}"/><span class="red">*</span></td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" value="保存"/> <input type="button" class="button" id="cbBack" value="返回"/>
  
</div>
</div>

</form>


<div class="endDD"></div>
<script type="text/javascript">
$(document).ready(function(){
	$("#cbBack").on("click",function(){
		document.location='list.html';//列表页的原始url
	});
	$("#WF").on("submit",function(){
		
		/****提交前 判断空值  ****/
		if($("#title").val()==''){
			alert("请输入名称！");
			$("#title").focus();
			return false;
		}
		if($("#sortNo").val()==''){
			alert("请指定显示次序！");
			$("#sortNo").focus();
			return false;
		}
		
		/*** 序列化表单数据 用ajax发送  ***/
		var data=$("#WF").serializeArray();
		//data.push({name:"id",value:"${obj.id}"});
		$.post("editSave.html",
				data,function(){
			
		});//三个参数，1请求目标地址url，2提交的json/json数组数据，3回调函数
		return false;
	});
});
</script>
</body>
</html>