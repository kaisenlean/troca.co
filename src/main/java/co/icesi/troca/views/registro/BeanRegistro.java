package co.icesi.troca.views.registro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.Departamento;
import co.icesi.troca.model.Opcion;
import co.icesi.troca.model.Pais;
import co.icesi.troca.model.usuario.EstadoUsuarioEnum;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioLink;
import co.icesi.troca.repositories.constants.OpcionConstants;
import co.icesi.troca.services.CiudadService;
import co.icesi.troca.services.DepartamentoService;
import co.icesi.troca.services.OpcionService;
import co.icesi.troca.services.PaisService;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.seguridad.EncoderManager;
import co.icesi.troca.services.usuario.UsuarioLinkService;
import co.icesi.troca.views.login.Login;

import com.sun.faces.context.ExternalContextImpl;

/**
 * Bean que controla el registro de un usuario al sistema
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanRegistro
 * @date 22/10/2013
 *
 */
/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanRegistro
 * @date 1/12/2013
 * 
 */
@ManagedBean
@SessionScoped
public class BeanRegistro extends BaseBean implements Serializable {

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         POS_LIMNK
	 */
	private static final int POS_LIMNK = 4;

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         THREE
	 */
	private static final int THREE = 3;

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         TWO
	 */
	private static final int TWO = 2;

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ONE
	 */
	private static final int ONE = 1;

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ZERO
	 */
	private static final int ZERO = 0;

	/**
	 * 29/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         COD_PAIS_COLOMBIA
	 */
	private static final int COD_PAIS_COLOMBIA = 343;

	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = -1562983451567645385L;

	private Logger logRegistro = LoggerFactory.getLogger(BeanRegistro.class);

	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioService
	 */
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         paisService
	 */
	@ManagedProperty(value = "#{paisService}")
	private PaisService paisService;

	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         departamentoService
	 */
	@ManagedProperty(value = "#{departamentoService}")
	private DepartamentoService departamentoService;

	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ciudadService
	 */
	@ManagedProperty(value = "#{ciudadService}")
	private CiudadService ciudadService;

	/**
	 * 25/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         encoderManager
	 */
	@ManagedProperty(value = "#{encoderManager}")
	private EncoderManager encoderManager;

	@ManagedProperty(value = "#{usuarioLinkService}")
	private UsuarioLinkService usuarioLinkService;

	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuario
	 */
	private Usuario usuario;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         itemPaises
	 */
	private List<SelectItem> itemPaises;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         itemDeptos
	 */
	private List<SelectItem> itemDeptos;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         itemCiudades
	 */
	private List<SelectItem> itemCiudades;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         selPais
	 */
	private int selPais;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         selDepto
	 */
	private int selDepto;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         selCiudad
	 */
	private int selCiudad;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         pais
	 */
	private Pais pais;
	/**
	 * 22/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         departamento
	 */
	private Departamento departamento;

	private int posLink;

	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink
	 */
	private UsuarioLink usuarioLink;

	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink2
	 */
	private UsuarioLink usuarioLink2;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink3
	 */
	private UsuarioLink usuarioLink3;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink4
	 */
	private UsuarioLink usuarioLink4;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink5
	 */
	private UsuarioLink usuarioLink5;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink6
	 */
	private UsuarioLink usuarioLink6;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink7
	 */
	private UsuarioLink usuarioLink7;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink8
	 */
	private UsuarioLink usuarioLink8;
	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioLink9
	 */
	private UsuarioLink usuarioLink9;

	/**
	 * 25/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         opcionService
	 */
	@ManagedProperty(value = "#{opcionService}")
	private OpcionService opcionService;

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         file
	 */
	private UploadedFile file;

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         in
	 */
	private InputStream in;

	/**
	 * 18/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         login
	 */
	@ManagedProperty(value = "#{login}")
	private Login login;

	public void addUsuarioLink() {
		posLink++;

		goTo("/paginas/registro/registro_3.jsf");

	}

