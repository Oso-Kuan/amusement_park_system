package com.easy.bean;

public class AmusementFacility {
	private int id;
	private String name;
	private String status;
	private String img;
	private AmusementType amusementtype;
	private int amusementtypeid;

	public int getAmusementtypeid() {
		return amusementtypeid;
	}

	public void setAmusementtypeid(int amusementtypeid) {
		this.amusementtypeid = amusementtypeid;
	}

	public AmusementType getAmusementtype() {
		return amusementtype;
	}

	public void setAmusementtype(AmusementType amusementtype) {
		this.amusementtype = amusementtype;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
