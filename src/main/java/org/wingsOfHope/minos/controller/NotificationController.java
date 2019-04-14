/**  

* 创建时间：2019年4月9日 下午7:39:03  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotificationController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Notification;
import org.wingsOfHope.minos.service.NotificationService;

import io.swagger.annotations.Api;

@RestController
@Api("NotificationController API 接口文档")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/notification/latestNews")
	public List<Notification> getLatestNews() throws Exception {
		return notificationService.getLatestNews();
	}
	
}
