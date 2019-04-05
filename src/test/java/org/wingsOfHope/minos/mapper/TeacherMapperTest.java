/**  

* 创建时间：2019年4月5日 上午9:29:30  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TeacherMapperTest.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TeacherMapperTest {
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Test
	public void testFindById() throws Exception {
		Teacher teacher = teacherMapper.findById(1);
		assert teacher != null;
		System.out.println(teacher.toString());
	}
	
}
