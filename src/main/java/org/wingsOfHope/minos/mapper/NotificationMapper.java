/**  

* 创建时间：2019年4月5日 下午7:49:49  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：NotificationMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Notification;

@Mapper
public interface NotificationMapper {

	@Select("SELECT * FROM minos_notification ORDER BY time DESC LIMIT 8")
	List<Notification> getLatestNews() throws Exception;
	
}
