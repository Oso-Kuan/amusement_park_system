package com.easy.controller;

import com.easy.bean.User;
import com.easy.common.CommonResult;
import com.easy.config.EasyConfig;
import com.easy.config.EasyWebConfig;
import com.easy.dao.IUserDao;
import com.easy.service.IUserService;
import com.easy.util.Page;
import com.easy.util.UploadFileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserDao userDao;

	@GetMapping("userA")
	public CommonResult getUser(User user, Page page) {
		List<User> list = userService.getUser(user, page);
		int count = userService.getCount(user);
		HashMap map = new HashMap();
		map.put("list", list);
		map.put("count", count);
		return CommonResult.success(map);
	}

	@PostMapping("userjson")
	public CommonResult addUser(@RequestBody User user) {
		userService.addUser(user);
		return CommonResult.success(user);
	}

	@DeleteMapping("user/{id}")
	public CommonResult delUser(@PathVariable int id) {
		int count = userService.delUser(id);
		if (count > 0) {
			return CommonResult.success();
		} else {
			return CommonResult.fail();
		}
	}

	@PutMapping("userjson")
	public CommonResult editUser(@RequestBody User user) {
		int count = userService.editUser(user);
		return CommonResult.success(user);
	}

	@PostMapping("userimg")
	public CommonResult uploadImg(@RequestParam("file") MultipartFile file) {
		// 存储文件
		String newName = UploadFileUtil.uploadfile(file);
		// 将文件地址存入数据库
		// 返回上传文件的地址 or 返回上传图片的设施数据
		return CommonResult.success(EasyWebConfig.IMAGE_PATH + newName);
	}

	@PutMapping("userimg")
	public CommonResult userImg(User user) {
		userService.userImg(user);
		System.out.println(user.getId());
		System.out.println(user.getImg());
		return CommonResult.success(user);
	}

}
