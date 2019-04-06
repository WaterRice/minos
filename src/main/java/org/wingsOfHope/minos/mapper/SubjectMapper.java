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
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Subject;

@Mapper
public interface SubjectMapper {

	/**
	 *  获取课程列表
	 * 
	 * @return List<Subject>
	 * @throws Exception
	 * 
	 */
	@Select("select subject_id, name from minos_subject")
	@ResultMap(value="subjectResultMap")
	List<Subject> findAll() throws Exception;
	
	/**
	 * 添加课程信息
	 * 
	 * @param subject
	 * @throws Exception
	 * void
	 */
	@Insert("insert into minos_subject(name,teacher_id) values(#{subject.name},#{subject.teacherId})")
	void add(@Param("subject") Subject subject) throws Exception;
	
}
