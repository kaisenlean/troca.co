/**
 * 
 */
package co.icesi.troca.views.component.autocomplete.usuario;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.primefaces.event.SelectEvent;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.views.component.autocomplete.Autocompletar;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class AutocompleteUsuario
 * @date 27/11/2013
 * 
 */
public abstract class AutocompleteUsuario extends Autocompletar<Usuario> {
	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.icesi.troca.views.component.autocomplete.Autocompletar#completarBusqueda
	 * (java.lang.String)
	 */
	@Override
	public List<Usuario> completarBusqueda(String query) {
		return getService().findUsuariosByParam(query);
	}

	public abstract UsuarioService getService();

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 3/06/2013
	 * @param valor
	 * @return
	 */
	private String obtenerId(String valor) {

		String id = "";
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(valor);
		while (m.find()) {
			id += m.group();
		}

		return id;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 */
	public void postSeleccionado() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.icesi.troca.views.component.autocomplete.Autocompletar#seleccionar
	 * (org.primefaces.event.SelectEvent)
	 */
	@Override
	public void seleccionar(SelectEvent evt) {
		seleccionado = getService().findById(
				Integer.valueOf(obtenerId(evt.getObject().toString())));
		postSeleccionado();
	}
}
