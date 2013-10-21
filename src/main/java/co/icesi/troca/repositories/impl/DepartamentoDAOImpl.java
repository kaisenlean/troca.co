package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.repositories.DepartamentoDAO;

@Repository("departamentoDao")
public  class DepartamentoDAOImpl extends GenericJpaRepository<Departamento, Integer> implements DepartamentoDAO ,Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByPais(Pais pais) {
		return this.getEntityManager().createQuery("SELECT d FROM Departamento d WHERE d.pais = :pais").setParameter("pais", pais).getResultList();
	}

	





}
