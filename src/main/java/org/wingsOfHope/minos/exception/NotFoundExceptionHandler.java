/**  

* 创建时间：2019年3月19日 下午7:04:55  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotFoundExceptionHandler.java  

* 类说明：  

*/

package org.wingsOfHope.minos.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {

	/*
	 * @param NotFoundException异常类
	 * 
	 * NotFoundException的处理类
	 * 
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public Map<String,Object> handleNotFoundException(NotFoundException e) {
		Map<String,Object> responseEntity = new HashMap<>();
		responseEntity.put("help", "http://localhost:8081/exception/" + e.getId().getID());
		responseEntity.put("message",e.getMessage());
		responseEntity.put("code",e.getId().getID());
		responseEntity.put("timestamp",System.currentTimeMillis());
		return responseEntity;
	}
	
}
