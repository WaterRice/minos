/**  

* 创建时间：2019年3月26日 下午12:41:17  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Admin.java  

* 类说明：  

*/

package org.wingsOfHope.minos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name="minos_admin")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Max(value=64)
	private String acount;
	
	private String password;
	
	private Long modified;
	
	private static final long serialVersionUID = 3422005668404295523L;
	
}
