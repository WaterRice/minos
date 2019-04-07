/**  

* 创建时间：2019年4月7日 下午8:07:58  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：WebConfig.java  

* 类说明：  

*/

package org.wingsOfHope.minos.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wingsOfHope.minos.utils.JWTUtil;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(new JWTHandlerInterceptor());
		
		interceptorRegistration.excludePathPatterns("/error");
		interceptorRegistration.excludePathPatterns("/static/**");
		interceptorRegistration.excludePathPatterns("/admin/token");
		
		interceptorRegistration.addPathPatterns("/**");
	}
	
	private class JWTHandlerInterceptor implements HandlerInterceptor {
		
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			String token = request.getHeader("Authorization");
			if(token == null || JWTUtil.parseJws(token) == null) {
				response.setStatus(401);
				return false;
			}
			return true;
		}
	}
}
