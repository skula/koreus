package com.skula.koreus.models;
public class Video {
	private String url;
	private String title;
	private String pic;

	public Video() {
	}

	public Video(String url, String title, String pic) {
		this.url = url;
		this.title = title;
		this.pic = pic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Video [url=" + url + ", title=" + title + ", pic=" + pic +"]";
	}
}
