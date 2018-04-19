package com.qingmei.parent;

import java.io.Serializable;

/**
 * 所有对象基类
 * 
 * @author  roy tang
 * @version 1.0 
 * @since 2016-7-6
 *
 */
public abstract class BaseObject extends Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7872315745042303671L;

	public BaseObject() {
	}

	/*public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE, false, getClass());
	}*/


	
}
