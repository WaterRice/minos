/**  

* 创建时间：2019年4月9日 下午7:43:09  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：StudentService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.CodeSubmission;
import org.wingsOfHope.minos.entity.Student;
import org.wingsOfHope.minos.entity.Submission;
import org.wingsOfHope.minos.judge.java.compiler.StringSourceCodeCompiler;
import org.wingsOfHope.minos.judge.java.executor.JavaClassExecutor;
import org.wingsOfHope.minos.mapper.CodeSubmissionMapper;
import org.wingsOfHope.minos.mapper.HomeworkMapper;
import org.wingsOfHope.minos.mapper.ProblemMapper;
import org.wingsOfHope.minos.mapper.StudentMapper;
import org.wingsOfHope.minos.mapper.SubmissionMapper;
import org.wingsOfHope.minos.utils.EncodeUtils;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private HomeworkMapper homeworkMapper;

	@Autowired
	private SubmissionMapper submissionMapper;

	@Autowired
	private CodeSubmissionMapper codeSubmissionMapper;

	@Autowired
	private ProblemMapper problemMapper;

	/**
	 * 学生账号登录
	 * 
	 * @param String acount
	 * @param String password
	 * @return Student student
	 * @throws Exception
	 * 
	 */
	public Student login(String acount, String password) throws Exception {
		if (acount == null || password == null)
			return null;
		Student student = findByAcount(acount);
		if (student == null)
			return null;
		password = EncodeUtils.MD5Encode(password);
		if (student.getPassword().equals(password)) {
			student.setPassword(null);
			return student;
		} else {
			return null;
		}
	}

	/**
	 * 学生注册账号
	 * 
	 * @param acount
	 * @param password
	 * @param email
	 * @return Student student
	 * @throws Exception
	 * 
	 */
	public Student register(String acount, String password, String email) throws Exception {
		if (acount == null || password == null || email == null)
			return null;
		if (isAcountExist(acount))
			return null;
		Student student = new Student().setAcount(acount).setPassword(EncodeUtils.MD5Encode(password)).setEmail(email);
		save(student);
		student.setPassword(null);
		return student;
	}

	public Boolean commit(Submission submission) throws Exception {
		if (submission.getContent() == null || submission.getHomeworkId() == null)
			return false;
		if (homeworkMapper.isExist(submission.getHomeworkId()) == null)
			return false;
		if (submissionMapper.exist(submission.getStudentId(), submission.getHomeworkId()) != null)
			return false;
		submission.setTime(System.currentTimeMillis());
		submissionMapper.save(submission);
		return true;
	}

	public Boolean commit(CodeSubmission codeSubmission) throws Exception {
		if (codeSubmission.getContent() == null || codeSubmission.getProblemId() == null
				|| codeSubmission.getStudentId() == null)
			return false;
		DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
		Map<String, String> data = problemMapper.getData(codeSubmission.getProblemId());
		byte[] classBytes = StringSourceCodeCompiler.compile(codeSubmission.getContent(), collector);
		String ans = JavaClassExecutor.execute(classBytes, data.get("input"));
		if (data.get("output").equals(ans)) {
			codeSubmission.setStatus((byte) 0);
		} else {
			codeSubmission.setStatus((byte) 1);
		}
		codeSubmission.setTime(System.currentTimeMillis());
		codeSubmissionMapper.save(codeSubmission);
		return true;
	}

	public Student findById(Integer id) throws Exception {
		return studentMapper.findById(id);
	}

	public Student findByAcount(String acount) throws Exception {
		return studentMapper.findByAcount(acount);
	}

	public void save(Student student) throws Exception {
		studentMapper.save(student);
	}

	public boolean isAcountExist(String acount) throws Exception {
		return studentMapper.isAcountExist(acount) == null ? false : true;
	}

}
