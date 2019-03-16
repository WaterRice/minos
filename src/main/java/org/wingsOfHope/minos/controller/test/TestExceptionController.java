/**  

* 创建时间：2019年3月16日 下午9:21:16  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TestException.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.exception.concrete.UserNotFoundException;

@RestController
@RequestMapping("/test")
public class TestExceptionController {

	@GetMapping("/hello/{id}")
	public String hello(@PathVariable Integer id) throws Exception {
		if(id > 1000) {
			throw new UserNotFoundException();
		}
		return "hello" + id;
	}
	
}
