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

import co.icesi.troca.model.proyecto.ProyectoCategoria;
import co.icesi.troca.services.proyecto.ProyectoCategoriaService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ItemsProyectoCategoria
 * @date 24/11/2013
 * 
 */
@ManagedBean
@ViewScoped
public class ItemsProyectoCategoria implements Serializable {

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         items
	 */
	private List<SelectItem> items = new ArrayList<SelectItem>();

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyectoCategoriaService
	 */
	@ManagedProperty(value = "#{proyectoCategoriaService}")
	private ProyectoCategoriaService proyectoCategoriaService;

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
	 */
	@PostConstruct
	public void init() {
		List<ProyectoCategoria> categorias = proyectoCategoriaService.findAll();
		for (ProyectoCategoria proyectoCategoria : categorias) {
			items.add(new SelectItem(proyectoCategoria.getId(),
					proyectoCategoria.getValor()));
		}
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyectoCategoriaService
	 *            the proyectoCategoriaService to set
	 */
	public void setProyectoCategoriaService(
			ProyectoCategoriaService proyectoCategoriaService) {
		this.proyectoCategoriaService = proyectoCategoriaService;
	}

}
