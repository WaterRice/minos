/**  

* 创建时间：2019年4月6日 上午10:01:08  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubjectMapperTest.java  

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
import org.wingsOfHope.minos.entity.Subject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SubjectMapperTest {

	@Autowired
	SubjectMapper subjectMapper;
	
	@Test
	public void testFindAll() throws Exception {
		List<Subject> lists = subjectMapper.findAll();
		assert lists != null;
		System.out.println(lists.toString());
	}
	
	@Test
	public void testAdd() throws Exception {
		Subject subject = new Subject();
		subject.setName("线性代数");
		subject.setTeacherId(1);
		subjectMapper.add(subject);
	}
	
	@Test
	public void testFindById() throws Exception {
		Subject subject = subjectMapper.findById(1);
		assert subject != null;
		System.out.println(subject);
	}
}
