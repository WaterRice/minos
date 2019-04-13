/**  

* 创建时间：2019年4月5日 上午10:00:12  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：StudentMapper.java  

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
import org.wingsOfHope.minos.entity.Student;

@Mapper
public interface StudentMapper {

	/**
	 * 根据id获取学生账号信息
	 * 
	 * @param id
	 * @return Student
	 * @throws Exception
	 * 
	 */
	@Select("select * from minos_student where student_id = #{id}")
	@ResultMap(value="studentResultMap")
	Student findById(@Param("id") Integer id) throws Exception;
	
	/**
	 * 根据账号获取学生账号信息
	 * 
	 * @param acount
	 * @return Student
	 * @throws Exception
	 * 
	 */
	@Select("select * from minos_student where acount = #{acount}")
	@ResultMap(value="studentResultMap")
	Student findByAcount(@Param("acount") String acount) throws Exception;
	
	/**
	 * 添加学生信息
	 * 
	 * @param student
	 * @throws Exception
	 * 
	 */
	
	@Insert("insert into minos_student(acount,password,email) values(#{acount},#{password},#{email})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Student student) throws Exception;
	
	@Select("select student_id from minos_student where acount = #{acount}")
	Integer isAcountExist(String acount) throws Exception;
	
	@Delete("delete from minos_student where student_id = #{id}")
	void delete(Integer id) throws Exception;
	
	@Select("select * from minos_student")
	@ResultMap("studentResultMap")
	List<Student> getAll() throws Exception;
	
}