	/**
	 * Metodo que se ejecuta al selecciona una ciudad la busca en la base de
	 * datos y se la carga al usuario
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	public void cambioCiudad() {
		seleccionarCiudad();

	}

	/**
	 * Metodo que se ejecuta al seleccionar un departamento y este carga las
	 * ciudades asociadas
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	public void cambioDepto() {
		cargarCiudad();

	}

	/**
	 * Metodo que carga los paises de la base de datos
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	public void cambioPais() {
		cargarPais();

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 6/11/2013
	 */
	private void captureContextPath() {
		ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		String ctxPath = null;
		ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

		Opcion opcion = opcionService
				.findById(OpcionConstants.KEY_CONTEXT_PATH);
		if (opcion == null) {
			opcion = new Opcion();
			opcion.setKey(OpcionConstants.KEY_CONTEXT_PATH);
			opcion.setValue(ctxPath);
			opcionService.save(opcion);
		} else {
			opcion.setValue(ctxPath);
			opcionService.save(opcion);
		}
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
	 * @date 12/11/2013
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
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
	 * @return
	 */
	public List<SelectItem> getItemDeptos() {
		return itemDeptos;
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
	 * @date 18/12/2013
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/12/2013
	 * @return the logRegistro
	 */
	public Logger getLogRegistro() {
		return logRegistro;
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
	 * @date 28/11/2013
	 * @return the posLink
	 */
	public int getPosLink() {
		return posLink;
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
	public int getSelPais() {
		return selPais;
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
	 * @date 28/11/2013
	 * @return the usuarioLink
	 */
	public UsuarioLink getUsuarioLink() {
		return usuarioLink;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink2
	 */
	public UsuarioLink getUsuarioLink2() {
		return usuarioLink2;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink3
	 */
	public UsuarioLink getUsuarioLink3() {
		return usuarioLink3;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink4
	 */
	public UsuarioLink getUsuarioLink4() {
		return usuarioLink4;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink5
	 */
	public UsuarioLink getUsuarioLink5() {
		return usuarioLink5;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink6
	 */
	public UsuarioLink getUsuarioLink6() {
		return usuarioLink6;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink7
	 */
	public UsuarioLink getUsuarioLink7() {
		return usuarioLink7;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink8
	 */
	public UsuarioLink getUsuarioLink8() {
		return usuarioLink8;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuarioLink9
	 */
	public UsuarioLink getUsuarioLink9() {
		return usuarioLink9;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/12/2013
	 */
	public String goToRegistro1() {

		usuario = new Usuario();
		usuarioLink = new UsuarioLink();
		usuarioLink2 = new UsuarioLink();
		usuarioLink3 = new UsuarioLink();
		usuarioLink4 = new UsuarioLink();
		usuarioLink5 = new UsuarioLink();
		usuarioLink6 = new UsuarioLink();
		usuarioLink7 = new UsuarioLink();
		usuarioLink8 = new UsuarioLink();
		usuarioLink9 = new UsuarioLink();
		itemPaises = paisService.getItmems();
		posLink = ZERO;
		selPais = COD_PAIS_COLOMBIA;
		cambioPais();
		captureContextPath();
		file = null;

		return ("/paginas/registro/registro_1.jsf");

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 */
	public void goToRegistro2() {

		if (!usuario.getEmail().equals(usuario.getRepeatMail())) {
			error("Email no coincide");
			return;
		}

		if (usuario.getId() == (null)) {
			if (usuarioService.findByEmail(usuario.getEmail()) == (null)) {
				goTo("/paginas/registro/registro_2.jsf");
			} else {

				mensajeError("Este email ya está registrado");
			}
		} else {
			goTo("/paginas/registro/registro_2.jsf");

		}

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	public void guardarUsuario() {
		usuario.setCiudad(ciudadService.findById(selCiudad));
		usuario.setEstado(EstadoUsuarioEnum.ACTIVO);
		if (usuario.getPassword() == null || usuario.getPassword().equals("")) {
			usuario.setPassword(usuario.getPasswordTemp());
		} else {
			usuario.setPassword(encoderManager.encodeMd5Hash(usuario
					.getPassword()));
		}
		boolean actualizarLogin = false;
		try {

			String ext = usuario.getExtension();
			if (usuario.getId() != null) {
				if (usuario.getId() != 0) {

					actualizarLogin = true;
				}
			}
			usuario = usuarioService.save(usuario);
			usuario.setExtension(ext);
			/* guardamos los links */
			usuarioLink.setUsuario(usuario);
			usuarioLinkService.save(usuarioLink);

			usuarioLink2.setUsuario(usuario);
			usuarioLinkService.save(usuarioLink2);

			usuarioLink3.setUsuario(usuario);
			usuarioLinkService.save(usuarioLink3);

			usuarioLink3.setUsuario(usuario);
			usuarioLinkService.save(usuarioLink3);

			usuarioLink4.setUsuario(usuario);
			usuarioLinkService.save(usuarioLink4);

			if (in != null) {
				uploadPhotoFile();
			}
		} catch (Exception e) {
			logRegistro.error(e.toString());
		}
		if (actualizarLogin) {
			login.setUsuario(usuario);
			login.cargarPropiedadesUsuario();
		}
		goTo("/index.jsf");

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 */
	@PostConstruct
	public void init() {

		usuario = new Usuario();
		usuarioLink = new UsuarioLink();
		usuarioLink2 = new UsuarioLink();
		usuarioLink3 = new UsuarioLink();
		usuarioLink4 = new UsuarioLink();
		usuarioLink5 = new UsuarioLink();
		usuarioLink6 = new UsuarioLink();
		usuarioLink7 = new UsuarioLink();
		usuarioLink8 = new UsuarioLink();
		usuarioLink9 = new UsuarioLink();
		itemPaises = paisService.getItmems();
		posLink = ZERO;
		selPais = COD_PAIS_COLOMBIA;
		cambioPais();
		captureContextPath();
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param usuario
	 */
	public void prepararEdicionUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.usuario.setRepeatMail(usuario.getEmail());
		if (!usuario.getUsuarioLinks().isEmpty()) {

			usuarioLink = usuario.getUsuarioLinks().get(ZERO);
			usuarioLink2 = usuario.getUsuarioLinks().get(ONE);
			usuarioLink3 = usuario.getUsuarioLinks().get(TWO);
			usuarioLink4 = usuario.getUsuarioLinks().get(THREE);
		}

		posLink = POS_LIMNK;
		this.usuario.setPasswordTemp(usuario.getPassword());
		selPais = usuario.getCiudad().getDepartamento().getPais().getId();
		cambioPais();
		selDepto = usuario.getCiudad().getDepartamento().getId();
		cambioDepto();
		selCiudad = usuario.getCiudad().getId();
		cambioCiudad();
		goTo("/paginas/registro/registro_1.jsf");

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
	 * @param ciudadService
	 */
	public void setCiudadService(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
	 * @date 25/11/2013
	 * @param encoderManager
	 *            the encoderManager to set
	 */
	public void setEncoderManager(EncoderManager encoderManager) {
		this.encoderManager = encoderManager;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
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
	 * @date 22/10/2013
	 * @param itemDeptos
	 */
	public void setItemDeptos(List<SelectItem> itemDeptos) {
		this.itemDeptos = itemDeptos;
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
	 * @date 18/12/2013
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/12/2013
	 * @param logRegistro
	 *            the logRegistro to set
	 */
	public void setLogRegistro(Logger logRegistro) {
		this.logRegistro = logRegistro;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 25/11/2013
	 * @param opcionService
	 *            the opcionService to set
	 */
	public void setOpcionService(OpcionService opcionService) {
		this.opcionService = opcionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
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
	 * @date 28/11/2013
	 * @param posLink
	 *            the posLink to set
	 */
	public void setPosLink(int posLink) {
		this.posLink = posLink;
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
	 * @param selPais
	 */
	public void setSelPais(int selPais) {
		this.selPais = selPais;
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
	 * @date 28/11/2013
	 * @param usuarioLink
	 *            the usuarioLink to set
	 */
	public void setUsuarioLink(UsuarioLink usuarioLink) {
		this.usuarioLink = usuarioLink;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink2
	 *            the usuarioLink2 to set
	 */
	public void setUsuarioLink2(UsuarioLink usuarioLink2) {
		this.usuarioLink2 = usuarioLink2;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink3
	 *            the usuarioLink3 to set
	 */
	public void setUsuarioLink3(UsuarioLink usuarioLink3) {
		this.usuarioLink3 = usuarioLink3;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink4
	 *            the usuarioLink4 to set
	 */
	public void setUsuarioLink4(UsuarioLink usuarioLink4) {
		this.usuarioLink4 = usuarioLink4;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink5
	 *            the usuarioLink5 to set
	 */
	public void setUsuarioLink5(UsuarioLink usuarioLink5) {
		this.usuarioLink5 = usuarioLink5;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink6
	 *            the usuarioLink6 to set
	 */
	public void setUsuarioLink6(UsuarioLink usuarioLink6) {
		this.usuarioLink6 = usuarioLink6;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink7
	 *            the usuarioLink7 to set
	 */
	public void setUsuarioLink7(UsuarioLink usuarioLink7) {
		this.usuarioLink7 = usuarioLink7;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink8
	 *            the usuarioLink8 to set
	 */
	public void setUsuarioLink8(UsuarioLink usuarioLink8) {
		this.usuarioLink8 = usuarioLink8;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLink9
	 *            the usuarioLink9 to set
	 */
	public void setUsuarioLink9(UsuarioLink usuarioLink9) {
		this.usuarioLink9 = usuarioLink9;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuarioLinkService
	 *            the usuarioLinkService to set
	 */
	public void setUsuarioLinkService(UsuarioLinkService usuarioLinkService) {
		this.usuarioLinkService = usuarioLinkService;
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
	 * @date 1/12/2013
	 */
	public void uploadHandlerPhoto1() {
		try {
			in = file.getInputstream();
			usuario.setExtension(detectarExtension(file.getFileName()));
		} catch (IOException e) {
			mensajeError(e.toString());
		}

	}

	public void uploadPhotoFile() {
		ExternalContextImpl request;
		request = (ExternalContextImpl) FacesContext.getCurrentInstance()
				.getExternalContext();

		String path = request.getRealPath("/foto/usuario/");
		OutputStream out;
		try {
			out = new FileOutputStream(path + "/" + usuario.getId()
					+ usuario.getExtension());

			usuario.setFotografia(usuario.getId() + usuario.getExtension());
			usuario = usuarioService.save(usuario);
			if (in != null) {
				int b = 0;
				while (b != -1) {
					b = in.read();
					if (b != -1) {
						out.write(b);

					}

				}
			}
		} catch (Exception e) {
			mensajeError(e.toString());
		}
	}
}
