/**  

* 创建时间：2019年3月26日 下午12:55:48  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminRepository.java  

* 类说明：  

*/

package org.wingsOfHope.minos.repository;

import org.springframework.data.repository.CrudRepository;
import org.wingsOfHope.minos.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	public Admin findByAcount(String acount);
	
}
