/**  

* 创建时间：2019年4月7日 下午6:37:32  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：JWTUtil.java  

* 类说明：  

*/

package org.wingsOfHope.minos.utils;

import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	private static final long TOKEN_EXP = 1000 * 60 * 60 * 3;
	
	private static final String SECRET_KEY = "suibianquge";
	
	/**
	 * 传入用户唯一标识id
	 * 
	 * @param uid
	 * @return String
	 * 
	 */
	public static String getJws(Integer uid) {
		String uuid = UUID.randomUUID().toString() + uid.toString();
		JwtBuilder jwtBuilder = Jwts.builder()
				.setId(uuid)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(uid.toString())
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP));
		return jwtBuilder.compact();
	}
	/**
	 * 根据jws解析出用户的唯一标识
	 * 
	 * @param jws
	 * @return Integer
	 * 
	 */
	public static Integer parseJws(String jws) {
		return Integer.parseInt(Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jws).getBody().getSubject());
	}
	
//	public static void main(String[] args) {
//		System.out.println(getJws(1));
//		System.out.println(getJws(1));
//		System.out.println(getJws(1));
//	}
	
}
