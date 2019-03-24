/**  

* 创建时间：2019年3月24日 上午10:40:22  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：Test.java  

* 类说明：  

*/

package org.wingsOfHope.minos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Test {

	private Integer id;
	
	private String name;
	
	private Long time;
	
	public static void main(String[] args) {
		Test test = new Test();
		test.setId(1).setName("test").setTime(17777893790L);
		System.out.println(test);
	}
	
}
