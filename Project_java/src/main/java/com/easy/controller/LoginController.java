package com.easy.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bean.User;
import com.easy.common.CommonResult;
import com.easy.service.IUserService;
import com.easy.util.JWTUtil;

@Controller
@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	IUserService userS;

	@PostMapping("dologin")
	public CommonResult doLogin(User user) {
		String token = userS.doLogin(user);
		if (token == null) {
			return CommonResult.fail(403, "µÇÂ½Ê§°Ü");
		} else {
			return CommonResult.success(200, "µÇÂ¼³É¹¦", token);
		}
	}

	@GetMapping("checktoken")
	public CommonResult checkToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null && JWTUtil.verifyToken(token)) {
			return CommonResult.success();
		}
		return CommonResult.fail();
	}
}
