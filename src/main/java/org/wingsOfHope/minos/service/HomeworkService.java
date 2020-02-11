/**  

* 创建时间：2019年4月10日 下午7:11:25  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HomeworkService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Homework;
import org.wingsOfHope.minos.entity.HomeworkDTO;
import org.wingsOfHope.minos.mapper.HomeworkMapper;
import org.wingsOfHope.minos.mapper.SubjectMapper;

@Service
public class HomeworkService {

	@Autowired
	HomeworkMapper homeworkMapper;
	
	@Autowired
	SubjectMapper subjectMapper;
	
	@Transactional
	public Boolean sava(Homework homework) throws Exception {
		if(homework == null) return false;
		homework.setStart(System.currentTimeMillis());
		if(subjectMapper.isExist(homework.getSubjectId()) == null) return false;
		homeworkMapper.save(homework);
		return true;
	}
	
	public List<Homework> getAllHomeworks() throws Exception {
		return homeworkMapper.getAllHomeworks();
	}
	
	public Homework findById(Integer id) throws Exception {
		return homeworkMapper.findById(id);
	}
	
	public Long getExpiredDate(Integer id) throws Exception {
		return homeworkMapper.getExpiredDate(id);
	}
	
	public Boolean UpdateExpiredDate(Integer id, Long end) throws Exception {
		homeworkMapper.updateExpiredDate(id, end);
		return true;
	}
	
//	public Integer save(Homework homework) throws Exception {
//		return homeworkMapper.save(homework);
//	}
	
	public List<HomeworkDTO> getAllHomeworksByTid(Integer tid) throws Exception {
		return homeworkMapper.getAllHomeworksByTid(tid);
	}
	
}
