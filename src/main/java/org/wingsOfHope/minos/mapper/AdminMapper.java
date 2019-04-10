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
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.wingsOfHope.minos.entity.Admin;

@Mapper
public interface AdminMapper {

	/**
	 * 根据账号查找密码
	 * 
	 * @param String acount
	 * @return String password
	 * @throws Exception
	 * 
	 */
	@Select("SELECT password FROM minos_admin WHERE acount = #{acount}")
	String findPasswordByAcount(String acount) throws Exception;
	
	/**
	 * 根据id查找管理员
	 * 
	 * @param Integer id
	 * @return Admin admin
	 * @throws Exception
	 * 
	 */
	@Select("SELECT id, acount, password, modified FROM minos_admin WHERE id = #{id}")
	Admin findById(Integer id) throws Exception;
	
	/**
	 * 根据账号查找管理员
	 * 
	 * @param String acount
	 * @return Admin admin
	 * @throws Exception
	 * 
	 */
	@Select("SELECT id, acount, password, modified FROM minos_admin WHERE acount = #{acount}")
	Admin findByAcount(String acount) throws Exception;
	
	/**
	 * 根据id更新最近下线时间
	 * 
	 * @param Integer id
	 * @throws Exception
	 * 
	 */
	@Update("UPDATE minos_admin SET modified = #{modified} WHERE id = #{id}")
	void updateModified(Integer id) throws Exception;
	
}
