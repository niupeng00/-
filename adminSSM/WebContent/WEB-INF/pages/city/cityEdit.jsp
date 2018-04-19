<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta  charset="utf-8" />
<title>行政区划管理- ${sysTitle}</title>
<link href="${commRoot}css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}js/main.js"></script>
</head>
<body class="pagePP">  
<div class="tit_01"><div>当前操作</div><div>行政区划</div><div class="jt"></div><div>维护</div><div class="jt"></div><div>é¨é¨ä¿¡æ¯ç»´æ¤</div></div>
<form action="editSave.html" method="post" name="WF" id="WF">
<div class="editDD contCon">
<div class="titleD">行政区划维护</div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">
   <tr><td class="lab">名称</td>  
       <td><input type="text" class="text f t2"  id="title"   name="description"  value="${depart.description}"/><span class="red">*</span></td>
             <input type="hidden" id="code" name="id" value="${depart.id}" />
   </tr>   
    <tr><td class="lab">排序编号</td>  
       <td><input type="text" class="text f t3"  id="sortNo"   name="sortNo"  value="${depart.sortNo}"/><span class="red">*</span></td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" value="保存"/> <input type="button" class="button" id="cbBack" value="返回"/>
  
</div>
</div>

</form>


<div class="endDD"></div>
<script type="text/javascript">
$(document).ready(function(){
	$("#cbBack").on("click",function(){
		document.location='list.html'; 
	});
	$("#WF").on("submit",function(){
		
		 
		if($("#title").val()==''){
			alert("名称不能为空");
			$("#title").focus();
			return false;
		}
		if($("#sortNo").val()==''){
			alert("排序编号不能空");
			$("#sortNo").focus();
			return false;
		}
		
		 
		var data=$("#WF").serializeArray();
		//data.push({name:"id",value:"${obj.id}"});
		$.post("editSave.html",
				data,function(){
			
		});
		return false;
	});
});
</script>
</body>
</html>