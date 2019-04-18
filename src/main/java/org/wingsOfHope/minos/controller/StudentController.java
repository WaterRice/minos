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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.CodeSubmission;
import org.wingsOfHope.minos.entity.Student;
import org.wingsOfHope.minos.entity.Submission;
import org.wingsOfHope.minos.exception.UnAuthorizedException;
import org.wingsOfHope.minos.service.StudentService;
import org.wingsOfHope.minos.utils.CookieUtils;
import org.wingsOfHope.minos.utils.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@Api("StudentController API 接口文档")
public class StudentController {

	@Autowired
	private StudentService studentService;

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
	@ApiOperation(value = "获取token", notes = "错误密码时返回null")
	@PostMapping("/token")
	public Map<String,Object> login(@RequestBody Map<String, String> map, HttpServletResponse response) throws Exception {
		Student student = studentService.login(map.get("acount"), map.get("password"));
		if (student != null) {
			CookieUtils.writeCookie(response, "Authorization", JWTUtil.getJws(student.getId()));
			logger.info("student " + student.getId() + "login!");
		}
		Map<String,Object> res = new HashMap<String, Object>();
		if(student == null) res.put("status", false);
		else res.put("status",true);
		res.put("student",student);
		return res;
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
	@ApiOperation(value = "注册账号并获取token", notes = "账号已存在时返回null")
	@PostMapping("/tokens")
	public Map<String,Object> register(@RequestBody Map<String, String> map, HttpServletResponse response) throws Exception {
		String acount = map.get("acount");
		String password = map.get("password");
		String email = map.get("email");
		Student student = studentService.register(acount, password, email);
		if (student != null) {
			CookieUtils.writeCookie(response, "Authorization", JWTUtil.getJws(student.getId()));
			logger.info("Student" + student.getId() + "register!");
		}
		Map<String,Object> res = new HashMap<String, Object>();
		if(student == null) res.put("status", false);
		else res.put("status",true);
		res.put("student",student);
		return res;
	}

	/**
	 * 学生作业提交接口
	 * 
	 * @param map
	 * @param request
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@PostMapping("/submissions")
	public boolean commit(@RequestBody Map<String, Object> map, HttpServletRequest request) throws Exception {
		boolean flag = false;
		try {
			Integer studentId = JWTUtil.parseJws(CookieUtils.getCookie(request, "Authorization"));
			Submission submission = new Submission().setStudentId(studentId).setContent((String) map.get("content"))
					.setHomeworkId((Integer) map.get("homeworkId"));
			flag = studentService.commit(submission);
		} catch (Exception e) {
			throw new UnAuthorizedException();
		}
		return flag;
	}
	
	/**
	 * 学生代码提交接口
	 * 
	 * @param map
	 * @param request
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@PostMapping("/codesubmissions")
	public boolean codeCommit(@RequestBody Map<String,Object> map, HttpServletRequest request) throws Exception {
		Boolean flag = false;
		try {
			Integer studentId = JWTUtil.parseJws(CookieUtils.getCookie(request, "Authorization"));
			CodeSubmission codeSubmission = new CodeSubmission()
					.setContent((String) map.get("content"))
					.setLanguage((byte) 0)
					.setProblemId((Integer) map.get("problemId"))
					.setStudentId(studentId);
			flag = studentService.commit(codeSubmission);
		} catch (Exception e) {
			throw new UnAuthorizedException();
		}
		return flag;
	}

}
