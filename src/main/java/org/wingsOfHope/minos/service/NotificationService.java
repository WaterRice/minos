/**  

* 创建时间：2019年4月9日 下午7:35:44  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotificationService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Notification;
import org.wingsOfHope.minos.mapper.NotificationMapper;

@Service
public class NotificationService {

	@Autowired
	private NotificationMapper notificationMapper;
	
	public List<Notification> getLatestNews() throws Exception {
		return notificationMapper.getLatestNews();
	}
	
	public Integer save(Notification notification) throws Exception {
		notificationMapper.save(notification);
		return notification.getId();
	}
}
