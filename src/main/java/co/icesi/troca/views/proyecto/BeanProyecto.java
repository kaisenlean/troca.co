/**
 * 
 */
package co.icesi.troca.views.proyecto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.necesito.Necesito;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.necesito.CategoriaNecesitoService;
import co.icesi.troca.services.necesito.NecesitoService;
import co.icesi.troca.services.notificacion.NotificacionService;
import co.icesi.troca.services.proyecto.ProyectoCategoriaService;
import co.icesi.troca.services.proyecto.ProyectoService;
import co.icesi.troca.services.proyecto.ProyectoTengoUsuarioService;
import co.icesi.troca.services.proyecto.ProyectoUsuarioService;
import co.icesi.troca.views.component.autocomplete.usuario.AutocompleteUsuario;
import co.icesi.troca.views.login.Login;

import com.sun.faces.context.ExternalContextImpl;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanProyecto
 * @date 24/11/2013
 * 
 */
@ManagedBean
@SessionScoped
public class BeanProyecto extends BaseBean implements Serializable {

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         autocompleteUsuario
	 */
	private AutocompleteUsuario autocompleteUsuario;

	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         modelUsuarios
	 */
	private DualListModel<Usuario> modelUsuarios = new DualListModel<Usuario>();

	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuariosTarget
	 */
	private List<Usuario> usuariosTarget = new ArrayList<Usuario>();

	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarios
	 */
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         login
	 */
	@ManagedProperty(value = "#{login}")
	private Login login;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyectoService
	 */
	@ManagedProperty(value = "#{proyectoService}")
	private ProyectoService proyectoService;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         categoriaNecesitoService
	 */
	@ManagedProperty(value = "#{categoriaNecesitoService}")
	private CategoriaNecesitoService categoriaNecesitoService;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         necesitoService
	 */
	@ManagedProperty(value = "#{necesitoService}")
	private NecesitoService necesitoService;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyectoCategoriaService
	 */
	@ManagedProperty(value = "#{proyectoCategoriaService}")
	private ProyectoCategoriaService proyectoCategoriaService;

	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         usuarioService
	 */
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyectoTengoUsuarioService
	 */
	@ManagedProperty(value = "#{proyectoTengoUsuarioService}")
	private ProyectoTengoUsuarioService proyectoTengoUsuarioService;

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyectoUsuarioService
	 */
	@ManagedProperty(value = "#{proyectoUsuarioService}")
	private ProyectoUsuarioService proyectoUsuarioService;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyecto
	 */
	private Proyecto proyecto = new Proyecto();

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         necesitosProyecto
	 */
	private List<Necesito> necesitosProyecto = new ArrayList<Necesito>();

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         categoriaNecesito
	 */
	private int categoriaNecesito;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         categoriaProyecto
	 */
	private int categoriaProyecto;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         nombreNecesito
	 */
	private String nombreNecesito;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         descripcionNecesito
	 */
	private String descripcionNecesito;

	/**
	 * 30/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         in
	 */
	private InputStream in;

	/**
	 * 7/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         unadidos
	 */
	private List<Usuario> unadidos = new ArrayList<Usuario>();
	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         query
	 */
	private String queryFind;

	/**
	 * 30/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         file
	 */
	private UploadedFile file;

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         eliminados
	 */
	private List<ProyectoUsuario> eliminados = new ArrayList<ProyectoUsuario>();

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         eliminados
	 */
	private List<ProyectoUsuario> creados = new ArrayList<ProyectoUsuario>();

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         necesitoCreados
	 */
	private List<Necesito> necesitoEliminados = new ArrayList<Necesito>();

	@ManagedProperty(value = "#{notificacionService}")
	private NotificacionService notificacionService;

	private boolean edita;

	private List<ProyectoTengoUsuario> tengos;

	private boolean perfilDe;

	@ManagedProperty(value = "#{beanRegistroVisita}")
	private BeanRegistroVisita beanRegistroVisita;

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 30/11/2013
	 * @param event
	 */
	public void uploadHandlerPhoto1() {
		try {
			in = file.getInputstream();
			proyecto.setExtension(detectarExtension(file.getFileName()));
		} catch (IOException e) {
			mensajeError(e.toString());
		}

	}

