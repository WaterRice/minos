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
import org.wingsOfHope.minos.entity.Homework;
import org.wingsOfHope.minos.mapper.HomeworkMapper;

@Service
public class HomeworkService {

	@Autowired
	HomeworkMapper homeworkMapper;
	
	public List<Homework> getAllHomeworks() throws Exception {
		return homeworkMapper.getAllHomeworks();
	}
	
	public Homework findById(Integer id) throws Exception {
		return homeworkMapper.findById(id);
	}
	
	public Long getExpiredDate(Integer id) throws Exception {
		return homeworkMapper.getExpiredDate(id);
	}
	
	public void UpdateExpiredDate(Integer id, Long end) throws Exception {
		homeworkMapper.updateExpiredDate(id, end);
	}
	
	public Integer save(Homework homework) throws Exception {
		return homeworkMapper.save(homework);
	}
	
}
