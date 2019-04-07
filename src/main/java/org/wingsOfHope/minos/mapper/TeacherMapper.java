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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Teacher;

@Mapper
public interface TeacherMapper {
	
	/**
	 * 根据id获取教师信息
	 * 
	 * @param id
	 * @return Teacher teacher
	 * @throws Exception
	 * 
	 */
	@Select("select * from minos_teacher where teacher_id = #{id}")
	@ResultMap(value="teacherResultMap")
	Teacher findById(@Param("id") Integer id) throws Exception;
	
	/**
	 * 根据账号查找教师信息
	 * 
	 * @param acount
	 * @return Teacher
	 * @throws Exception
	 * 
	 */
	@Select("select * from minos_teacher where acount = #{acount}")
	@ResultMap(value="teacherResultMap")
	Teacher findByAcount(@Param("acount") String acount) throws Exception;
	
	/**
	 * 获取教师账号对应的密码
	 * 
	 * @param acount
	 * @return String password
	 * @throws Exception
	 * 
	 */
	@Select("select password from minos_teacher where acount = #{acount}")
	String getPasswordByAcount(@Param("acount") String acount) throws Exception;
	
}
