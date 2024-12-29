package com.easy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bean.LoginRequest;
import com.easy.common.CommonResult;
import com.easy.util.DigestUtil;

@RestController
@RequestMapping
public class LoginRequestController {
	@PostMapping("/login")
	public CommonResult Login(@RequestBody LoginRequest request) {
		boolean isValid = DigestUtil.decode(request.getPass(), request.getDigestPass());
		if (isValid) {
			return CommonResult.success("µÇÂ½³É¹¦");
		} else {
			return CommonResult.fail();
		}
	}
}
