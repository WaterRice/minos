/**  

* 创建时间：2019年4月10日 下午6:42:38  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HomeworkMapperTest.java  

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
import org.wingsOfHope.minos.entity.Homework;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HomeworkMapperTest {

	@Autowired
	HomeworkMapper homeworkMapper;
	
	@Test
	public void testFindById() throws Exception {
		Homework homework = homeworkMapper.findById(1);
		assert homework != null;
		System.out.println(homework.toString());
	}
	
	@Test
	public void testGetAllHomeworks() throws Exception {
		List<Homework> homeworks = homeworkMapper.getAllHomeworks();
		assert homeworks != null && homeworks.size() != 0;
		System.out.println(homeworks.toString());
	}
	
	@Test
	public void testGetExpiredDate() throws Exception {
		Long expiredDate = homeworkMapper.getExpiredDate(1);
		assert expiredDate != null;
		System.out.println(expiredDate);
	}
	
	@Test
	public void testUpdateExpiredDate() throws Exception {
		homeworkMapper.updateExpiredDate(1, 99999999L);
	}
	
	@Test
	public void testSave() throws Exception {
		Homework homework = new Homework();
		homework.setTitle("title").setDescb("descb").setRepu("repu").setStart(0L).setEnd(0L).setSubjectId(1);
		System.out.println(homeworkMapper.save(homework));
	}
	
	@Test
	public void testGetAllHomeworksByTid() throws Exception {
		List<Homework> homeworks = homeworkMapper.getAllHomeworksByTid(1);
		assert homeworks != null && homeworks.size() != 0;
		System.out.println(homeworks.toString());
	}
	
}
