/**  

* 创建时间：2019年3月16日 下午8:07:59  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：UserNotFoundException.java  

* 类说明：  用户不存在异常类
* 
* plus: 异常编号404001

*/

package org.wingsOfHope.minos.exception.concrete;

import org.wingsOfHope.minos.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -682770043850858945L;
	
	public UserNotFoundException() {
		this.message = "用户不存在";
		this.exceptionID = 404001;
	}
	
}
