/**  

* 创建时间：2019年3月16日 下午8:23:56  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TeacherNotFoundException.java  

* 类说明：  教师不存在异常类
* 
* plus: 异常ID 404003

*/

package org.wingsOfHope.minos.exception.concrete;

import org.wingsOfHope.minos.exception.NotFoundException;

public class TeacherNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 9205385021100460593L;

	public TeacherNotFoundException() {
		this.message = "教师不存在";
		this.exceptionID = 404003;
	}
	
}
