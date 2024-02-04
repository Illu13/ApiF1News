package com.example.demo.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Noticia;
import com.example.demo.model.NoticiasFav;
import com.example.demo.model.User;

import jakarta.transaction.Transactional;

public interface NoticiasFavRepositorio extends JpaRepository<NoticiasFav, Serializable> {
	
	public abstract List<NoticiasFav> findByUser(User user);
	@Transactional
	public abstract NoticiasFav save(NoticiasFav fav);
	

}
