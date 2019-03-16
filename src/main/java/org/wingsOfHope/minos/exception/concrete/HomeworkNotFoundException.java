/**  

* 创建时间：2019年3月16日 下午8:20:23  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HomeworkNotFoundException.java  

* 类说明：  作业不存在异常
* 
* plus: 异常ID 404002

*/

package org.wingsOfHope.minos.exception.concrete;

import org.wingsOfHope.minos.exception.NotFoundException;

public class HomeworkNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -8287610366445275054L;

	public HomeworkNotFoundException() {
		this.message = "作业不存在";
		this.exceptionID = 404002;
	}
}
