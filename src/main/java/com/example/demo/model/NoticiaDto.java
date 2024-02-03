package com.example.demo.model;

public class NoticiaDto {
	
	int id;
	String title;
	String subtitle;
	String noticetext;
	String photo;
	String nombreUser;

	public NoticiaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticiaDto(String title, String subtitle, String noticetext, String photo, String nombreUser) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.noticetext = noticetext;
		this.photo = photo;
		this.nombreUser = nombreUser;
	}

	public NoticiaDto(String title2, String subtitle2, String noticetext2, String photo2) {
		super();
		this.title = title2;
		this.subtitle = subtitle2;
		this.noticetext = noticetext2;
		this.photo = photo2;
	}
	public NoticiaDto(String title2, String subtitle2, String noticetext2, String photo2, int id) {
		super();
		this.title = title2;
		this.subtitle = subtitle2;
		this.noticetext = noticetext2;
		this.photo = photo2;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getNoticetext() {
		return noticetext;
	}

	public void setNoticetext(String noticetext) {
		this.noticetext = noticetext;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNombreUser() {
		return nombreUser;
	}

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
