package co.icesi.troca.services;

import java.util.List;

import javax.faces.model.SelectItem;

import co.icesi.troca.model.Ciudad;
import co.icesi.troca.model.Departamento;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class CiudadService
* @date 22/10/2013
*
 */
public interface CiudadService extends GenericService<Ciudad, Integer> {
	/**
	 * Carga selectitems de ciudades por determinado departamento
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param departamento
	* @return
	 */
	List<SelectItem> getItmemsByDepto(Departamento departamento);

}