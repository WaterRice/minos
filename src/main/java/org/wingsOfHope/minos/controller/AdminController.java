/**  

* 创建时间：2019年4月7日 下午7:42:46  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingsOfHope.minos.entity.Admin;
import org.wingsOfHope.minos.mapper.AdminMapper;
import org.wingsOfHope.minos.utils.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@Api("AdminController API 接口文档")
public class AdminController {
	
	@Autowired
	private AdminMapper adminMapper;
	
	/**
	 * 管理员登录接口
	 * 
	 * @param map
	 * @param response
	 * @return Admin
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value="获取token", notes="没有数据时返回null")
	@PostMapping("/token")
	public Admin login(@RequestBody Map<String,Object> map, HttpServletResponse response) throws Exception {
		String acount = (String) map.get("acount");
		String password = (String) map.get("password");
		Admin admin = adminMapper.findByAcount(acount);
		if(admin == null) return null;
		if(admin.getPassword().equals(password)) {
			String token = JWTUtil.getJws(admin.getId());
			admin.setPassword(null);
			response.setHeader("Authorization", token);
			return admin;
		}
		return null;
	}
}
