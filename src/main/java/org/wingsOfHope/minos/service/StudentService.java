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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	
	@Autowired
	private ExecuteStringSourceService executeStringSourceService;

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
	@Transactional
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

	/**
	 * 学生提交作业
	 * 
	 * @param submission
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@Transactional
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

	/**
	 * 学生提交代码
	 * 
	 * @param codeSubmission
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@Transactional
	public boolean commit(CodeSubmission codeSubmission) throws Exception {
		boolean flag = false;
		if (codeSubmission.getContent() == null || codeSubmission.getProblemId() == null
				|| codeSubmission.getStudentId() == null)
			return false;
		
		Map<String, String> data = problemMapper.getData(codeSubmission.getProblemId());
		
//		String ans = executeStringSourceService.execute(codeSubmission.getContent(), data.get("input"));
		DiagnosticCollector<JavaFileObject> compileCollector = new DiagnosticCollector<>();
		byte[] classBytes = StringSourceCodeCompiler.compile(codeSubmission.getContent(), compileCollector);
		String ans = JavaClassExecutor.execute(classBytes, data.get("input"));
		
		String output = data.get("output");
		ans = ans.replaceAll("\r", "");
		System.out.println(ans);
		System.out.println(data.get("output"));
		if (output.equals(ans)) {
			codeSubmission.setStatus((byte) 0);
			flag = true;
		} else {
			codeSubmission.setStatus((byte) 1);
		}
		codeSubmission.setTime(System.currentTimeMillis());
		codeSubmissionMapper.save(codeSubmission);
		return flag;
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
	
	public List<Student> getAllStudents() throws Exception {
		return studentMapper.getAll();
	}
	
	public void delete(Integer id) throws Exception {
		studentMapper.delete(id);
	}
	
	public static void main(String[] args) throws IOException {
		
		InputStream inputStream = new ByteArrayInputStream("5 6 7 8 9  8\n".getBytes());
		
		InputStream inputStream2 = new ByteArrayInputStream("10 11 12 13\n".getBytes());
		
		System.setIn(inputStream);
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextInt());

		System.setIn(inputStream2);
		
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println(scanner2.nextInt());
		System.out.println(scanner2.nextInt());
		System.out.println(scanner2.nextInt());
		System.out.println(scanner2.nextInt());
		
//		System.setIn(inputStream2);
//		
//		System.out.println(scanner.nextInt());
		
	}

}
