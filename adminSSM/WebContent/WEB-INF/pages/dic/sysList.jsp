<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>系统代码管理</title>
<link href="${commRoot}css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${commRoot}js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}js/main.js"></script>
</head>
<body class="pagePP"><div class="tit_01"><div>当前操作：</div><div>数据字典管理</div><div class="jt"></div><div>系统代码管理</div></div>
<div class="queryDD">
<span class="rightMar2">系统名称：<input type="text" id="title" class="text f t3" value="${title }"/></span>
    <input type="button" class="button" value="查询" id="cbQuery"/>
  <input type="button" class="button" value="新增" id="cbAdd"/>
  <input class="button" type="button" value="删除" id="cbDel"/>
</div>

<div id="myList" class="gridDD topMar">   <table align="center" cellpadding="1" cellspacing="1" class="w100">
     <tr class="head">
   	  <th><input id="chAll" type="checkbox" value="全选" onclick="selectAll(this,'ch')"/></th>
   	  <th>系统代码xxx</th>
      <th>名称</th>
      <th>操作</th>
     </tr><c:forEach items="${list}" var="row" varStatus="status">
      <tr class="row${status.index%2}">		                
         <td noWrap class="tdwM"><input name="ch" type="checkbox" value="${row.id}"/></td>
         <td nowrap class="tdwM">${row.code}</td>
         <td nowrap class="tdwL">${row.description}</td>
         <td nowrap class="tdwM">
      	   [<a href="edit.html?id=${row.id}" >编辑</a>]
  	     </td>
       </tr>
       </c:forEach>
        </table>
   <div class="pagenum">${page}</div>
  </div>

<script type="text/javascript">
$(document).ready(function(){
	$("#cbQuery").on("click",function(){
		document.location='list.html?title='+$("#title").val();
	});
	$("#cbAdd").on("click",function(){
		document.location='edit.html';//新增
	});
	$("#cbDel").on("click",function(){//删除
		var os=$(":checkbox[name=ch]");
        if($(":checkbox[name=ch]:checked").length==0){
        	alert("请先选择要删除的记录");
        	return false;
        }
        $.post("delete.html",$(":checkbox[name=ch]").serializeArray(),function(){});
    });
	$("#cbSort").on("click",function(){
		document.location='sort.html';
	});
	
})
</script>  
</body>
</html>
