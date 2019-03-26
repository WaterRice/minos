/**  

* 创建时间：2019年3月26日 下午1:09:09  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminRepositoryTest.java  

* 类说明：  

*/

package org.wingsOfHope.minos.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wingsOfHope.minos.entity.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest
//开启事务防止测试污染数据库环境
@Transactional
public class AdminRepositoryTest {

	@Autowired
	AdminRepository adminRepository;
	
	@Test
	//回滚防止测试污染数据库环境
	@Rollback
	public void testAdminRepository() {
		Admin admin = new Admin();
		admin.setAcount("1236789").setPassword("1238900").setModified(1768939499L);
		System.out.println(adminRepository.findByAcount("123456"));
		//System.out.println(adminRepository.save(new Admin()));
	}
	
}
