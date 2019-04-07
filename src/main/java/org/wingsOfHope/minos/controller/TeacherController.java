/**  

* 创建时间：2019年4月7日 下午8:56:12  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TeacherController.java  

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
import org.wingsOfHope.minos.entity.Teacher;
import org.wingsOfHope.minos.mapper.TeacherMapper;
import org.wingsOfHope.minos.utils.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/teacher")
@Api("TeacherController API 接口文档")
public class TeacherController {

	@Autowired
	private TeacherMapper teacherMapper;
	
	/**
	 * 教师登录接口
	 * 
	 * @param map
	 * @param response
	 * @return Teacher
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value="获取token", notes="没有数据时返回null")
	@PostMapping("/token")
	public Teacher login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
		String acount = map.get("acount");
		String password = map.get("password");
		Teacher teacher = teacherMapper.findByAcount(acount);
		if(teacher == null) return null;
		if(teacher.getPassword().equals(password)) {
			String token = JWTUtil.getJws(teacher.getId());
			teacher.setPassword(null);
			response.setHeader("Authorization", token);
			return teacher;
		}
		return null;
	}
	
}
