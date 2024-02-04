package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String name;

	private String password;

	private String token;

	private String username;

	//bi-directional many-to-one association to Noticia
	@OneToMany(mappedBy="user")
	private List<Noticia> noticias;

	//bi-directional many-to-one association to NoticiasFav
	@OneToMany(mappedBy="user")
	private List<NoticiasFav> noticiasFavs;

	public User() {
	}
	public User(String name2, String username2, String password2, String email2) {
        this.name = name2;
        this.username = username2;
        this.password = password2;
        this.email = email2;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setUser(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setUser(null);

		return noticia;
	}

	public List<NoticiasFav> getNoticiasFavs() {
		return this.noticiasFavs;
	}

	public void setNoticiasFavs(List<NoticiasFav> noticiasFavs) {
		this.noticiasFavs = noticiasFavs;
	}

	public NoticiasFav addNoticiasFav(NoticiasFav noticiasFav) {
		getNoticiasFavs().add(noticiasFav);
		noticiasFav.setUser(this);

		return noticiasFav;
	}

	public NoticiasFav removeNoticiasFav(NoticiasFav noticiasFav) {
		getNoticiasFavs().remove(noticiasFav);
		noticiasFav.setUser(null);

		return noticiasFav;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}