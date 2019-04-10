/**  

* 创建时间：2019年4月10日 下午10:04:58  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubmissionMapperTest.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Submission;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SubmissionMapperTest {

	@Autowired
	SubmissionMapper submissionMapper;
	
	@Test
	public void testFindById() throws Exception {
		Submission submission = submissionMapper.findById(1);
		assert submission != null;
		System.out.println(submission.toString());
	}
	
	@Test
	public void testSave() throws Exception {
		Submission submission = new Submission()
				.setContent("content")
				.setTime(0L)
				.setHomeworkId(1)
				.setStudentId(1);
		submissionMapper.save(submission);
		assert submission.getId() != null;
		System.out.println(submission.toString());
	}
	
	@Test
	public void testGetAllSubmissionsByHid() throws Exception {
		List<Submission> submissions = submissionMapper.getAllSubmissionsByHid(1);
		assert submissions != null && submissions.size() != 0;
		System.out.println(submissions.toString());
	}
	
	@Test
	public void testUpdateGrade() throws Exception {
		submissionMapper.updateGrade((short) 100, 1);
	}
	
	@Test
	public void testExist() throws Exception {
		Integer id = submissionMapper.exist(1, 1);
		assert id != null;
		System.out.println(id);
	}
	
}
