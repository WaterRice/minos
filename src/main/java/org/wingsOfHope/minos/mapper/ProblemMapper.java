/**  

* 创建时间：2019年4月5日 下午7:38:28  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ProblemMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Problem;

@Mapper
public interface ProblemMapper {

	/**
	 * 根据id获取问题信息
	 * 
	 * @param id
	 * @return Problem
	 * @throws Exception
	 * 
	 */
	@Select("select * from minos_problem where problem_id = #{id}")
	@ResultMap(value="problemResultMap")
	Problem findById(@Param("id") Integer id) throws Exception;
	
}
