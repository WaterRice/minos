/**  

* 创建时间：2019年4月14日 下午3:17:07  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：CookieUtils.java  

* 类说明：  

*/

package org.wingsOfHope.minos.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static void writeCookie(HttpServletResponse response, String cookieName, String value) {
		Cookie cookie = new Cookie(cookieName, value);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
	}

}
