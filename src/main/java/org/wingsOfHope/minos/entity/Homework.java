/**  

* 创建时间：2019年4月5日 上午10:20:31  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Homework.java  

* 类说明：  

*/

package org.wingsOfHope.minos.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Homework implements Serializable {

	private Integer id;
	
	private String title;
	
	private String descb;
	
	private String repu;
	
	private Long from;
	
	private Long to;
	
	private Subject subject;
	
	private static final long serialVersionUID = -7567299842716266220L;
	
}
