/**
 * 
 */
package co.icesi.troca.views.component.autocomplete;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.SelectEvent;

import co.icesi.troca.commons.BaseBean;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project co.com.rentavoz.consola
 * @class Autocompletar
 * @date 29/07/2013
 * 
 */
public abstract class Autocompletar<T> extends BaseBean implements
		Autocompletable<T>, Serializable {

	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected T seleccionado;
	private String query;
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(Autocompletar.class);

	/**
	 * 
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/07/2013
	 * @param query
	 * @return
	 */
	@Override
	public abstract List<T> completarBusqueda(String query);

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/12/2013
	 * @return the logger
	 */
	public org.apache.log4j.Logger getLogger() {
		return logger;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/09/2013
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/07/2013
	 * @return the seleccionado
	 */
	public T getSeleccionado() {
		return seleccionado;
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/07/2013
	 * @param evt
	 */
	public abstract void seleccionar(SelectEvent evt);

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 23/12/2013
	 * @param logger
	 *            the logger to set
	 */
	public void setLogger(org.apache.log4j.Logger logger) {
		this.logger = logger;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/09/2013
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/07/2013
	 * @param seleccionado
	 *            the seleccionado to set
	 */
	public void setSeleccionado(T seleccionado) {
		this.seleccionado = seleccionado;
	}

}
