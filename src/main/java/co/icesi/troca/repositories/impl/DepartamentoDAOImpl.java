package co.icesi.troca.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.repositories.DepartamentoDAO;

@Repository("departamentoDao")
public  class DepartamentoDAOImpl implements DepartamentoDAO {
	
	private EntityManager em = null;

   
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByPais(Pais pais) {
		return this.em.createQuery("SELECT d FROM Departamento d WHERE d.pais = :pais").setParameter("pais", pais).getResultList();
	}

	@Override
	public Departamento find(int id) {
		return this.em.find(Departamento.class, id);
	}





}
