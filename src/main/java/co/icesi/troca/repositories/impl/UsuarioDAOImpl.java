package co.icesi.troca.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Usuario;
import co.icesi.troca.repositories.UsuarioDAO;

@Repository("usuarioDao")
public class UsuarioDAOImpl implements UsuarioDAO {
	
	private EntityManager em = null;

   
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return this.em.createQuery( new StringBuilder("SELECT u FROM Usuario u").toString()).getResultList();
	}

	@Override
	public void create(Usuario u) {
	this.em.persist(u);
	
		
	}



}
