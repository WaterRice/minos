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
import org.wingsOfHope.minos.utils.EncodeUtils;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	public Teacher login(String acount, String password) throws Exception {
		if(acount == null || password == null) return null;
		Teacher teacher = teacherMapper.findByAcount(acount);
		if(teacher == null) return null;
		password = EncodeUtils.MD5Encode(password);
		if(teacher.getPassword().equals(password)) {
			teacher.setPassword(null);
			return teacher;
		} else return null;
	}
	
	public Teacher findById(Integer id) throws Exception {
		return teacherMapper.findById(id);
	}
	
	public Teacher findByAcount(String acount) throws Exception {
		return teacherMapper.findByAcount(acount);
	}
	
}
