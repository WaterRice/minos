/**  

* 创建时间：2019年4月7日 下午9:09:47  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：StudentController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Student;
import org.wingsOfHope.minos.mapper.StudentMapper;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/student")
@Api("StudentController API 接口文档")
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;
	
	@PostMapping("/token")
	public Student login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
		String acount = map.get("acount");
		String password = map.get("password");
		if(acount == null || password == null) return null;
		return null;
	}
	
}
