/**  

* 创建时间：2019年4月9日 下午8:55:58  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：CodeSubmissionService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.CodeSubmission;
import org.wingsOfHope.minos.mapper.CodeSubmissionMapper;

@Service
public class CodeSubmissionService {

	@Autowired
	private CodeSubmissionMapper codeSubmissionMapper;
	
	public List<CodeSubmission> getAllSubmissions() throws Exception {
		return codeSubmissionMapper.getAllSubmissions();
	}
	
	public Integer save(CodeSubmission codeSubmission) throws Exception {
		codeSubmissionMapper.save(codeSubmission);
		return codeSubmission.getId();
	}
	
}
