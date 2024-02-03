package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DatosAltaUsuario;
import com.example.demo.model.Noticia;
import com.example.demo.model.NoticiaDto;
import com.example.demo.repositories.NoticiaRepositorio;
import com.example.demo.repositories.UserRepositorio;
import com.example.demo.security.JwtTokenProvider;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;

import com.example.demo.model.User;


@CrossOrigin
@RestController
@RequestMapping("/noticias")
public class NoticiaController {
	@Autowired
	NoticiaRepositorio notRep;
	@Autowired
	UserRepositorio usRep;
	@GetMapping("todas")
	public List<DTO> listarTodos() {
		List<Noticia> ln = new ArrayList<Noticia>();
		ln = notRep.findAll();
		List<DTO> jsonList = new ArrayList<DTO>();
		if (ln != null) {
			for (Noticia n : ln) {
				DTO json = new DTO();
				json.put("title", n.getTitle());
				json.put("subtitle", n.getSubtitle());
				json.put("noticetext", n.getNoticetext());
				json.put("photo", n.getPhoto());
				json.put("id", n.getId());
				//json.put("idUser", ((User) n.getUser()).getId());
				jsonList.add(json);
			}
		}

		return jsonList;
	}
	
	@CrossOrigin
	@PostMapping(path = "insertar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public NoticiaDto insertarNoticia(@RequestBody NoticiaDto noticia, HttpServletRequest request) {
		
		JwtTokenProvider jtw = new JwtTokenProvider();
		Noticia n = new Noticia();
		int idUser = usRep.findByUsername(jtw.getEmailFromToken(request.getHeader("Authorization").substring("Bearer ".length()))).get().getId();
		System.out.println(idUser);
		n.setIdUser(idUser);
		n.setNoticetext(noticia.getNoticetext());
		n.setPhoto(noticia.getPhoto());
		n.setTitle(noticia.getTitle());
		n.setSubtitle(noticia.getSubtitle());
		System.out.println("hola");
		n = notRep.save(n);
		if (n != null) {
			return new NoticiaDto(n.getTitle(), n.getSubtitle(), n.getNoticetext(), n.getPhoto());

		} else {
			return new NoticiaDto("Noticia no introducida correctamente", null, null, null);
		}
	}
	
	@CrossOrigin
	@PostMapping(path = "misnoticias")
	public List<DTO> listarMisNoticias(HttpServletRequest request) {
		List<Noticia> ln = new ArrayList<Noticia>();
		JwtTokenProvider jtw = new JwtTokenProvider();
		int idUser = usRep.findByUsername(jtw.getEmailFromToken(request.getHeader("Authorization").substring("Bearer ".length()))).get().getId();
		ln = notRep.findByIdUser(idUser);
		List<DTO> jsonList = new ArrayList<DTO>();
		if (ln != null) {
			for (Noticia n : ln) {
				DTO json = new DTO();
				json.put("title", n.getTitle());
				json.put("subtitle", n.getSubtitle());
				json.put("noticetext", n.getNoticetext());
				json.put("photo", n.getPhoto());
				json.put("id", n.getId());
				jsonList.add(json);
			}
		} else {
			return null;
		}
		return jsonList;	
	}
	
	@CrossOrigin
	@PostMapping(path = "editar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public NoticiaDto editarNoticia(@RequestBody NoticiaDto noticia, HttpServletRequest request) {
		
		JwtTokenProvider jtw = new JwtTokenProvider();
		Noticia n = new Noticia();
		int idUser = usRep.findByUsername(jtw.getEmailFromToken(request.getHeader("Authorization").substring("Bearer ".length()))).get().getId();
		System.out.println(idUser);
		n.setIdUser(idUser);
		n.setNoticetext(noticia.getNoticetext());
		n.setPhoto(noticia.getPhoto());
		n.setTitle(noticia.getTitle());
		n.setSubtitle(noticia.getSubtitle());
		n.setId(noticia.getId());
		System.out.println("hola");
		n = notRep.save(n);
		if (n != null) {
			return new NoticiaDto(n.getTitle(), n.getSubtitle(), n.getNoticetext(), n.getPhoto());

		} else {
			return new NoticiaDto("Noticia no introducida correctamente", null, null, null);
		}
	}
	
	@CrossOrigin
	@PostMapping(path = "eliminar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarNoticia(@RequestBody NoticiaDto noticia, HttpServletRequest request) {
		Noticia n = new Noticia();
		n.setId(noticia.getId());
		notRep.deleteById(n.getId());
	}

}
