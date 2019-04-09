/**  

* 创建时间：2019年4月9日 下午8:59:09  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：CodeSubmissionController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.CodeSubmission;
import org.wingsOfHope.minos.service.CodeSubmissionService;

@RestController
@RequestMapping("/codeSubmissions")
public class CodeSubmissionController {

	@Autowired
	private CodeSubmissionService codeSubmissionService;
	
	@GetMapping("/")
	public List<CodeSubmission> getAllSubmissions() throws Exception {
		return codeSubmissionService.getAllSubmissions();
	}
	
}
