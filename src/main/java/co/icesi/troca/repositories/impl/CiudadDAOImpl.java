package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Ciudad;
import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.repositories.CiudadDAO;



@Repository("ciudadDao")
public  class CiudadDAOImpl extends GenericJpaRepository<Ciudad, Integer> implements CiudadDAO ,Serializable{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByDepto(Departamento departamento) {
		return this.getEntityManager().createQuery("SELECT c FROM Ciudad c WHERE  c.departamento = :departamento").setParameter("departamento", departamento).getResultList();
	}






}
