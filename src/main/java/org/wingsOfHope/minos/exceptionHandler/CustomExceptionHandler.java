/**  

* 创建时间：2019年3月16日 下午8:56:28  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ExceptionHandler.java  

* 类说明：  异常处理类

*/

package org.wingsOfHope.minos.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.wingsOfHope.minos.exception.NotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public Map<String,Object> handleNotFoundException(NotFoundException e) {
		Map<String,Object> map = new HashMap<>();
		map.put("timestamp",System.currentTimeMillis());
		map.put("message",e.getMessage());
		map.put("problemID", e.getExceptionID());
		map.put("help","http://localhost/exceptions/" + e.getExceptionID());
		return map;
	}
}
