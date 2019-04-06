/**  

* 创建时间：2019年4月5日 上午10:07:06  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Subject.java  

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
public class Subject implements Serializable {

	private Integer id;
	
	private String name;
	
	private Integer teacherId;
	
	private Teacher teacher;
	
	private static final long serialVersionUID = -1033010300824957234L;
	
}
