/**  

* 创建时间：2019年4月5日 上午10:17:04  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubjectMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Subject;

@Mapper
public interface SubjectMapper {
	
	/**
	 * 根据id获取课程信息
	 * 
	 * @param id
	 * @return Subject
	 * @throws Exception
	 * 
	 */
	@Select("SELECT s.*, t.name as tname "
			+ "FROM (SELECT * FROM minos_subject WHERE subject_id = #{id}) s "
			+ "INNER JOIN minos_teacher t ON s.teacher_id = t.teacher_id")
	@ResultMap(value="subjectResultMap")
	Subject findById(Integer id) throws Exception;

	/**
	 *  获取课程列表
	 * 
	 * @return List<Subject>
	 * @throws Exception
	 * 
	 */
	@Select("SELECT subject_id, name FROM minos_subject")
	@ResultMap(value="subjectResultMap")
	List<Subject> findAll() throws Exception;
	
	/**
	 *  添加课程信息
	 * 
	 * @param subject
	 * @throws Exception
	 * void
	 */
	@Insert("INSERT INTO minos_subject(name,teacher_id) VALUES(#{name},#{teacherId})")
	void add(Subject subject) throws Exception;
	
	@Select("SELECT name,subject_id FROM minos_subject WHERE teacher_id = #{id}")
	@ResultMap(value="subjectResultMap")
	List<Subject> getAllSubjectsByTid(Integer tid) throws Exception;
	
}
