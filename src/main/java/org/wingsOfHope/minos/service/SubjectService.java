/**  

* 创建时间：2019年4月10日 下午10:49:04  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubjectService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Subject;
import org.wingsOfHope.minos.mapper.SubjectMapper;

@Service
public class SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;
	
	public Subject findById(Integer id) throws Exception {
		return subjectMapper.findById(id);
	}
	
	public Integer add(Subject subject) throws Exception {
		subjectMapper.add(subject);
		return subject.getId();
	}
	
	public List<Subject> getAllSubjectsByTid(Integer tid) throws Exception {
		return subjectMapper.getAllSubjectsByTid(tid);
	}
	
	public void delete(Integer id) throws Exception {
		subjectMapper.delete(id);
	}
	
	public List<Subject> findAll() throws Exception {
		return subjectMapper.findAllByTid();
	}
	
}
