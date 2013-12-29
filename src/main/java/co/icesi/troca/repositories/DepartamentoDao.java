package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.Departamento;
import co.icesi.troca.model.Pais;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class DepartamentoDAO
 * @date 22/10/2013
 * 
 */
public interface DepartamentoDao extends
		GenericRepository<Departamento, Integer> {
	/**
	 * Método que consulta los departamentos de un determinado pais
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 * @param pais
	 * @return
	 */
	List<Departamento> findByPais(Pais pais);
}
