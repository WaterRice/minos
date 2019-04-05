/**  

* 创建时间：2019年4月4日 下午7:57:29  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Teacher.java  

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
public class Teacher implements Serializable {

	private Integer id;
	
	private String acount;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private Long modified;
	
	private static final long serialVersionUID = -7837724663892820275L;
	
}
