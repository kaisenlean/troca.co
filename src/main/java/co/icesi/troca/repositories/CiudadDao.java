package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.Ciudad;
import co.icesi.troca.model.Departamento;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class CiudadDAO
 * @date 22/10/2013
 * 
 */
public interface CiudadDao extends GenericRepository<Ciudad, Integer> {

	/**
	 * Método que consulta las ciudades de un departamento determinado
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 * @param departamento
	 * @return
	 */
	List<Ciudad> findByDepto(Departamento departamento);
}
