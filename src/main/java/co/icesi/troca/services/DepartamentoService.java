package co.icesi.troca.services;

import java.util.List;

import javax.faces.model.SelectItem;

import co.icesi.troca.model.Departamento;
import co.icesi.troca.model.Pais;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class DepartamentoService
* @date 22/10/2013
*
 */
public interface DepartamentoService  extends GenericService<Departamento, Integer>{

	/**
	 * Cargar SelectItems de departamentos por un pais determinado
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param pais
	* @return
	 */
	List<SelectItem> getItmemsByPais(Pais pais);

}