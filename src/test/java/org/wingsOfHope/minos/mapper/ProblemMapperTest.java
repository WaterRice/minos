/**  

* 创建时间：2019年4月7日 下午4:50:14  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ProblemMapperTest.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Problem;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProblemMapperTest {

	@Autowired
	ProblemMapper problemMapper;
	
	@Test
	public void testFindById() throws Exception {
		Problem problem = problemMapper.findById(1);
		assert problem != null;
		System.out.println(problem.toString());
	}
	
}
