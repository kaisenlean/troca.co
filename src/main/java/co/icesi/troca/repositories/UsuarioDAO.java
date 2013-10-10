package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.troca.Usuario;

public interface UsuarioDAO {

	List<Usuario> findAll();
}
