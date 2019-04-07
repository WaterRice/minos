/**  

* 创建时间：2019年3月20日 下午5:09:54  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TestController.java  

* 类说明：  

*/

package org.wingsOfHope.minos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
@Api("TestController Api 接口文档")
public class TestController {

	@ApiOperation(value="获取所有答案", notes="没有数据时返回[]")
	//@ApiImplicitParam(name="id", value="题号", required=true, dataType="Integer")
	@GetMapping("/ans/{id}")
	public List<Integer> getAns(@PathVariable Integer id) {
		List<Integer> ans = new ArrayList<>();
		ans.add(id + 1);
		ans.add(id + 3);
		return ans;
	}
	
	@GetMapping("/token")
	public void getToken(HttpServletResponse response) {
		
	}
}
