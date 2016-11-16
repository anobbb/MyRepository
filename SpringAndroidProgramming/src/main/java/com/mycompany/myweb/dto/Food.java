package com.mycompany.myweb.dto;

public class Food {
	private String image;
	private String imageLarge;
	private String title;
	private String price;
	private String content;
	
	public Food() {}

	public Food(String image, String imageLarge, String title, String price, String content) {
		super();
		this.image = image;
		this.imageLarge = imageLarge;
		this.title = title;
		this.price = price;
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageLarge() {
		return imageLarge;
	}

	public void setImageLarge(String imageLarge) {
		this.imageLarge = imageLarge;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
