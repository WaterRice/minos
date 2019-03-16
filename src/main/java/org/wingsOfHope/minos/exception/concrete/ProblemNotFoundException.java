/**  

* 创建时间：2019年3月16日 下午8:26:55  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ProblemNotFoundException.java  

* 类说明：  问题不存在异常类
* 
* plus: 异常ID 404004

*/

package org.wingsOfHope.minos.exception.concrete;

import org.wingsOfHope.minos.exception.NotFoundException;

public class ProblemNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 6995925108689984814L;

	public ProblemNotFoundException() {
		this.message = "问题不存在";
		this.exceptionID = 404004;
	}
	
}
