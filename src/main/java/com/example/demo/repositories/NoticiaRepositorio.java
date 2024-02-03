package com.example.demo.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Noticia;

import jakarta.transaction.Transactional;


public interface NoticiaRepositorio extends JpaRepository<Noticia, Serializable> {

	public abstract List<Noticia> findAll();
	public abstract List<Noticia> findByIdUser(int idUser);
	public abstract Noticia findByTitle(String title);
	
	@Transactional
	public abstract Noticia save(Noticia noticia);
	@Transactional
	public abstract void deleteById(int id);
}
