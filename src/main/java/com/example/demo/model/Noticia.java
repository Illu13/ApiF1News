package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idUser;

	private String noticetext;

	private String photo;

	private String subtitle;

	private String title;

	public Noticia() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNoticetext() {
		return this.noticetext;
	}

	public void setNoticetext(String noticetext) {
		this.noticetext = noticetext;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String string) {
		this.photo = string;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}