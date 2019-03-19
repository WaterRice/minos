/**  

* 创建时间：2019年3月16日 下午7:55:00  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotFindException.java  

* 

*/

package org.wingsOfHope.minos.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = -9141979960499292294L;
	
	private String message;
	
	private NotFoundExceptionID id;
	
	public NotFoundException(String message, NotFoundExceptionID id) {
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public NotFoundExceptionID getId() {
		return id;
	}
	
	public static enum NotFoundExceptionID {
		
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
	
}
