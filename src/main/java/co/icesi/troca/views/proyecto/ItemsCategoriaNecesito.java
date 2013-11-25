/**
 * 
 */
package co.icesi.troca.views.proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import co.icesi.troca.model.necesito.CategoriaNecesito;
import co.icesi.troca.services.necesito.CategoriaNecesitoService;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class ItemsCategoriaNecesito
* @date 24/11/2013
*
 */
@ManagedBean
@ViewScoped
public class ItemsCategoriaNecesito implements Serializable {

	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * items
	 */
	private List<SelectItem> items= new ArrayList<SelectItem>();
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoriaNecesitoService
	 */
	@ManagedProperty(value="#{categoriaNecesitoService}")
	private CategoriaNecesitoService categoriaNecesitoService;
	
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 24/11/2013
	*/
	@PostConstruct
	public void init(){
		List<CategoriaNecesito> categorias=categoriaNecesitoService.findAll();
		for (CategoriaNecesito cn : categorias) {
		items.add(new SelectItem(cn.getId(),cn.getValor()));
		}
	}
	
	
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the items
	 */
	public List<SelectItem> getItems() {
		return items;
	}
	
	
/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 24/11/2013
 * @param categoriaNecesitoService the categoriaNecesitoService to set
 */
public void setCategoriaNecesitoService(
		CategoriaNecesitoService categoriaNecesitoService) {
	this.categoriaNecesitoService = categoriaNecesitoService;
}

}
