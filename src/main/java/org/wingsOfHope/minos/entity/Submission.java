/**  

* 创建时间：2019年4月5日 上午10:26:45  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Submission.java  

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
public class Submission implements Serializable {

	private Integer id;
	
	private String content;
	
	private Long time;
	
	private Byte grade;
	
	private Student student;
	
	private Homework homework;
	
	private static final long serialVersionUID = -3668586156406763150L;
	
}
