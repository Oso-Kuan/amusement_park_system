package com.easy.excel;

/*
 * ������Ŵӱ��ж�ȡ������
 * */
public class EasyObject {
	private int id;
	private String position;
	private double salary;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EasyObject [id=" + id + ", position=" + position + ", salary=" + salary + ", name=" + name + "]";
	}

}
