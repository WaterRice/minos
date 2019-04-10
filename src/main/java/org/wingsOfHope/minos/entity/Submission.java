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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@JsonInclude(value=Include.NON_NULL)
public class Submission implements Serializable {

	private Integer id;
	
	private String content;
	
	private Long time;
	
	private Byte grade;
	
	private Integer studentId;
	
	private Integer homeworkId;
	
	private Student student;
	
	private Homework homework;
	
	private static final long serialVersionUID = -3668586156406763150L;
	
}
