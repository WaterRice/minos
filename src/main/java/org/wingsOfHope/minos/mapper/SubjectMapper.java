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

import org.apache.ibatis.annotations.Mapper;
import org.wingsOfHope.minos.entity.Subject;

@Mapper
public interface SubjectMapper {

	List<Subject> findAll() throws Exception;
}
