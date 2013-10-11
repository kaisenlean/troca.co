package co.icesi.troca.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.repositories.PaisDAO;

@Repository("paisDao")
public  class PaisDAOImpl implements PaisDAO {
	
	private EntityManager em = null;

   
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findAll() {
		return this.em.createQuery( new StringBuilder("SELECT u FROM Pais u").toString()).getResultList();
	}

	@Override
	public Pais find(int id) {
		return this.em.find(Pais.class, id);
	}





}
