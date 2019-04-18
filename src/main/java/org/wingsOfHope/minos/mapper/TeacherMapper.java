/**  

* 创建时间：2019年4月4日 下午8:05:57  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：TeacherMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Teacher;

@Mapper
public interface TeacherMapper {
	
	@Select("select * from minos_teacher where teacher_id = #{id}")
	@ResultMap(value="teacherResultMap")
	Teacher findById(@Param("id") Integer id) throws Exception;
	
	@Select("select * from minos_teacher where acount = #{acount}")
	@ResultMap(value="teacherResultMap")
	Teacher findByAcount(@Param("acount") String acount) throws Exception;
	
	@Select("select password from minos_teacher where acount = #{acount}")
	String getPasswordByAcount(@Param("acount") String acount) throws Exception;
	
	@Select("select teacher_id,name,acount from minos_teacher")
	@ResultMap("teacherResultMap")
	List<Teacher> getAllTeachers() throws Exception;
	
	@Insert("insert into minos_teacher(name,acount) values(#{name},#{acount})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Teacher teacher) throws Exception;
	
	@Delete("delete from minos_teacher where teacher_id = #{id}")
	void delete(Integer id) throws Exception;
	
}
