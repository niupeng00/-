package com.qingmei.entity;

import com.github.pagehelper.Page;


/**
 * 分页信息
 * 
 * @author roy tang
 * 
 *  2009-03-09
 */
public class PagesInfo {
	private int pageSize =20;//每页记录数
	private int currentPage =1;//当前页面，1最小为1
	private int rowCount =0;//总记录数
	private int pageCount=0;//总页数
	public PagesInfo(int pageSize,int currentPage,int rowCount){
		this.pageSize =pageSize;
		this.currentPage =currentPage;
		this.rowCount =rowCount;
		setPageCount();

		if(this.currentPage>this.pageCount)this.currentPage =this.pageCount;
	}
	public PagesInfo(Page<?> page){
		this.pageSize =page.getPageSize();
		this.currentPage =page.getPageNum();
		this.rowCount =(int)page.getTotal();
		setPageCount();

		if(this.currentPage>this.pageCount)this.currentPage =this.pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * 计算总页数
	 */
	public void setPageCount(){
		pageCount = rowCount % pageSize>0? rowCount/pageSize+1:rowCount/pageSize;
		System.out.println("pagecnt："+pageCount + " pageSize："+pageSize);
	}
	
	public int getFirstRow(){
		return (currentPage -1)*pageSize;
	}
	
	
	/**
	 * 获取分页html
	 * @param url：两种格式，1html,2script(格式为：javascript:xxxxxxxxxxx)
	 * 如：
	 *     http://xxxx/abc.html?a=x&pn=**
	 *     javascript:query({a:"x",pn:**});
	 * @param pagesInfo
	 * @return
	 */
	public String getPagesHtml(String url){
		int totalPage =this.getPageCount();
		if(totalPage<=1)return "";
		StringBuffer ret =new StringBuffer("<label class=\"fontNote rightMar2\">共").append(rowCount).append("条</label>");
		int pages =5;//显示11个页码,左右各5
		int leftNum,rightNum;
		String replace ="**";
		int pop =url.indexOf(replace);
		
		String urlLeft =url.substring(0,pop);
		String urlRight =url.substring(pop+2);
		
		leftNum =currentPage -pages;
		rightNum =currentPage +pages;
		if(leftNum <1){
			rightNum =rightNum +(1-leftNum);
			leftNum =1;
		}
		if(rightNum >totalPage){
			leftNum =leftNum -(rightNum -totalPage);
			rightNum =totalPage;
		}
		if(leftNum<1)leftNum =1;
		
		if(currentPage>1)ret.append("<a href='").append(urlLeft).append(1).append(urlRight).append("'>首页</a>");
		for(int i=leftNum;i<=rightNum;i++){
			if(i==currentPage)ret.append("<span>").append(i).append("</span>");
			else{
				ret.append("<a href='").append(urlLeft).append(i).append(urlRight).append("'>").append(i).append("</a>");
			}
		}
		
		if(currentPage<totalPage){
			ret.append("<a href='").append(urlLeft).append(totalPage).append(urlRight).append("'>尾页</a>");
		}
		
		StringBuffer go2Page=new StringBuffer("var cpage=$(\"#targetPage\").val();");
		if(urlLeft.indexOf("javascript:")<0){
			//html情形
			go2Page.append("document.location=\"").append(urlLeft).append("\"+cpage+\"").append(urlRight).append("\";");
		}else{
			//script情形
			go2Page.append(urlLeft.substring(11)).append("cpage").append(urlRight);
		}
		
		ret.append("&nbsp;&nbsp;页次").append(currentPage).append("/").append(totalPage).append("&nbsp;每页").append(pageSize).append("总计").append(rowCount);
		ret.append("&nbsp;&nbsp;转到<input type=text id='targetPage' maxlength='10' size='3' class='text f'><input type=button value=' Go ' class='btn_2k3' onclick='").append(go2Page).append("'>");
		
		
		//System.out.println("分页信息："+ret);
		return ret.toString();
		
	}
	

}
