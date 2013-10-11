package co.icesi.troca.views.registro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.model.troca.Usuario;
import co.icesi.troca.services.CiudadService;
import co.icesi.troca.services.DepartamentoService;
import co.icesi.troca.services.PaisService;
import co.icesi.troca.services.UsuarioService;

@ManagedBean
@SessionScoped
public class BeanRegistro implements Serializable {

	private static final long serialVersionUID = -1562983451567645385L;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{paisService}")
	private PaisService paisService;

	@ManagedProperty(value = "#{departamentoService}")
	private DepartamentoService departamentoService;

	@ManagedProperty(value = "#{ciudadService}")
	private CiudadService ciudadService;

	private Usuario usuario;
	private List<SelectItem> itemPaises;
	private List<SelectItem> itemDeptos;
	private List<SelectItem> itemCiudades;
	private int selPais;
	private int selDepto;
	private int selCiudad;
	protected Pais pais;
	protected Departamento departamento;

	@PostConstruct
	public void init() {

		usuario = new Usuario();
		itemPaises = paisService.getItmems();
	}

	public void cambioPais() {
		cargarPais();

	}

	public void cambioDepto() {
		cargarCiudad();

	}

	public void cambioCiudad() {
	seleccionarCiudad();

	}
	private void seleccionarCiudad() {
		usuario.setCiudad(ciudadService.find(selCiudad));
	}

	private void cargarCiudad() {
	departamento=departamentoService.find(selDepto);
	itemCiudades=ciudadService.getItmemsByDepto(departamento);
		
	}

	private void cargarPais() {
		pais = paisService.find(selPais);
		itemDeptos = departamentoService.getItmemsByPais(pais);

	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}

	public List<SelectItem> getItemPaises() {
		return itemPaises;
	}

	public void setItemPaises(List<SelectItem> itemPaises) {
		this.itemPaises = itemPaises;
	}

	public int getSelPais() {
		return selPais;
	}

	public void setSelPais(int selPais) {
		this.selPais = selPais;
	}

	public List<SelectItem> getItemDeptos() {
		return itemDeptos;
	}

	public void setItemDeptos(List<SelectItem> itemDeptos) {
		this.itemDeptos = itemDeptos;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	public void setCiudadService(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}
	public void setSelCiudad(int selCiudad) {
		this.selCiudad = selCiudad;
	}
	public void setSelDepto(int selDepto) {
		this.selDepto = selDepto;
	}
	public int getSelCiudad() {
		return selCiudad;
	}
	public int getSelDepto() {
		return selDepto;
	}
	public List<SelectItem> getItemCiudades() {
		return itemCiudades;
	}
	public void setItemCiudades(List<SelectItem> itemCiudades) {
		this.itemCiudades = itemCiudades;
	}

}
