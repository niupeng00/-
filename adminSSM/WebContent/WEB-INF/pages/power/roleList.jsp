<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmf" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8" />
<title>角色管理 - ${sysTitle }</title>
<link href="${commRoot}/css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}/js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}/js/main.js"></script>
  
<script type="text/javascript">

 
$(document).ready(function(){
	$("#cbAdd").bind("click",function(){
		document.location='edit.html';
	});
	$("#cbQuery").bind("click",function(){
		document.location='list.html';
	});
	$("#cbDel").on("click",function(){//删除
		
		 
		var os=$(":checkbox[name=ch]");
        if($(":checkbox[name=ch]:checked").length==0){
        	alert("请先选择要删除的记录");
        	return false;
        }
         
        
       // console.log($(":checkbox[name=ch]").serializeArray());
        
        $.post("delete.html",
        		$(":checkbox[name=ch]").serializeArray(),
        		function(){
        	
        });
    });
});
</script>


</head>
<body class="pagePP">
<div class="tit_01"><div>当前操作：</div><div>系统管理</div><div class="jt"></div><div>角色管理</div></div>

<div class="queryDD">
  <input type="button" value="删除" id="cbDel" class="button leftMar2"/>
  <input type="button" value="添加" id="cbAdd" class="button"/>
</div>

<div id="myList" class="gridDD topMar">   <table align="center" cellpadding="1" cellspacing="1" class="w100">
     <tr class="head">
   	  <th><input id="chAll" type="checkbox" value="全选" 
   	               onclick="selectAll(this,'ch')"/></th>
   	  <th>角色名称</th>
      <th>创建时间</th>
      <th>备注</th>
      <th>操作</th>
     </tr>	   
	   <c:set var="odd" value="${true}"/><c:set var="index" value="0"/>
     <c:forEach items="${list}" var="row"><c:set var="odd" value="${!odd}"/><c:set var="index" value="${index+1}"/>
       <tr class="row<c:if test="${odd==true}">0</c:if>">		                
         <td noWrap class="tdwM">
         <input type="checkbox" value="${role.id }"  name="ch"/></td>
         <td nowrap class="tdwM">${row.roleName}</td>
         <td nowrap class="tdwL"> 
           <fmf:formatDate value="${row.createTime}"  pattern="YYYY-MM-dd HH:mm:SS" /> 
         </td>
         <td nowrap class="tdwL">${row.note}</td>
         <td nowrap class="tdwM">
      	   [<a href="edit.html?id=${row.id}" >编辑</a>]
      	   [<a href="getRolePowerBefore.html?id=${row.id}" >权限管理</a>]
  	     </td>
       </tr>
     </c:forEach>
        </table>
   
  </div>
 
</body>
</html>