/**  

* 创建时间：2019年4月8日 下午6:11:26  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：StudentMapperTest.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentMapperTest {

	@Autowired
	StudentMapper studentMapper;
	
	@Test
	public void testFindById() throws Exception {
		Student student = studentMapper.findById(1);
		assert student != null;
		System.out.println(student.toString());
	}
	
	@Test
	public void testFindByAcount() throws Exception {
		Student student = studentMapper.findByAcount("666666");
		assert student != null;
		System.out.println(student.toString());
	}
	
	@Test
	public void testSave() throws Exception {
		Student student = new Student();
		student.setAcount("888888");
		student.setPassword("888888");
		student.setEmail("888888");
		student.setModified(System.currentTimeMillis());
		studentMapper.save(student);
		System.out.println(student.getId());
	}
	
}
