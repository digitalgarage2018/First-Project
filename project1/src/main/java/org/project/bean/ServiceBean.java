package org.project.bean;

public class ServiceBean {
	private String sr_name;
	private String sr_type;
	private String sr_description;
	private int    sr_price;
	private int    sr_time;
	private String sr_wellness_center;
	private int    sr_serviceID;
	private String sr_image;
	/*
	public ServiceBean(String name, String type, String description,int price, String center,int  id) {
		this.sr_name		    = name;
		this.sr_type		    = type;
		this.sr_description     = description;
		this.sr_price		    = price;
		this.sr_wellness_center = center;
		this.sr_serviceID		= id;
		
	}
	*/
	public String getSr_name() {
		return sr_name;
	}

	public void setSr_name(String sr_name) {
		this.sr_name = sr_name;
	}

	public String getSr_type() {
		return sr_type;
	}

	public void setSr_type(String sr_type) {
		this.sr_type = sr_type;
	}

	public String getSr_description() {
		return sr_description;
	}

	public void setSr_description(String sr_description) {
		this.sr_description = sr_description;
	}

	public int getSr_price() {
		return sr_price;
	}

	public void setSr_price(int sr_price) {
		this.sr_price = sr_price;
	}

	public String getSr_wellness_center() {
		return sr_wellness_center;
	}

	public void setSr_wellness_center(String sr_wellness_center) {
		this.sr_wellness_center = sr_wellness_center;
	}

	public int getSr_serviceID() {
		return sr_serviceID;
	}

	public void setSr_serviceID(int sr_serviceID) {
		this.sr_serviceID = sr_serviceID;
	}

	public String getSr_image() {
		return sr_image;
	}

	public void setSr_image(String sr_image) {
		this.sr_image = sr_image;
	}

	public int getSr_time() {
		return sr_time;
	}

	public void setSr_time(int sr_time) {
		this.sr_time = sr_time;
	}
	
}
