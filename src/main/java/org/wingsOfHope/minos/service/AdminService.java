/**  

* 创建时间：2019年4月9日 下午7:49:05  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Admin;
import org.wingsOfHope.minos.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	public Admin findById(Integer id) throws Exception {
		return adminMapper.findById(id);
	}
	
	public Admin findByAcount(String acount) throws Exception {
		return adminMapper.findByAcount(acount);
	}
	
}
