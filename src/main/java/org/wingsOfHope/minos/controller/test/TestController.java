/**  

* 创建时间：2019年3月17日 下午4:05:21  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TestController.java  

* 类说明：  方便测试的controller类

*/

package org.wingsOfHope.minos.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.exception.NotFoundException;
import org.wingsOfHope.minos.exception.NotFoundException.NotFoundExceptionID;

@RestController
@RequestMapping("/test")
public class TestController {
	
	static Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/hello/{id}")
	public String hello(@PathVariable Integer id) throws Exception {
		if(id > 1000) {
			logger.warn("invalid request: /test/hello/" + id);
			throw new NotFoundException(
				"该用户不存在", NotFoundExceptionID.USER_NOTFOUNDEXCEPTION);
		}
		return "hello" + id;
	}
}
