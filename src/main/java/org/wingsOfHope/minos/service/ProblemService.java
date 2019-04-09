/**  

* 创建时间：2019年4月9日 下午8:29:54  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ProblemService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Problem;
import org.wingsOfHope.minos.mapper.ProblemMapper;

@Service
public class ProblemService {

	@Autowired
	private ProblemMapper problemMapper;
	
	public Problem findById(Integer id) throws Exception {
		return problemMapper.findById(id);
	}
	
	public List<Problem> getAllProblems() throws Exception {
		return problemMapper.getAllProblems();
	}
	
}
