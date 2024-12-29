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
		// �ڴ���handler֮ǰִ�У�����true������ִ�ж�Ӧ��handler����֮���С�
		// return true/false��springmvc�е�����·�����󣬲��ǻ�Ӧ�������
		// ��֤ÿ�������Ƿ��ǵ�¼״̬
		// ��ô�����ǵ�¼״̬����token��token��Ч
		// token���ģ���handler�н���Authorization
		String token = request.getHeader("Authorization");
		if (token != null && JWTUtil.verifyToken(token)) {
			// token��Ч���е�¼״̬
			return true;
		} else {
			// Ҫ��Ӧ������
			CommonResult result = CommonResult.fail(400, "δ��¼��");
			// �����ݽ�����json
			String json = JSON.toJSONString(result);
			// �����ݻ�Ӧ��ȥ
			response.getWriter().write(json);
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO �Զ����ɵķ������
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO �Զ����ɵķ������
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
