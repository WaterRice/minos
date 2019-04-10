/**  

* 创建时间：2019年4月10日 下午10:24:23  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubmissionService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Submission;
import org.wingsOfHope.minos.mapper.SubmissionMapper;

@Service
public class SubmissionService {

	@Autowired
	private SubmissionMapper submissionMapper;
	
	public Submission findById(Integer id) throws Exception {
		return submissionMapper.findById(id);
	}
	
	public Integer save(Submission submission) throws Exception {
		submission.setTime(System.currentTimeMillis());
		submissionMapper.save(submission);
		return submission.getId();
	}
	
	public List<Submission> getAllSubmissionsByHid(Integer hid) throws Exception {
		return submissionMapper.getAllSubmissionsByHid(hid);
	}
	
	public void updateGrade(Integer id, Short newGrade) throws Exception {
		submissionMapper.updateGrade(newGrade, id);
	}
	
	public boolean exist(Integer studentId, Integer homeworkId) throws Exception {
		return submissionMapper.exist(studentId, homeworkId) == null ? false : true;
	}
	
}
