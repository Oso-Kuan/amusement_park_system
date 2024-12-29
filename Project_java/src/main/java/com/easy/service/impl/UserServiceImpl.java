package com.easy.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.easy.bean.User;
import com.easy.common.CommonResult;
import com.easy.dao.IUserDao;
import com.easy.service.IUserService;
import com.easy.util.JWTUtil;
import com.easy.util.Page;

@Service
public class UserServiceImpl implements IUserService {
	private final static int countIndex = 8;
	private final static int saltIndex = 2;
	private final static char[] items = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };
	@Autowired
	private IUserDao dao;

	public int getCount(User user) {
		return dao.getCount(user);
	}

	public List<User> getUser(User user, Page page) {
		return dao.getUser(user, page);
	}

	public User getUserByID(int id) {
		return dao.getUserByID(id);
	}

	public int addUser(User user) {
		String ranPass = randomDigest(user.getUserpass());
		user.setUserpass(ranPass);
		String setPass = user.getUserpass();
		return dao.addUser(user);
	}

	public int addList(List<User> user) {
		for (User user1 : user) {
			user1.setUserpass(randomDigest(user1.getUserpass()));
		}
		return dao.addList(user);
	}

	public int delUser(int id) {
		return dao.delUser(id);
	}

	public int editUser(User user) {
		if (user.getUserpass() != null && !user.getUserpass().isEmpty()) {
			user.setUserpass(randomDigest(user.getUserpass()));
		}
		return dao.editUser(user);
	}

	public int editUserItem(User user) {
		if (user.getUserpass() != null && !user.getUserpass().isEmpty()) {
			user.setUserpass(randomDigest(user.getUserpass()));
		}
		return dao.editUserItem(user);
	}

	public int edit(int id, User user) {
		if (user.getUserpass() != null && !user.getUserpass().isEmpty()) {
			user.setUserpass(randomDigest(user.getUserpass()));
		}
		return dao.edit(id, user);
	}

	public static String randomDigest(String pass) {
		int randomCountIndex = (int) (Math.random() * items.length);
		int randomSaltIndex = (int) (Math.random() * items.length);
		char count = items[randomCountIndex];
		System.out.println(count);
		char salt = items[randomSaltIndex];
		System.out.println(salt);
		String result = pass + salt;
		for (int i = 0; i < count; i++) {
			// 加密
			result = DigestUtils.md5Hex(result);
		}
		System.out.println(result);
		// result就是加密之后的字符串
		result = result.substring(0, saltIndex) + salt + result.substring(saltIndex);
		result = result.substring(0, countIndex) + count + result.substring(countIndex);
		System.out.println(result);
		return result;
	}

	private static boolean eqPassword(String password, String password_data) {
		System.out.println("++++++++++++++++pasword:" + password);
		System.out.println("++++++++++++++++pasword_data:" + password_data);
		// 确保 saltIndex 和 countIndex 是有效的
		if (saltIndex >= password_data.length() || countIndex >= password_data.length()) {
			throw new IllegalArgumentException("Indices are out of bounds.");
		}

		// 提取盐值和计数
		char salt = password_data.charAt(saltIndex);
		System.out.println("====================salt:" + salt);
		char countChar = password_data.charAt(countIndex);
		System.out.println("====================count:" + countChar);

		// 开始加密
		String result = password + salt;
		System.out.println("password+salt:" + result);
		for (int i = 0; i < countChar; i++) {
			result = DigestUtils.md5Hex(result);
		}
		System.out.println("------------------原文未加salt和count的密文：" + result);
		// 恢复盐值和计数
		result = result.substring(0, saltIndex) + salt + result.substring(saltIndex);
		System.out.println("------------------原文未加count的密文：" + result);
		result = result.substring(0, countIndex) + countChar + result.substring(countIndex);
		System.out.println("++++++++++++++++++++++++++++原文加密：" + result);
		return result.equals(password_data);
	}

	public String doLogin(User user) {
		// 1.获取数据库中的数据 byname
		List<User> list = dao.getUserByUsername(user.getUsername());
		if (list.size() == 1) {
			User user_data = list.get(0);
			// 2.比较密码
			boolean bool = eqPassword(user.getUserpass(), user_data.getUserpass());
			System.out.println(bool);
			if (bool) {
				// 3.生成token
				return JWTUtil.createToken(null);
			}
		}
		return null;
	}
	/*
	 * private boolean eqPasswordAAAAAA(String pass, String userpass) { return
	 * pass.equals(userpass); }
	 */

	public int userImg(User user) {
		return dao.userImg(user);
	}

	/*
	 * public static void main(String[] args) { //md5加密，可以多次加密 //随即次数加密 //盐值加密
	 * String passA="123"; String digestPass=DigestUtils.md5Hex(passA);
	 * System.out.println(digestPass); String passB="123";
	 * digestPass=DigestUtils.md5Hex(passB); String passC="123"+"a"; for(int
	 * i=0;i<20; i++) { passC=DigestUtils.md5Hex(passC); }
	 * System.out.println(passC); }
	 */
}
