/**  

* 创建时间：2019年4月4日 下午8:23:54  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminMapperTest.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AdminMapperTest {

	@Autowired
	AdminMapper adminMapper;
	
	@Test
	public void testFindByAcount() throws Exception {
		Admin admin = adminMapper.findByAcount("123456");
		assert admin != null;
		System.out.println(admin);
	}
	
}
