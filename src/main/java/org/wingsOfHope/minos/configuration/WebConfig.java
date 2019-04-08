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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wingsOfHope.minos.utils.JWTUtil;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		InterceptorRegistration interceptorRegistration = registry.addInterceptor(new JWTHandlerInterceptor());

		List<String> excludePath = new ArrayList<>();

		excludePath.add("/error");
		excludePath.add("/static/**");
		excludePath.add("/admin/token");
		excludePath.add("/teacher/token");
		excludePath.add("/student/token");
		excludePath.add("/student/tokens");
		
		excludePath.add("/swagger-ui.html");
		excludePath.add("/webjars/springfox-swagger-ui/**");
		excludePath.add("/configuration/**");
		excludePath.add("/swagger-resources");
		excludePath.add("/v2/**");

		interceptorRegistration.excludePathPatterns(excludePath);

		interceptorRegistration.addPathPatterns("/**");
	}

//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}

	private class JWTHandlerInterceptor implements HandlerInterceptor {

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			String token = request.getHeader("Authorization");
			if (token == null || JWTUtil.parseJws(token) == null) {
				response.setStatus(401);
				return false;
			}
			return true;
		}
	}
}
