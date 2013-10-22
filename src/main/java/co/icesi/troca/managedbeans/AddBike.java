/**
 * 
 */
package co.icesi.troca.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;

@ManagedBean(name = "addBike")
@SessionScoped
public class AddBike implements Serializable {

	private static final long serialVersionUID = -2155913853431899821L;

	// @ManagedProperty("#{bikeDataProvider}")
	// private BikeDataProvider bikeDataProvider; // injected Spring defined
	// service for bikes
	//

	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService; // injected Spring defined service
											// for bikes

	private List<Usuario> lista;

	@PostConstruct
	public void init() {
		setLista(usuarioService.findAll());

	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

}
