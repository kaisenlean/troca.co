package co.icesi.troca.services;

import java.util.List;

import co.icesi.troca.model.troca.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();
	void create(Usuario u);

}