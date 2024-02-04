package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


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

	private String noticetext;

	private String photo;

	private String subtitle;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to NoticiasFav
	@OneToMany(mappedBy="noticia")
	private List<NoticiasFav> noticiasFavs;

	public Noticia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<NoticiasFav> getNoticiasFavs() {
		return this.noticiasFavs;
	}

	public void setNoticiasFavs(List<NoticiasFav> noticiasFavs) {
		this.noticiasFavs = noticiasFavs;
	}

	public NoticiasFav addNoticiasFav(NoticiasFav noticiasFav) {
		getNoticiasFavs().add(noticiasFav);
		noticiasFav.setNoticia(this);

		return noticiasFav;
	}

	public NoticiasFav removeNoticiasFav(NoticiasFav noticiasFav) {
		getNoticiasFavs().remove(noticiasFav);
		noticiasFav.setNoticia(null);

		return noticiasFav;
	}

}