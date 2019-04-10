/**  

* 创建时间：2019年4月5日 上午10:31:02  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubmissionMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Submission;

@Mapper
public interface SubmissionMapper {

	@Select("select content,grade,student_id,homework_id "
			+ "from minos_submission where submission_id = #{id}")
	@ResultMap(value="submissionResultMap")
	Submission findById(Integer id) throws Exception;
	
	@Insert("insert into minos_submission(content,time,student_id,homework_id) "
			+ "values(#{content},#{time},#{student_id},#{homework_id})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Submission submission) throws Exception;
	
	List<Submission> getAllSubmissionByHid(Integer id) throws Exception;
	
	void updateGrade(Short grade) throws Exception;
	
}
