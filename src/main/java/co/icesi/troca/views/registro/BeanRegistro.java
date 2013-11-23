package co.icesi.troca.views.registro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.mail.login.LoginNotification;
import co.icesi.troca.model.Departamento;
import co.icesi.troca.model.Pais;
import co.icesi.troca.model.usuario.EstadoUsuarioEnum;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.CiudadService;
import co.icesi.troca.services.DepartamentoService;
import co.icesi.troca.services.PaisService;
import co.icesi.troca.services.UsuarioService;
/**
 * Bean que controla el registro de un usuario al sistema
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class BeanRegistro
* @date 22/10/2013
*
 */
@ManagedBean
@SessionScoped
public class BeanRegistro extends BaseBean implements Serializable {

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1562983451567645385L;
	
	
	private static Logger LOGGER= LoggerFactory.getLogger(BeanRegistro.class);

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * usuarioService
	 */
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * paisService
	 */
	@ManagedProperty(value = "#{paisService}")
	private PaisService paisService;

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * departamentoService
	 */
	@ManagedProperty(value = "#{departamentoService}")
	private DepartamentoService departamentoService;

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * ciudadService
	 */
	@ManagedProperty(value = "#{ciudadService}")
	private CiudadService ciudadService;

	
	@ManagedProperty(value="#{loginNotification}")
	private LoginNotification loginNotification;
	
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * usuario
	 */
	private Usuario usuario;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * itemPaises
	 */
	private List<SelectItem> itemPaises;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * itemDeptos
	 */
	private List<SelectItem> itemDeptos;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * itemCiudades
	 */
	private List<SelectItem> itemCiudades;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * selPais
	 */
	private int selPais;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * selDepto
	 */
	private int selDepto;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * selCiudad
	 */
	private int selCiudad;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * pais
	 */
	private Pais pais;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * departamento
	 */
	private Departamento departamento;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	@PostConstruct
	public void init() {

		usuario = new Usuario();
		itemPaises = paisService.getItmems();
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	public void guardarUsuario() {
		usuario.setCiudad(ciudadService.findById(selCiudad));
		usuario.setEstado(EstadoUsuarioEnum.INACTIVO);
		try {
		loginNotification.enviarMailAutenticacionCuenta(usuario);
		usuarioService.save(usuario);
		} catch (Exception e) {
			LOGGER.error(e.toString());
		}
		goTo("/index.jsf");

	}

	/**
	 * Metodo que carga los paises de la base de datos
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	public void cambioPais() {
		cargarPais();

	}

	/**
	 * Metodo que se ejecuta al seleccionar un departamento y este carga las ciudades asociadas
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	public void cambioDepto() {
		cargarCiudad();

	}

	/**
	 * Metodo que se ejecuta al selecciona una ciudad la busca en la base de datos y se la carga al usuario
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	public void cambioCiudad() {
		seleccionarCiudad();

	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	private void seleccionarCiudad() {
		usuario.setCiudad(ciudadService.findById(selCiudad));
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	private void cargarCiudad() {
		departamento = departamentoService.findById(selDepto);
		itemCiudades = ciudadService.getItmemsByDepto(departamento);

	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	*/
	private void cargarPais() {
		pais = paisService.findById(selPais);
		itemDeptos = departamentoService.getItmemsByPais(pais);

	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param usuarioService
	*/
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param usuario
	*/
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param paisService
	*/
	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public List<SelectItem> getItemPaises() {
		return itemPaises;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param itemPaises
	*/
	public void setItemPaises(List<SelectItem> itemPaises) {
		this.itemPaises = itemPaises;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public int getSelPais() {
		return selPais;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param selPais
	*/
	public void setSelPais(int selPais) {
		this.selPais = selPais;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public List<SelectItem> getItemDeptos() {
		return itemDeptos;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param itemDeptos
	*/
	public void setItemDeptos(List<SelectItem> itemDeptos) {
		this.itemDeptos = itemDeptos;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param departamentoService
	*/
	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param ciudadService
	*/
	public void setCiudadService(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param selCiudad
	*/
	public void setSelCiudad(int selCiudad) {
		this.selCiudad = selCiudad;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param selDepto
	*/
	public void setSelDepto(int selDepto) {
		this.selDepto = selDepto;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public int getSelCiudad() {
		return selCiudad;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public int getSelDepto() {
		return selDepto;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public List<SelectItem> getItemCiudades() {
		return itemCiudades;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param itemCiudades
	*/
	public void setItemCiudades(List<SelectItem> itemCiudades) {
		this.itemCiudades = itemCiudades;
	}

	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 * @param loginNotification the loginNotification to set
	 */
	public void setLoginNotification(LoginNotification loginNotification) {
		this.loginNotification = loginNotification;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
