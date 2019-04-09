/**  

* 创建时间：2019年4月9日 下午8:51:37  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：CodeSubmissionMapperTest.java  

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
import org.wingsOfHope.minos.entity.CodeSubmission;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CodeSubmissionMapperTest {

	@Autowired
	CodeSubmissionMapper codeSubmissionMapper;
	
	@Test
	public void testGetAllSubmissions() throws Exception {
		List<CodeSubmission> submissions = codeSubmissionMapper.getAllSubmissions();
		assert submissions != null && submissions.size() != 0;
		System.out.println(submissions.toString());
	}
	
}
