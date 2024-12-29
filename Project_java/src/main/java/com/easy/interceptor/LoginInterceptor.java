package com.easy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.easy.common.CommonResult;
import com.easy.util.JWTUtil;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 在处理handler之前执行，返回true，可以执行对应的handler，反之不行。
		// return true/false是springmvc中的运行路线需求，不是回应浏览器的
		// 验证每个请求是否是登录状态
		// 怎么样就是登录状态，有token，token有效
		// token在哪？在handler中叫做Authorization
		String token = request.getHeader("Authorization");
		if (token != null && JWTUtil.verifyToken(token)) {
			// token有效，有登录状态
			return true;
		} else {
			// 要回应的数据
			CommonResult result = CommonResult.fail(400, "未登录啊");
			// 将数据解析成json
			String json = JSON.toJSONString(result);
			// 将数据回应回去
			response.getWriter().write(json);
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
