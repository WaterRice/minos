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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Student;
import org.wingsOfHope.minos.mapper.StudentMapper;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public Student findById(Integer id) throws Exception {
		return studentMapper.findById(id);
	}
	
	public Student findByAcount(String acount) throws Exception {
		return studentMapper.findByAcount(acount);
	}
	
	public void save(Student student) throws Exception {
		studentMapper.save(student);
	}
	
}
