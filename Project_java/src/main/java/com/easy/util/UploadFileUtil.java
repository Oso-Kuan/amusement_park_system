package com.easy.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.easy.config.EasyConfig;

public class UploadFileUtil {
	private static final String UPLOAD_DRI = "D:\\Eclipse\\Project_first\\img\\";
	static {
		File file = new File(EasyConfig.STATIC_DIR);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static String uploadfile(MultipartFile file) {
		// ����һ���µ��ļ���
		String fileName = file.getOriginalFilename();// ��ȡ�ϴ��ļ���ԭ�ļ���
		String lastName = fileName.substring(fileName.lastIndexOf("."));// ��ȡ�ļ���׺��
		String newName = UUID.randomUUID() + lastName;
		// ��file�ļ����浽UPLOAD_DRI·����
		File newFile = new File(EasyConfig.STATIC_DIR + newName);// D:\\Eclipse\\Project_first\\img\\XXX.jpg
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// �����ļ�·���Լ��ļ���
		return newName;
	}
}
