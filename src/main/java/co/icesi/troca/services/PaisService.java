package co.icesi.troca.services;

import java.util.List;

import javax.faces.model.SelectItem;

import co.icesi.troca.model.Pais;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class PaisService
* @date 22/10/2013
*
 */
public interface PaisService extends  GenericService<Pais, Integer>{

	/**
	 * Cargar los items de paises
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	 */
	List<SelectItem> getItmems();

}