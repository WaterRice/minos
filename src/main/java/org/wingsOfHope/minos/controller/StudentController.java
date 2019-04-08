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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Student;
import org.wingsOfHope.minos.mapper.StudentMapper;
import org.wingsOfHope.minos.utils.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@Api("StudentController API 接口文档")
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	/**
	 * 学生登录接口
	 * 
	 * @param map
	 * @param response
	 * @return Student
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value="获取token",notes="错误密码时返回null")
	@PostMapping("/token")
	public Student login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
		String acount = map.get("acount");
		String password = map.get("password");
		if(acount == null || password == null) return null;
		Student student = studentMapper.findByAcount(acount);
		if(student == null) return null;
		if(student.getPassword().equals(password)) {
			String token = JWTUtil.getJws(student.getId());
			student.setPassword(null);
			response.setHeader("Authorization", token);
			logger.info("student " + student.getId() + "login!");
			return student;
		}
		return null;
	}
	
	/**
	 * 学生注册接口
	 * 
	 * @param map
	 * @param response
	 * @return Student
	 * @throws Exception
	 * 
	 */
	@PostMapping("/tokens")
	public Student register(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
		String acount = map.get("acount");
		String password = map.get("password");
		String email = map.get("email");
		Student student = new Student();
		student.setAcount(acount).setEmail(email).setPassword(password);
		studentMapper.save(student);
		String token = JWTUtil.getJws(student.getId());
		student.setPassword(null);
		response.setHeader("Authorization", token);
		logger.info("student " + student.getId() + "register!");
		return student;
	}
	
	
}
