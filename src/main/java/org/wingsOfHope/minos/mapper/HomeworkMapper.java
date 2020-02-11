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

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.wingsOfHope.minos.entity.Homework;
import org.wingsOfHope.minos.entity.HomeworkDTO;

@Mapper
public interface HomeworkMapper {

	@Select("select homework_id, title, end from minos_homework order by start desc limit 20")
	@ResultMap(value="homeworkResultMap")
	List<Homework> getAllHomeworks() throws Exception;
	
	@Select("select descb, repu from minos_homework where homework_id = #{id}")
	@ResultMap(value="homeworkResultMap")
	Homework findById(Integer id) throws Exception;
	
	@Select("select end from minos_homework where homework_id = #{id}")
	Long getExpiredDate(Integer id) throws Exception;
	
	@Insert("insert into minos_homework(title,descb,repu,start,end,subject_id) "
			+ "values(#{title},#{descb},#{repu},#{start},#{end},#{subjectId})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	Integer save(Homework homework) throws Exception;
	
	@Update("update minos_homework set end = #{end} where homework_id = #{id}")
	void updateExpiredDate(Integer id, Long end) throws Exception;
	
	@Select("select homework_id from minos_homework where homework_id = #{id}")
	Integer isExist(Integer id) throws Exception;
	
	@Select("select sub.sumary,h.homework_id,h.title,h.start,h.end,h.subject_id,s.name as sname from minos_homework h inner join "
			+ "(select subject_id,name from minos_subject where teacher_id = #{tid}) s "
			+ "on h.subject_id = s.subject_id left join (select homework_id,count(*) as sumary from minos_submission) "
			+ "sub on sub.homework_id = h.homework_id")
	@ResultMap("homeworkDTOResultMap")
	List<HomeworkDTO> getAllHomeworksByTid(Integer tid) throws Exception;
	
}
