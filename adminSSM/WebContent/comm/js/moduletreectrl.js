// Arrays for nodes and icons
var nodes			= new Array();
var openNodes	= new Array();
var icons			= new Array();

function preloadIcons(imagePath) 
{
	icons[0] = new Image();
	icons[0].src = imagePath + "images/tree/plus.png";
	icons[1] = new Image();
	icons[1].src = imagePath + "images/tree/plusbottom.png";
	icons[2] = new Image();
	icons[2].src = imagePath + "images/tree/minus.png";
	icons[3] = new Image();
	icons[3].src = imagePath + "images/tree/minusbottom.png";
}

function createTree(arrName, treeName, basepapge, startNode, openNode,imagePath) 
{
  nodes = arrName;
  if (nodes.length > 0) 
  {
    preloadIcons(imagePath);
    if (startNode == null) startNode =0;
    if (openNode != 0 || openNode != null) setOpenNodes(openNode);
    if (startNode !=0) 
    {
      var nodeValues = nodes[getArrayId(startNode)];
      var urls=nodeValues[3];
      document.write("<a href=" + urls[0] + " target=\"main\"><input type=\"checkbox\" id=\"" + nodeValues[4] + "\">" + nodeValues[2] + "</a><br/>");
    } 
    else 
    {
      //document.write("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td><img src=\"" + imagePath+ "/images/")
      //document.write(""+basepapge+".gif\" align=\"absbottom\" alt=\"\"/></td><td width=\"5\"/><td><a><b>"+treeName+"<b></a></td></tr></table>");
    }
    
    var recursedNodes = new Array();
    addNode(startNode, recursedNodes, imagePath);
  }
}

//??????????????????????
function getArrayId(node) 
{
  for (i=0; i<nodes.length; i++) 
  {
    var nodeValues = nodes[i];
    if (nodeValues[0]==node) return i;
  }
}

//????????????????????????????
function setOpenNodes(openNode) 
{
  for (i=0; i<nodes.length; i++) 
  {
    var nodeValues = nodes[i];
    if (nodeValues[0]==openNode) 
    {
      openNodes.push(nodeValues[0]);
      setOpenNodes(nodeValues[1]);
    }
  } 
}

// ????????????????????
function isNodeOpen(node) 
{
  for (i=0; i<openNodes.length; i++)
  {
    if (openNodes[i]==node) 
      return true;
    return false;
  }
  
}

// ????????????????????
function hasChildNode(parentNode) 
{
  for (i=0; i< nodes.length; i++) 
  {
    var nodeValues = nodes[i];
    if (nodeValues[1] == parentNode) 
      return true;
  }
  return false;
}
// ??????????????????????????
function lastSibling (node, parentNode) 
{
  var lastChild = 0;
  for (i=0; i< nodes.length; i++) 
  {
    var nodeValues = nodes[i];
    if (nodeValues[1] == parentNode)
      lastChild = nodeValues[0];
  }
  if (lastChild==node) return true;
    return false;
}

