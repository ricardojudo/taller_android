package com.example.musicplayer.model;

public class Tune {
	private String minutes;
	private Integer image;
	private float rating;
	

	public Tune(String minutes, Integer image) {
		this.minutes = minutes;
		this.image = image;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public Integer getImage() {
		return image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
