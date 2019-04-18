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
import org.apache.ibatis.annotations.Update;
import org.wingsOfHope.minos.entity.Submission;

@Mapper
public interface SubmissionMapper {

	@Select("SELECT content,grade,student_id,homework_id "
			+ "FROM minos_submission WHERE submission_id = #{id}")
	@ResultMap(value="submissionResultMap")
	Submission findById(Integer id) throws Exception;
	
	@Insert("INSERT INTO minos_submission(content,time,student_id,homework_id) "
			+ "VALUES(#{content},#{time},#{studentId},#{homeworkId})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Submission submission) throws Exception;
	
	@Select("SELECT submission_id,time,grade,s.student_id,t.name AS sname "
			+ "FROM minos_submission s INNER JOIN minos_student t ON s.student_id = t.student_id "
			+ "WHERE homework_id = #{hid}")
	@ResultMap(value="submissionResultMap")
	List<Submission> getAllSubmissionsByHid(Integer hid) throws Exception;
	
	@Update("UPDATE minos_submission SET grade = #{grade} WHERE submission_id = #{id}")
	void updateGrade(Integer grade, Integer id) throws Exception;
	
	@Select("SELECT submission_id FROM minos_submission "
			+ "WHERE student_id = #{studentId} AND homework_id = #{homeworkId}")
	Integer exist(Integer studentId, Integer homeworkId) throws Exception;
	
	@Select("SELECT s.student_id,s.grade,t.name AS sname FROM minos_submission s INNER JOIN minos_student t "
			+ "ON s.student_id = t.student_id WHERE homework_id = #{hid}")
	@ResultMap("submissionResultMap")
	List<Submission> getGradesSheet(Integer hid) throws Exception;
	
}
