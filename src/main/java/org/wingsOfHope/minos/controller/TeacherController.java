/**  

* 创建时间：2019年4月7日 下午8:56:12  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TeacherController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Homework;
import org.wingsOfHope.minos.entity.Notification;
import org.wingsOfHope.minos.entity.Problem;
import org.wingsOfHope.minos.entity.Subject;
import org.wingsOfHope.minos.entity.Submission;
import org.wingsOfHope.minos.entity.Teacher;
import org.wingsOfHope.minos.exception.UnAuthorizedException;
import org.wingsOfHope.minos.service.HomeworkService;
import org.wingsOfHope.minos.service.NotificationService;
import org.wingsOfHope.minos.service.ProblemService;
import org.wingsOfHope.minos.service.SubjectService;
import org.wingsOfHope.minos.service.SubmissionService;
import org.wingsOfHope.minos.service.TeacherService;
import org.wingsOfHope.minos.utils.CookieUtils;
import org.wingsOfHope.minos.utils.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/teacher")
@Api("TeacherController API 接口文档")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private HomeworkService homeworkService;
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private ProblemService problemService;
	
	@Autowired
	private SubjectService subjectService;
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	/**
	 * 教师登录接口
	 * 
	 * @param map
	 * @param response
	 * @return Teacher
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value="获取token", notes="密码不对时返回null")
	@PostMapping("/token")
	public Map<String,Object> login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
		Teacher teacher = teacherService.login(map.get("acount"), map.get("password"));
		if(teacher != null) {
			CookieUtils.writeCookie(response, "Authorization", JWTUtil.getJws(teacher.getId()));
			logger.info("Teacher " + teacher.getId() + "login!");
		}
		Map<String,Object> res = new HashMap<String, Object>();
		if(teacher == null) res.put("status", false);
		else res.put("status",true);
		res.put("student",teacher);
		return res;
	}
	
	/**
	 * 教师获取布置的所有作业
	 * 
	 * @param request
	 * @return List<Homework>
	 * @throws Exception
	 * 
	 */
	@GetMapping("/publishedHomeworks")
	public List<Homework> homeworks(HttpServletRequest request) throws Exception {
		List<Homework> homeworks = null;
		try {
			Integer tid = JWTUtil.parseJws(CookieUtils.getCookie(request, "Authorization"));
			homeworks = homeworkService.getAllHomeworksByTid(tid);
		} catch(Exception e) {
			throw new UnAuthorizedException();
		}
		return homeworks;
	}
	
	/**
	 * 获得布置的某种作业的所有提交
	 * 
	 * @param hid
	 * @return List<Submission>
	 * @throws Exception
	 * 
	 */
	@GetMapping("/submissions")
	public List<Submission> getAllSubmissionsByHid(@RequestParam Integer hid) throws Exception {
		return submissionService.getAllSubmissionsByHid(hid);
	}
	
	/**
	 * 查看某位同学的提交
	 * 
	 * @param id
	 * @return Submission
	 * @throws Exception
	 * 
	 */
	@GetMapping("/submissions/{id}")
	public Submission findById(@PathVariable Integer id) throws Exception {
		return submissionService.findById(id);
	}
	
	/**
	 * 给某份提交打分
	 * 
	 * @param id
	 * @param grade
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@PutMapping("/submissions/{id}")
	public Boolean comment(@PathVariable Integer id,@RequestParam Short grade) throws Exception {
		return submissionService.updateGrade(id, grade);
	}
	
	/**
	 * 发布作业
	 * 
	 * @param map
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@PostMapping("/homeworks")
	public Boolean publishHomework(@RequestBody Map<String,Object> map, HttpServletRequest request) throws Exception {
		Homework homework = new Homework()
				.setTitle((String) map.get("title"))
				.setDescb((String) map.get("descb"))
				.setRepu((String) map.get("repu"))
				.setSubjectId((Integer) map.get("subjectId"))
				.setEnd((Long) map.get("end"));
		homeworkService.sava(homework);
		try {
			Integer tid = JWTUtil.parseJws(CookieUtils.getCookie(request, "Authorization"));
			Teacher teacher = teacherService.findById(tid);
			Notification notification = new Notification()
					.setContent(teacher.getName() + "老师发布了作业---" + homework.getTitle()).setTitle("作业通知")
					.setTime(System.currentTimeMillis());
			notificationService.save(notification);
			return true;
		} catch (Exception e) {
			throw new UnAuthorizedException();
		}
	}
	
	@PutMapping("/homework/{id}")
	public Boolean updateExpDate(@PathVariable Integer id,@RequestParam Long end) throws Exception {
		return homeworkService.UpdateExpiredDate(id, end);
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
	
	@GetMapping("/subjects")
	public List<Subject> getMySubjects(HttpServletRequest request) throws Exception {
		Integer tid = JWTUtil.parseJws(CookieUtils.getCookie(request, "Authorization"));
		return subjectService.getAllSubjectsByTid(tid);
	}
	
}
