package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.troca.Usuario;
import co.icesi.troca.repositories.UsuarioDAO;
import co.icesi.troca.services.UsuarioService;

/* 
 * Spring defined service for performing all operations on bikes:
 * - loading all bikes from given category
 * - loading selected bike details
 * - adding new bike 
 */

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService ,Serializable{

	private static final long serialVersionUID = -7342021171479215673L;
	@Resource(name="usuarioDao")
	private UsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> findAll() {
		return usuarioDAO.findAll();
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public void create(Usuario u) {
		usuarioDAO.save(u);
		
	}
	
}
