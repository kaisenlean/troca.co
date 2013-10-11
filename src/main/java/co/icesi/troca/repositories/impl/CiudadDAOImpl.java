package co.icesi.troca.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Ciudad;
import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.repositories.CiudadDAO;

@Repository("ciudadDao")
public  class CiudadDAOImpl implements CiudadDAO {
	
	private EntityManager em = null;

   
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByDepto(Departamento departamento) {
		return this.em.createQuery("SELECT c FROM Ciudad c WHERE  c.departamento = :departamento").setParameter("departamento", departamento).getResultList();
	}

	@Override
	public Ciudad find(int id) {
		return this.em.find(Ciudad.class, id);
	}





}
