/**  

* 创建时间：2019年3月26日 下午7:44:28  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：EncodeUtils.java  

* 类说明：  

*/

package org.wingsOfHope.minos.utils;

import org.springframework.util.DigestUtils;

public class EncodeUtils {

	public static String MD5Encode(String original) {
		if(original == null) return null;
		return DigestUtils.md5DigestAsHex(original.getBytes());
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Encode("111111"));
	}
	
}
