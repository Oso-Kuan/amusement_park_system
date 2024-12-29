package com.easy.excel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

public class EasyObjExcelListener<E> implements ReadListener<E> {
	public List<E> list = new ArrayList();

	// ��ȡ��ÿһ�����󶼻����invoke����
	public void invoke(E data, AnalysisContext context) {
		System.out.println(data);
		list.add(data);
	}

	public void doAfterAllAnalysed(AnalysisContext context) {
		System.out.println("------��ȡ���");
	}

	public static void main(String[] args) {
		EasyExcel.read("D:\\Eclipse\\Project_first\\youle.xlsx", EasyObject.class, new EasyObjExcelListener()).sheet(0)
				.doRead();
	}
}
