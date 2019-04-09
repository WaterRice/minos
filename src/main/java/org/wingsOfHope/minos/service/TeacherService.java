/**  

* 创建时间：2019年4月9日 下午7:52:33  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TeacherService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Teacher;
import org.wingsOfHope.minos.mapper.TeacherMapper;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	public Teacher findById(Integer id) throws Exception {
		return teacherMapper.findById(id);
	}
	
	public Teacher findByAcount(String acount) throws Exception {
		return teacherMapper.findByAcount(acount);
	}
	
}
