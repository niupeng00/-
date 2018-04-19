<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日志 - ${sysTitle}</title>
<link href="${commRoot}css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}js/main.js"></script>
</head>
<body class="pagePP">
<div class="tit_01"><div>当前操作：</div><div>系统管理</div><div class="jt"></div><div>日志</div></div>

<div class="queryDD">
  <span class="rightMar">日志类型：<select id="logtype"><option value="">---全部---</option>
    <c:forEach items="${logtypeA }" var="row">
       <option value="${row.code }">${row.description }</option>
    </c:forEach>   
   </select></span> 
    用户名：<input type="text" class="text f" id="username" value="${userName}"/> 
  <input type="button" value="查询" id="cbQuery" class="button leftMar2"/>
</div>

<div id="myList" class="gridDD topMar"> 
  <table align="center" cellpadding="1" cellspacing="1" class="w100">
     <tr class="head">
   	  <th>日志id</th>
      <th>时间</th>
      <th>用户名</th>
      <th>日志类别</th>
      <th>操作类型</th>
      <th>目标数据ID</th>
      <th>IP</th>
      <th>备注</th>
     </tr><c:set var="index" value="0"/>
     <c:forEach items="${list}" var="row"><c:set var="index" value="${index+1}"/>
       <tr class="row${index%2}">
         <td nowrap class="tdwL">${row.id}</td>
         <td nowrap class="tdwL">${row.createTime}</td>
         <td nowrap class="tdwL">${row.userName}</td>
         <td nowrap class="tdwL">${row.logtypeCode}</td>
         <td nowrap class="tdwL"></td>
         <td nowrap class="tdwL">${row.targetId}</td>
         <td nowrap class="tdwL">${row.ip}</td>
         <td nowrap class="tdwL">${row.note}</td>
       </tr>
   </c:forEach>
     
        </table>
   
   <div class="pagenum">${page}</div>
   
  </div>
   
<script type="text/javascript">
function query(pars){
	pars.isIni="0";
	actionPost("",pars,
			function(ans){
				$("#myList").html(ans);
			});
}
$("#cbQuery").bind("click",function(){
	var pars={};
	pars.logType=$("#logtype").val();
	pars.userName=$.trim($("#username").val());
	
	query(pars);
});
</script>
</body>
</html> 