package com.jee.modele;

public class Product {

	int id;
	String title;
	String desc;
	float price;
	
	public Product(int id, String title, String desc, float price) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", desc=" + desc + ", price=" + price + "]";
	}
	
	
	
}