// ????????????
function addNode(parentNode, recursedNodes, imagePath) 
{
  for (var i = 0; i < nodes.length; i++) 
  {
    var nodeValues = nodes[i];
    if (nodeValues[1] == parentNode) 
    {
      var ls  = lastSibling(nodeValues[0], nodeValues[1]);
      var hcn  = hasChildNode(nodeValues[0]);
      var ino = isNodeOpen(nodeValues[0]);var str="";
      
      // ??????????????????????????????????
      for (g=0; g<recursedNodes.length; g++) 
      {
        if (recursedNodes[g] == 1) 
          document.write("<img src=\"" + imagePath+ "images/tree/line.png\"/>");
        else  
          document.write("<img src=\"" + imagePath+ "images/tree/empty.png\"/>");
      }

      // ????????????????
      if (ls) 
        recursedNodes.push(0);
      else 
        recursedNodes.push(1);

      // ????????????
      if (hcn) 
      {
        if (ls) 
        {
          document.write("<a style=\"cursor:pointer\" onClick=\"javascript: oc(" + nodeValues[4] + ", 1,0);\"><img id=\"join" + nodeValues[4] + "\" src=\"" + imagePath+ "images/tree/");
             if (ino) document.write("minus");
            else 
              document.write("plus");
          document.write("bottom.png\" align=\"absbottom\" alt=\"\"/></a>");
          str="<input style=\"cursor:pointer\" type=\"checkbox\" id=\"cha"+nodeValues[4]+"\"";
          //if(nodeValues[6]=="1")str+=" checked";
          str+=" onclick=\"clkchk(this);\">"
          document.write(str);
        } 
        else 
        {
          document.write("<a value=\"" + nodeValues[0] + "\" style=\"cursor:pointer\" onClick=\"javascript: oc(" + nodeValues[4] + ", 0,0);\"><img id=\"join" + nodeValues[4] + "\" src=\"" + imagePath + "images/tree/");
          if (ino) 
            document.write("minus");
          else 
            document.write("plus");
          document.write(".png\" align=\"absbottom\" alt=\"\"/></a>");
          
          str="<input style=\"cursor:pointer\" type=\"checkbox\" id=\"cha"+nodeValues[4]+"\"";
          if(nodeValues[6]=="1")str+=" checked";
          str+=" onclick=\"clkchk(this);\">"
          document.write(str);
        }
      } 
      else 
      {
        if (ls) 
          document.write("<img src=\"" + imagePath + "images/tree/joinbottom.png\"/>");
        else 
          document.write("<img src=\"" + imagePath + "images/tree/join.png\"/>");
        
      }

      if(hcn)
      {
          if (ls)
            document.write("<a onClick=\"javascript: oc(" + nodeValues[4] + ", 1,0);\" style=\"cursor:pointer\">");
          else
            document.write("<a onClick=\"javascript: oc(" + nodeValues[4] + ", 0,0);\" style=\"cursor:pointer\">");
            
        document.write("<font class=\"leftfont1\">");
      }
      else
      {//叶节点
        var urls=nodeValues[3];
          document.write("<a style=\"cursor:pointer\">");
          nodeValues[9]="1";
          str="<font class=\"leftfont2\"><input id=\"cha" + nodeValues[4] + "\" type=\"checkbox\"";
          if(nodeValues[6]=="1")str+=" checked";
          str+=" onclick=\"clkchk(this);\">";
        document.write(str);
      }
      
      // ????????????
      document.write(nodeValues[2]+"</font>");

      // End link 文字后的checkbox
      str="</a><input type=\"checkbox\" style=\"visibility:hidden;\" id=\"chc"+nodeValues[4]+"\"";
          if(nodeValues[7]=="1")str+=" checked";
          str+=" onclick=\"clkctrl(this);\"><br/>";
        document.write(str);
      // ??????????????????????DIV????????????????
      if (hcn) 
      {
        document.write("<div id=\"div" + nodeValues[4] + "\"");
        if (!ino) 
          document.write(" style=\"display: none;\"");
        document.write(">");
        addNode(nodeValues[0], recursedNodes, imagePath);
        document.write("</div>");
      }
      
      // remove last line or empty icon 
      recursedNodes.pop();
    }
  }
}

// ??????????????????
function oc(node, bottom, dirtype) 
{
  var theDiv = document.getElementById("div" + node);
  var theJoin  = document.getElementById("join" + node);
  var theIcon = document.getElementById("icon" + node);
  if (theDiv.style.display == 'none') 
  {
      if(dirtype==0)
      {
    if (bottom==1)
      theJoin.src = icons[3].src;
    else 
      theJoin.src = icons[2].src;
    theDiv.style.display = '';
      }
    
  } 
  else 
  {
      if(dirtype==0)
      {
    if (bottom==1) 
      theJoin.src = icons[1].src;
    else 
      theJoin.src = icons[0].src;
    theDiv.style.display = 'none';
      }
  }
  
}
// Push and pop not implemented in IE
if(!Array.prototype.push) 
{
  function array_push() 
  {
    for(var i=0;i<arguments.length;i++)
    {
      this[this.length]=arguments[i];
    }
    return this.length;
  }
  Array.prototype.push = array_push;
}
if(!Array.prototype.pop) 
{
  function array_pop()
  {
    lastElement = this[this.length-1];
    this.length = Math.max(this.length-1,0);
    return lastElement;
  }
  Array.prototype.pop = array_pop;
}
function setNodeCheckedIni(){
	var node,key,isAll,isAllC;
	for(var i=0;i<nodes.length;i++){
		node=nodes[i];
		if(node[9]=="1")continue;
		key=node[0];
		isAll=true;
		isAllC=true;
		for(var j=i+1;j<nodes.length;j++){
			if(key==nodes[j][0].substring(0,key.length)){
				if(nodes[j][9]=="1" && nodes[j][6]=="0"){
					isAll=false;
					isAllC=false;
					break;
				}
				if(nodes[j][7]=="0")isAllC=false;
			}else break;
		}
		$("#cha"+i)[0].checked=isAll;
		$("#chc"+i)[0].checked=isAllC;
	}
}
function clkchk(obj){
	selectAllC("cha",obj);
}
function clkctrl(obj){
	selectAllC("chc",obj);
}
function selectAllC(freName,obj){
	var ind=(obj.getAttribute("id").substring(freName.length))*1;
	var node=nodes[ind];
	var checked=obj.checked;
	var key=node[0];
	if(node[9]==0){//非叶节点
		for(var j=ind+1;j<nodes.length;j++){
			if(key==nodes[j][0].substring(0,key.length))$("#"+freName+nodes[j][4])[0].checked=checked;
			else break;
		}
	}else{//叶节点
		/*var isAll=false;
		var begin=0;
		for(var j=ind+1;j<nodes.length;j++){
			if(nodes[j][9]!="0" || )
		}
		for(var j=ind-1;j>=0;j--){
			
		}*/
	}
}