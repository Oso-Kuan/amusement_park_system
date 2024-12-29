/*<!--����jwt-->
<dependency>
<groupId>com.auth0</groupId>
<artifactId>java-jwt</artifactId>
<version>3.10.3</version>
</dependency>*/

package com.easy.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTUtil {
	private static final String SIGN = "easy"; // ��Կ
	// 1.ͨ��jwt����token�ַ�����

	public static String createToken(Map<String, Object> params) {

		Map<String, Object> head = new HashMap();
		head.put("alg", "HS256");
		head.put("typ", "JWT");

		// ����䷢ʱ��
		Date iss = new Date();
		// ����ʱ��
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.DAY_OF_YEAR, 3);
		Date expire = nowTime.getTime();

		String token = JWT.create()
				// ָ��ͷ��Ϣ
				.withHeader(head)
				// �غ��ֵĹ���ʱ��
				.withExpiresAt(expire)
				// �䷢ʱ��
				.withIssuedAt(iss)
				// �䷢��
				.withIssuer("easy")
				// �Զ�����غ�����
				.withClaim("userInfo", params)
				// ǩ��
				.sign(Algorithm.HMAC256(SIGN));

		return token;
	}

	// 2. �ж�token�Ƿ�Ϸ�
	public static boolean verifyToken(String token) {
		JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
		try {
			DecodedJWT verify = build.verify(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 3. ����token�ֵ�����
	public static Map<String, Object> decodeJWT(String token) {
		Map<String, Object> userInfo = JWT.decode(token).getClaim("userInfo").asMap();
		return userInfo;
	}

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap();
		map.put("name", "zhangsan");
		map.put("id", 1);
		map.put("age", 19);
		String token = createToken(map);
		System.out.println(token);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean bool = verifyToken(token);
		System.out.println(bool);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> map2 = decodeJWT(token);
		System.out.println(map2);

	}
}
