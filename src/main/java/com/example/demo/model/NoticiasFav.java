package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the noticias_favs database table.
 * 
 */
@Entity
@Table(name="noticias_favs")
@NamedQuery(name="NoticiasFav.findAll", query="SELECT n FROM NoticiasFav n")
public class NoticiasFav implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Noticia
	@ManyToOne
	@JoinColumn(name="id_noticia")
	private Noticia noticia;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public NoticiasFav() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Noticia getNoticia() {
		return this.noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}