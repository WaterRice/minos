/**  

* 创建时间：2019年4月14日 下午1:36:49  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：UnAuthorizedExceptionHandler.java  

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
public class UnAuthorizedExceptionHandler {

	@ExceptionHandler(UnAuthorizedException.class)
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
	public Map<String,Object> handleNotFoundException(UnAuthorizedException e) {
		Map<String,Object> responseEntity = new HashMap<>();
		responseEntity.put("message",e.getMessage());
		responseEntity.put("timestamp",System.currentTimeMillis());
		return responseEntity;
	}
}
