package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.Departamento;
import co.icesi.troca.model.Pais;
import co.icesi.troca.repositories.DepartamentoDao;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class DepartamentoDAOImpl
* @date 22/10/2013
*
 */
@Repository("departamentoDao")
public class DepartamentoDaoImpl extends
		GenericJpaRepository<Departamento, Integer> implements DepartamentoDao,
		Serializable {

	
	private static final long serialVersionUID = 1L;
/**
 * (non-Javadoc)
 * @see co.icesi.troca.repositories.DepartamentoDao#findByPais(co.icesi.troca.model.Pais)
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByPais(Pais pais) {
		return this
				.getEntityManager()
				.createQuery(
						"SELECT d FROM Departamento d WHERE d.pais = :pais")
				.setParameter("pais", pais).getResultList();
	}

}
