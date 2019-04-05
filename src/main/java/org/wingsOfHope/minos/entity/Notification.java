/**  

* 创建时间：2019年4月5日 下午7:47:22  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Notification.java  

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
public class Notification implements Serializable {

	private Integer id;
	
	private String title;
	
	private String content;
	
	private Long time;
	
	private Teacher teacher;
	
	private static final long serialVersionUID = 8258697817604590113L;
	
}
