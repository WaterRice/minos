/**  

* 创建时间：2019年3月16日 下午7:55:00  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotFindException.java  

* 类说明：  资源不存在异常类的公共父类
* 
* plus: 异常ID 404000

*/

package org.wingsOfHope.minos.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = -9141979960499292294L;
	
	protected String message;
	
	protected Integer exceptionID;
	
	public NotFoundException() {
		this.message = "资源不存在";
		this.exceptionID = 404000;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Integer getExceptionID() {
		return exceptionID;
	}
}
