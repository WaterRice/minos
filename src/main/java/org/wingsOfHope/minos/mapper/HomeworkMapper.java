/**  

* 创建时间：2019年4月5日 上午10:23:43  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HomeworkMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Homework;

@Mapper
public interface HomeworkMapper {

	@Select("select homework_id, title, to from minos_homework order by from desc limit 20")
	@ResultMap(value="homeworkResultMap")
	List<Homework> getAllHomeworks() throws Exception;
	
	@Select("select descb, repu from minos_homework where homework_id = #{id}")
	@ResultMap(value="homeworkResultMap")
	Homework findById(Integer id) throws Exception;
	
	@Select("select to from minos_homework where homework_id = #{id}")
	Integer getExpiredDateById(Integer id) throws Exception;
	
	
	
}
