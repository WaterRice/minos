/**  

* 创建时间：2019年4月9日 下午7:28:30  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotificationMapperTest.java  

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
import org.wingsOfHope.minos.entity.Notification;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NotificationMapperTest {

	@Autowired
	NotificationMapper notificationMapper;
	
	@Test
	public void testGetLatestNews() throws Exception {
		List<Notification> news = notificationMapper.getLatestNews();
		assert news != null;
		for(Notification notification : news) {
			System.out.println(notification.toString());
		}
	}
	
}
