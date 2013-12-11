/**
 * 
 */
package co.icesi.troca.views.perfil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.Calificacion;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.OpcionService;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.calificacion.CalificacionService;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.services.proyecto.ProyectoService;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.services.trueque.TruequeService;
import co.icesi.troca.services.usuario.UsuarioLinkService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class PerfilDe
 * @date 2/12/2013
 * 
 */
@ManagedBean
@SessionScoped
public class PerfilDe extends BaseBean implements Serializable {

	/**
	 * 2/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{opcionService}")
	private OpcionService opcionService;

	@ManagedProperty(value = "#{proyectoService}")
	private ProyectoService proyectoService;

	@ManagedProperty(value = "#{tengoService}")
	private TengoService tengoService;

	@ManagedProperty(value = "#{noticiaService}")
	private NoticiaService noticiaService;

	@ManagedProperty(value = "#{usuarioLinkService}")
	private UsuarioLinkService usuarioLinkService;

	@ManagedProperty(value = "#{truequeService}")
	private TruequeService truequeService;

	private List<Trueque> truequesActivos;
	private List<Trueque> truequesFinalizados;
	private List<Trueque> truequesCancelados;
	
	@ManagedProperty(value="#{calificacionService}")
	private CalificacionService calificacionService;
	

	private Usuario usuario = new Usuario();

	
	private String promedio;
	
	
	

	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * calificaciones
	 */
	private List<Calificacion> calificaciones= new ArrayList<Calificacion>();
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuario
	 */
	public void loadPerfil(Usuario usuario) {

		this.usuario = usuario;
		this.usuario.setProyectos(proyectoService
				.findProyectosByUsuario(usuario));
		this.usuario.setTengos(tengoService.findTengosByUsuario(usuario));
		this.usuario.setNoticias(noticiaService.findNoticiasByUsuario(usuario));
		this.usuario.setUsuarioLinks(usuarioLinkService.getLinkByUsuario(usuario));
		truequesActivos=truequeService.findActivosByUsuarioAndEstado(usuario, EstadoTruequeEnum.ACTIVO);
		truequesFinalizados=truequeService.findActivosByUsuarioAndEstado(usuario, EstadoTruequeEnum.FINALIZADO);
		truequesCancelados=truequeService.findActivosByUsuarioAndEstado(usuario, EstadoTruequeEnum.CANCELADO);
		calificaciones=calificacionService.findCalificacionByUsuario(usuario);
		
		double promTemp=0.0;
		for (Calificacion cf : calificaciones) {
		promTemp+=cf.getPuntajeVal().doubleValue();
		}
		if (!calificaciones.isEmpty()) {
			
		promTemp/=calificaciones.size();
		}
		promedio=String.valueOf(promTemp);
		
		goTo("/paginas/perfil/perfilDe.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the truequesActivos
	 */
	public List<Trueque> getTruequesActivos() {
		return truequesActivos;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the truequesCancelados
	 */
	public List<Trueque> getTruequesCancelados() {
		return truequesCancelados;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the truequesFinalizados
	 */
	public List<Trueque> getTruequesFinalizados() {
		return truequesFinalizados;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the opcionService
	 */
	public OpcionService getOpcionService() {
		return opcionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param opcionService
	 *            the opcionService to set
	 */
	public void setOpcionService(OpcionService opcionService) {
		this.opcionService = opcionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the proyectoService
	 */
	public ProyectoService getProyectoService() {
		return proyectoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param proyectoService
	 *            the proyectoService to set
	 */
	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the tengoService
	 */
	public TengoService getTengoService() {
		return tengoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param tengoService
	 *            the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the noticiaService
	 */
	public NoticiaService getNoticiaService() {
		return noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param noticiaService
	 *            the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuarioLinkService
	 */
	public UsuarioLinkService getUsuarioLinkService() {
		return usuarioLinkService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuarioLinkService
	 *            the usuarioLinkService to set
	 */
	public void setUsuarioLinkService(UsuarioLinkService usuarioLinkService) {
		this.usuarioLinkService = usuarioLinkService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param truequeService
	 *            the truequeService to set
	 */
	public void setTruequeService(TruequeService truequeService) {
		this.truequeService = truequeService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param calificacionService the calificacionService to set
	 */
	public void setCalificacionService(CalificacionService calificacionService) {
		this.calificacionService = calificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the promedio
	 */
	public String getPromedio() {
		return promedio;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the calificaciones
	 */
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param calificaciones the calificaciones to set
	 */
	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	
}
