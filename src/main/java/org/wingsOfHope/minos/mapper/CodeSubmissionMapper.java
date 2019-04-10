/**  

* 创建时间：2019年4月5日 下午7:45:41  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：CodeSubmissionMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.CodeSubmission;

@Mapper
public interface CodeSubmissionMapper {

	@Select("SELECT c.codesubmission_id, c.status, c.time, c.language, c.problem_id, s.name AS sname "
			+ "FROM minos_codesubmission c INNER JOIN minos_student s "
			+ "ON c.student_id = s.student_id")
	@ResultMap(value="codeSubmissionResultMap")
	List<CodeSubmission> getAllSubmissions() throws Exception;
	
	@Insert("INSERT INTO minos_codesubmission(content,status,studentId,problemId,time,language) "
			+ "VALUES(#{content},#{status},#{studentId},#{problemId},#{time},#{language})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(CodeSubmission codeSubmission) throws Exception;
	
	@Select("SELECT codesubmission_id FROM minos_codesubmission "
			+ "WHERE student_id = #{studentId} AND problem_id = #{problemId}")
	Integer exist(Integer studentId, Integer problemId) throws Exception;
	
}
