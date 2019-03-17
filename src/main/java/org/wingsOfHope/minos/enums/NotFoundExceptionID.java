/**  

* 创建时间：2019年3月17日 下午3:55:09  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotFoundExceptionID.java  

* 类说明：  

*/

package org.wingsOfHope.minos.enums;

public enum NotFoundExceptionID {
	
	DEFAULT_NOTFOUNDEXCEPTION(404000),
	
	USER_NOTFOUNDEXCEPTION(404001);
	
	private Integer id;
	
	NotFoundExceptionID(Integer id) {
		this.id = id;
	}
	
	public Integer getID() {
		return id;
	}
	
}
