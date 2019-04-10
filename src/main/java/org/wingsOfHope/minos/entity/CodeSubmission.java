/**  

* 创建时间：2019年4月5日 下午7:41:19  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：CodeSubmission.java  

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
public class CodeSubmission implements Serializable {

	private Integer id;
	
	private String content;
	
	private Byte status;
	
	private Integer studentId;
	
	private Student student;
	
	private Integer problemId;
	
	private Problem problem;
	
	private Long time;
	
	private Byte language;
	
	private static final long serialVersionUID = -6266416161177344339L;
	
}
