/**  

* 创建时间：2019年4月4日 下午7:23:05  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Admin.java  

* 类说明：  

*/

package org.wingsOfHope.minos.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value=Include.NON_NULL)
public class Admin implements Serializable {

	private Integer id;
	
	private String acount;
	
	private String password;
	
	private Long modified;
	
	private static final long serialVersionUID = -9084718288837008507L;
	
}
