/**  

* 创建时间：2019年4月7日 下午7:42:46  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Admin;
import org.wingsOfHope.minos.entity.Problem;
import org.wingsOfHope.minos.entity.Student;
import org.wingsOfHope.minos.entity.Subject;
import org.wingsOfHope.minos.entity.Teacher;
import org.wingsOfHope.minos.service.AdminService;
import org.wingsOfHope.minos.service.ProblemService;
import org.wingsOfHope.minos.service.StudentService;
import org.wingsOfHope.minos.service.SubjectService;
import org.wingsOfHope.minos.service.TeacherService;
import org.wingsOfHope.minos.utils.CookieUtils;
import org.wingsOfHope.minos.utils.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@Api("AdminController API 接口文档")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProblemService problemService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * 管理员登录接口
	 * 
	 * @param map
	 * @param response
	 * @return Admin
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value="获取token", notes="密码错误时返回null")
	@PostMapping("/token")
	public Map<String,Object> login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
		Admin admin = adminService.login(map.get("acount"), map.get("password"));
		if(admin != null) {
			CookieUtils.writeCookie(response, "Authorization", JWTUtil.getJws(admin.getId()));
			logger.info("Admin " + admin.getId() + "login!");
		}
		Map<String,Object> res = new HashMap<String, Object>();
		if(admin == null) res.put("status", false);
		else res.put("status",true);
		res.put("student",admin);
		return res;
	}
	
	@PostMapping("/problems")
	public Integer publishProblem(@RequestBody Map<String,Object> map) throws Exception {
		Problem problem = new Problem()
				.setTitle((String) map.get("title"))
				.setDescb((String) map.get("descb"))
				.setInput((String) map.get("input"))
				.setOutput((String) map.get("output"));
		return problemService.save(problem);
	}
	
	@GetMapping("/problems/{id}")
	public Problem findProblemById(@PathVariable Integer id) throws Exception {
		return problemService.findById(id);
	}
	
	@PutMapping("/problems/{id}")
	public Boolean updateProblemById(@PathVariable Integer id, @RequestBody Map<String,Object> map) throws Exception {
		Problem problem = new Problem()
				.setId(id)
				.setTitle((String) map.get("title"))
				.setDescb((String) map.get("descb"))
				.setInput((String) map.get("input"))
				.setOutput((String) map.get("output"));
		problemService.update(problem);
		return true;
	}
	
	@DeleteMapping("/problems/{id}")
	public Boolean deleteProblemById(@PathVariable Integer id) throws Exception {
		problemService.delete(id);
		return true;
	}
	
	@GetMapping("/problems")
	public List<Problem> getAllProblems() throws Exception {
		return problemService.getAllProblems();
	}
	
	@GetMapping("/subjects/{id}")
	public Subject findSubjectById(@PathVariable Integer id) throws Exception {
		return subjectService.findById(id);
	}
	
	@GetMapping("/subjects")
	public List<Subject> findAllSubjects() throws Exception {
		return subjectService.findAll();
	}
	
	@PostMapping("/subjects")
	public Integer savaSubject(@RequestBody Map<String,Object> map) throws Exception {
		Subject subject = new Subject()
				.setName((String) map.get("name"))
				.setTeacherId((Integer) map.get("teacherId"));
		return subjectService.add(subject);
	}
	
	@DeleteMapping("/subjects/{id}")
	public boolean delete(@PathVariable Integer id) throws Exception {
		subjectService.delete(id);
		return true;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() throws Exception {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student findStudentById(@PathVariable Integer id) throws Exception {
		return studentService.findById(id);
	}
	
	@DeleteMapping("/students/{id}")
	public boolean deleteStudentById(@PathVariable Integer id) throws Exception {
		studentService.delete(id);
		return true;
	}
	
	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers() throws Exception {
		return teacherService.getAll();
	}
	
	@GetMapping("/teachers/{id}")
	public Teacher findTeacherById(@PathVariable Integer id) throws Exception {
		return teacherService.findById(id);
	}
	
	@PostMapping("/teachers")
	public Integer saveTeacher(@RequestBody Map<String,Object> map) throws Exception {
		Teacher teacher = new Teacher()
				.setName((String) map.get("name"))
				.setAcount((String) map.get("acount"));
		teacherService.save(teacher);
		return teacher.getId();
	}
	
	@DeleteMapping("/teachers/{id}")
	public boolean deleteTeacherById(@PathVariable Integer id) throws Exception {
		teacherService.delete(id);
		return true;
	}
	
}