	@SuppressWarnings("resource")
	public void uploadPhotoFile() throws Exception {
		ExternalContextImpl request;
		request = (ExternalContextImpl) FacesContext.getCurrentInstance()
				.getExternalContext();

		String path = request.getRealPath("/foto/proyecto/");
		OutputStream out = new FileOutputStream(path + "/" + proyecto.getId()
				+ proyecto.getExtension());

		if (in != null) {
			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1) {
					out.write(b);

				}

			}
		}

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 */
	public void agregarNecesito() {
		Necesito necesito = new Necesito();
		necesito.setDescripcion(descripcionNecesito);
		necesito.setNombre(nombreNecesito);
		if (categoriaNecesito == 0) {
			mensajeError("Por favor selecciona una categoria válida");
			return;
		}
		necesito.setCategoria(categoriaNecesitoService
				.findById(categoriaNecesito));
		necesitosProyecto.add(necesito);
		nombreNecesito = "";
		descripcionNecesito = "";

	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 */
	public void guardarProyecto() {
		if (categoriaProyecto == 0) {
			mensajeError("Selecciona una categoria valida para el proyecto");
			return;
		}
		if (proyecto.getId() == null) {
			proyecto.setFechaRegistro(new Date());
		}

		proyecto.setCategoria(proyectoCategoriaService
				.findById(categoriaProyecto));
		
		if (proyecto.getOwner() == null) {
			proyecto.setOwner(login.getUsuario());

		}

		String ext = proyecto.getExtension();
		proyecto = proyectoService.save(proyecto);
		proyecto.setExtension(ext);

		procesarNecesitos();

		procesarTengos();
		if (in != null) {
			try {
				uploadPhotoFile();
				proyecto.setImage(proyecto.getId() + proyecto.getExtension());
				proyecto = proyectoService.save(proyecto);
			} catch (Exception e) {
				mensajeError(e.toString());
			}
		}

		for (Usuario usuario : unadidos) {
			if (proyectoUsuarioService.getByUsuarioAndProyecto(usuario,
					proyecto) == null) {
				ProyectoUsuario pu = new ProyectoUsuario();
				pu.setProyecto(proyecto);
				pu.setUsuario(usuario);
				pu = proyectoUsuarioService.save(pu);
				notificacionService.crearNotificacionAdicionProyecto(pu);
			}

		}
		for (ProyectoUsuario pu : eliminados) {
			proyectoUsuarioService.delete(pu);
		}
		login.reloadTengosProyectos();
		init();
		goTo("/paginas/perfil/perfil.jsf");
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 23/12/2013
	*/
	private void procesarTengos() {
		for (Tengo tengo : login.getUsuario().getTengos()) {

			ProyectoTengoUsuario ptu = proyectoTengoUsuarioService
					.getByTengoAndProyecto(proyecto, tengo);

			if (tengo.isSeleccionado()) {

				if (ptu == null) {

					ProyectoTengoUsuario tengoUsuario = new ProyectoTengoUsuario();
					tengoUsuario.setProyecto(proyecto);
					tengoUsuario.setTengo(tengo);
					proyectoTengoUsuarioService.save(tengoUsuario);
				}
			} else {
				if (ptu != null) {
					proyectoTengoUsuarioService.delete(ptu);
				}

			}
			tengo.setSeleccionado(false);
		}
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 23/12/2013
	*/
	private void procesarNecesitos() {
		for (Necesito necesito : necesitosProyecto) {
			necesito.setProyecto(proyecto);
			necesito.setUsuario(login.getUsuario());

			necesitoService.save(necesito);

		}

		for (Necesito necesito : necesitoEliminados) {
			if (necesito.getId() != null) {

				necesitoService.delete(necesito);
			}
		}
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyecto
	 */
	public void verDetalleProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
		creados = proyectoUsuarioService.findByProyecto(proyecto);
		necesitosProyecto = necesitoService.findNecesitoByProyecto(proyecto);
		tengos = proyectoTengoUsuarioService.findTengosByProyecto(proyecto);
		perfilDe = false;
		goTo("/paginas/proyecto/perfil_proyecto.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyecto
	 */
	public void verDetalleProyecto2(Proyecto proyecto) {
		this.proyecto = proyecto;

		creados = proyectoUsuarioService.findByProyecto(proyecto);
		necesitosProyecto = necesitoService.findNecesitoByProyecto(proyecto);
		tengos = proyectoTengoUsuarioService.findTengosByProyecto(proyecto);
		perfilDe = true;
		beanRegistroVisita.guardarVisita(proyecto);
		goTo("/paginas/proyecto/perfil_proyecto.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 */
	public void removerUsuarioProyecto(ProyectoUsuario proyectoUsuario) {
		eliminados.add(proyectoUsuario);
		creados.remove(proyectoUsuario);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param usuario
	 */
	public void removeUsuariosAnadido(Usuario usuario) {

		unadidos.remove(usuario);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param proyecto
	 */
	public void eliminarProyecto(Proyecto proyecto) {
		if (login.getUsuario().equals(proyecto.getOwner())) {

			proyectoService.delete(proyecto);
		} else {
			ProyectoUsuario pu = proyectoUsuarioService
					.getByUsuarioAndProyecto(login.getUsuario(), proyecto);
			proyectoUsuarioService.delete(pu);

		}
		login.reloadTengosProyectos();

		goTo("/paginas/perfil/perfil.jsf");

	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 */
	public void filtrarUsuarios() {
		usuariosTarget = usuarioService.findUsuariosByParam(queryFind);
		usuariosTarget.remove(login.getUsuario());
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 * @param proyecto
	 */
	public void editarProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
		this.categoriaProyecto = proyecto.getCategoria().getId();
		for (Tengo tengo : login.getUsuario().getTengos()) {

			int x = 0;
			for (ProyectoTengoUsuario proy : proyectoTengoUsuarioService
					.findTengosByProyecto(proyecto)) {
				if (proy.getTengo().equals(tengo)) {
					tengo.setSeleccionado(true);
					login.getUsuario().getTengos().set(x, tengo);
				}
			}
			x++;

		}

		necesitosProyecto = necesitoService.findNecesitoByProyecto(proyecto);

		creados = proyectoUsuarioService.findByProyecto(proyecto);
		if (login.getUsuario().equals(proyecto.getOwner())) {

			goTo("/paginas/proyecto/crear_proyecto_1.jsf");
		} else {
			goTo("/paginas/proyecto/crear_proyecto_3.jsf");
		}
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 */
	@PostConstruct
	private void init() {
		in = null;
		nombreNecesito = "";
		descripcionNecesito = "";
		usuarios = usuarioService.findAll();
		modelUsuarios = new DualListModel<Usuario>(usuarios, usuariosTarget);
		autocompleteUsuario = new AutocompleteUsuario() {

			/**
			 * 28/11/2013
			 * 
			 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz
			 *         Lazo</a> serialVersionUID
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public UsuarioService getService() {
				return usuarioService;
			}

			/**
			 * (non-Javadoc)
			 * 
			 * @see co.icesi.troca.views.component.autocomplete.usuario.AutocompleteUsuario#postSeleccionado()
			 */
			@Override
			public void postSeleccionado() {

				usuariosTarget.add(seleccionado);
			}

		};
		unadidos = new ArrayList<Usuario>();
		creados = new ArrayList<ProyectoUsuario>();
		eliminados = new ArrayList<ProyectoUsuario>();
		necesitosProyecto = new ArrayList<Necesito>();
		necesitoEliminados = new ArrayList<Necesito>();
		edita = false;
		perfilDe = false;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param necesito
	 */
	public void removeNecesito(Necesito necesito) {
		necesitosProyecto.remove(necesito);
		necesitoEliminados.add(necesito);

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 */
	public void addUnadidos(Usuario usuario) {

		if (!unadidos.contains(usuario)) {
			unadidos.add(usuario);
		}

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 */
	public void goTo1() {
		proyecto = new Proyecto();
		init();
		goTo("/paginas/proyecto/crear_proyecto_1.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 */
	public void goTo2() {

		goTo("/paginas/proyecto/crear_proyecto_2.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 */
	public void goTo3() {

		goTo("/paginas/proyecto/crear_proyecto_3.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyectoService
	 *            the proyectoService to set
	 */
	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyecto
	 *            the proyecto to set
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the categoriaNecesito
	 */
	public int getCategoriaNecesito() {
		return categoriaNecesito;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaNecesito
	 *            the categoriaNecesito to set
	 */
	public void setCategoriaNecesito(int categoriaNecesito) {
		this.categoriaNecesito = categoriaNecesito;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the descripcionNecesito
	 */
	public String getDescripcionNecesito() {
		return descripcionNecesito;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param descripcionNecesito
	 *            the descripcionNecesito to set
	 */
	public void setDescripcionNecesito(String descripcionNecesito) {
		this.descripcionNecesito = descripcionNecesito;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the nombreNecesito
	 */
	public String getNombreNecesito() {
		return nombreNecesito;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param nombreNecesito
	 *            the nombreNecesito to set
	 */
	public void setNombreNecesito(String nombreNecesito) {
		this.nombreNecesito = nombreNecesito;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaNecesitoService
	 *            the categoriaNecesitoService to set
	 */
	public void setCategoriaNecesitoService(
			CategoriaNecesitoService categoriaNecesitoService) {
		this.categoriaNecesitoService = categoriaNecesitoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the categoriaNecesitoService
	 */
	public CategoriaNecesitoService getCategoriaNecesitoService() {
		return categoriaNecesitoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param necesitosProyecto
	 *            the necesitosProyecto to set
	 */
	public void setNecesitosProyecto(List<Necesito> necesitosProyecto) {
		this.necesitosProyecto = necesitosProyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param necesitoService
	 *            the necesitoService to set
	 */
	public void setNecesitoService(NecesitoService necesitoService) {
		this.necesitoService = necesitoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the categoriaProyecto
	 */
	public int getCategoriaProyecto() {
		return categoriaProyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param categoriaProyecto
	 *            the categoriaProyecto to set
	 */
	public void setCategoriaProyecto(int categoriaProyecto) {
		this.categoriaProyecto = categoriaProyecto;
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

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param proyectoTengoUsuarioService
	 *            the proyectoTengoUsuarioService to set
	 */
	public void setProyectoTengoUsuarioService(
			ProyectoTengoUsuarioService proyectoTengoUsuarioService) {
		this.proyectoTengoUsuarioService = proyectoTengoUsuarioService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @return the autocompleteUsuario
	 */
	public AutocompleteUsuario getAutocompleteUsuario() {
		return autocompleteUsuario;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @param autocompleteUsuario
	 *            the autocompleteUsuario to set
	 */
	public void setAutocompleteUsuario(AutocompleteUsuario autocompleteUsuario) {
		this.autocompleteUsuario = autocompleteUsuario;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 27/11/2013
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the modelUsuarios
	 */
	public DualListModel<Usuario> getModelUsuarios() {
		return modelUsuarios;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param modelUsuarios
	 *            the modelUsuarios to set
	 */
	public void setModelUsuarios(DualListModel<Usuario> modelUsuarios) {
		this.modelUsuarios = modelUsuarios;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @return the usuariosTarget
	 */
	public List<Usuario> getUsuariosTarget() {
		return usuariosTarget;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param usuariosTarget
	 *            the usuariosTarget to set
	 */
	public void setUsuariosTarget(List<Usuario> usuariosTarget) {
		this.usuariosTarget = usuariosTarget;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 29/11/2013
	 * @return the necesitosProyecto
	 */
	public List<Necesito> getNecesitosProyecto() {
		return necesitosProyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 30/11/2013
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the queryFind
	 */
	public String getQueryFind() {
		return queryFind;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param queryFind
	 *            the queryFind to set
	 */
	public void setQueryFind(String queryFind) {
		this.queryFind = queryFind;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 30/11/2013
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the unadidos
	 */
	public List<Usuario> getUnadidos() {
		return unadidos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param unadidos
	 *            the unadidos to set
	 */
	public void setUnadidos(List<Usuario> unadidos) {
		this.unadidos = unadidos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param proyectoUsuarioService
	 *            the proyectoUsuarioService to set
	 */
	public void setProyectoUsuarioService(
			ProyectoUsuarioService proyectoUsuarioService) {
		this.proyectoUsuarioService = proyectoUsuarioService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param notificacionService
	 *            the notificacionService to set
	 */
	public void setNotificacionService(NotificacionService notificacionService) {
		this.notificacionService = notificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the eliminados
	 */
	public List<ProyectoUsuario> getEliminados() {
		return eliminados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the creados
	 */
	public List<ProyectoUsuario> getCreados() {
		return creados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param eliminados
	 *            the eliminados to set
	 */
	public void setEliminados(List<ProyectoUsuario> eliminados) {
		this.eliminados = eliminados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param creados
	 *            the creados to set
	 */
	public void setCreados(List<ProyectoUsuario> creados) {
		this.creados = creados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the edita
	 */
	public boolean isEdita() {
		return edita;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param edita
	 *            the edita to set
	 */
	public void setEdita(boolean edita) {
		this.edita = edita;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the necesitoEliminados
	 */
	public List<Necesito> getNecesitoEliminados() {
		return necesitoEliminados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param necesitoEliminados
	 *            the necesitoEliminados to set
	 */
	public void setNecesitoEliminados(List<Necesito> necesitoEliminados) {
		this.necesitoEliminados = necesitoEliminados;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the tengos
	 */
	public List<ProyectoTengoUsuario> getTengos() {
		return tengos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param tengos
	 *            the tengos to set
	 */
	public void setTengos(List<ProyectoTengoUsuario> tengos) {
		this.tengos = tengos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the perfilDe
	 */
	public boolean isPerfilDe() {
		return perfilDe;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param perfilDe
	 *            the perfilDe to set
	 */
	public void setPerfilDe(boolean perfilDe) {
		this.perfilDe = perfilDe;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param beanRegistroVisita
	 *            the beanRegistroVisita to set
	 */
	public void setBeanRegistroVisita(BeanRegistroVisita beanRegistroVisita) {
		this.beanRegistroVisita = beanRegistroVisita;
	}

	public List<SelectItem> getTengosAsItems() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (ProyectoTengoUsuario tengo : tengos) {
			items.add(new SelectItem(tengo.getTengo().getId(), tengo.getTengo()
					.getNombre()));
		}

		return items;
	}
}
