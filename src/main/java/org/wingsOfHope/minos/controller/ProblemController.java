/**  

* 创建时间：2019年4月9日 下午8:33:53  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ProblemController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Problem;
import org.wingsOfHope.minos.service.ProblemService;

import io.swagger.annotations.Api;

@RestController
@Api("ProblemController API 接口文档")
public class ProblemController {

	@Autowired
	private ProblemService problemService;
	
	@GetMapping("/problems/{id}")
	public Problem findById(@PathVariable Integer id) throws Exception {
		return problemService.findById(id);
	}
	
	@GetMapping("/problems")
	public List<Problem> getAllProblems() throws Exception {
		return problemService.getAllProblems();
	}
	
}
