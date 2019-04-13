/**  

* 创建时间：2019年4月10日 下午7:17:10  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HomeworkController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Homework;
import org.wingsOfHope.minos.service.HomeworkService;

@RestController
public class HomeworkController {

	@Autowired
	HomeworkService homeworkService;
	
	@GetMapping("/homeworks")
	public List<Homework> getAllHomeworks() throws Exception {
		return homeworkService.getAllHomeworks();
	}
	
	@GetMapping("/homeworks/{id}")
	public Homework findById(@PathVariable Integer id) throws Exception {
		return homeworkService.findById(id);
	}
	
}
