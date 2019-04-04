/**  

* 创建时间：2019年4月4日 下午7:21:12  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：AdminMapper.java  

* 类说明：  

*/

package org.wingsOfHope.minos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wingsOfHope.minos.entity.Admin;

@Mapper
public interface AdminMapper {

	/**
	 *     根据账号查找密码
	 * 
	 * @param acount
	 * 
	 * @return Admin
	 * 
	 */
	@Select("select password from minos_admin where acount = #{acount}")
	Admin findByAcount(@Param("acount") String acount) throws Exception;
	
}
