package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.Ciudad;
import co.icesi.troca.model.Departamento;
import co.icesi.troca.repositories.CiudadDao;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CiudadDAOImpl
 * @date 22/10/2013
 * 
 */
@Repository("ciudadDao")
public class CiudadDaoImpl extends GenericJpaRepository<Ciudad, Integer>
		implements CiudadDao, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.CiudadDao#findByDepto(co.icesi.troca.model.Departamento)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByDepto(Departamento departamento) {
		return this
				.getEntityManager()
				.createQuery(
						"SELECT c FROM Ciudad c WHERE  c.departamento = :departamento ORDER BY c.nombre ASC")
				.setParameter("departamento", departamento).getResultList();
	}

}
