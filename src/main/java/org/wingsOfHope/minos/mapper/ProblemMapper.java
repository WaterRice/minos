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

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Problem;

@Mapper
public interface ProblemMapper {

	@Select("SELECT * FROM minos_problem WHERE problem_id = #{id}")
	@ResultMap(value="problemResultMap")
	Problem findById(Integer id) throws Exception;
	
	@Select("SELECT problem_id,title FROM minos_problem LIMIT 0, 100")
	@ResultMap(value="problemResultMap")
	List<Problem> getAllProblems() throws Exception;
	
	@Insert("INSERT INTO minos_problem(title,descb,input,output)"
			+ " VALUES(#{title},#{descb},#{input},#{output})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Problem problem) throws Exception;
	
	@Select("select input,output from minos_problem where problem_id = #{id}")
	Map<String,String> getData(Integer id) throws Exception;
	
}
