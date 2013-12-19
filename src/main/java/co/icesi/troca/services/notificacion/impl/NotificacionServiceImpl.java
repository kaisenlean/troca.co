/**
 * 
 */
package co.icesi.troca.services.notificacion.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.model.notificacion.EstadoNotificacion;
import co.icesi.troca.model.notificacion.Modulo;
import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.model.trueque.TruequeTengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.notificacion.NotificacionDao;
import co.icesi.troca.services.impl.GenericServiceImpl;
import co.icesi.troca.services.notificacion.NotificacionService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NotificacionServiceImpl
 * @date 1/12/2013
 *
 */
@Service("notificacionService")
public class NotificacionServiceImpl extends GenericServiceImpl<Notificacion, Integer> implements NotificacionService, Serializable {

	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * INVITACION_PROYECTO
	 */
	private static final String INVITACION_PROYECTO = "Te invita a su Proyecto";

	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * MAX_RESULTS
	 */
	private static final int MAX_RESULTS = 15;

	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private NotificacionDao notificacionDao;
	
	/* (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Notificacion, Integer> getDao() {
		return notificacionDao;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#findNotificacionesUsuario(co.icesi.troca.model.usuario.Usuario, int)
	 */
	@Override
	public List<Notificacion> findNotificacionesUsuario(Usuario usuario) {
		return notificacionDao.findNotificacionesUsuario(usuario, MAX_RESULTS);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#crearNotificacionAdicionProyecto(co.icesi.troca.model.proyecto.ProyectoUsuario)
	 */
	@Override
	public void crearNotificacionAdicionProyecto(ProyectoUsuario proyectoUsuario) {
		Notificacion notificacion= new Notificacion();
		notificacion.setCreador(proyectoUsuario.getProyecto().getOwner());
		notificacion.setFecha(new Date());
		notificacion.setModulo(Modulo.PROYECTO);
		notificacion.setReferenceId(proyectoUsuario.getProyecto().getId().toString());
		notificacion.setUsuario(proyectoUsuario.getUsuario());
		notificacion.setMensaje(INVITACION_PROYECTO+" "+proyectoUsuario.getProyecto().getNombre());
		notificacion.setEstado(EstadoNotificacion.NO_VISTA);
		notificacionDao.save(notificacion);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#crearNotificacionSolicitudTrueque(co.icesi.troca.model.trueque.TruequeTengo)
	 */
	@Override
	public void crearNotificacionSolicitudTrueque(TruequeTengo truequeTengo,String mensaje) {
		Notificacion notificacion= new Notificacion();
		notificacion.setCreador(truequeTengo.getTrueque().getUsuarioTrueque1());
		notificacion.setFecha(new Date());
		notificacion.setModulo(Modulo.TRUEQUE_TENGO);
		notificacion.setReferenceId(truequeTengo.getTrueque().getId().toString());
		notificacion.setUsuario(truequeTengo.getTrueque().getUsuarioTrueque2());
		notificacion.setEstado(EstadoNotificacion.NO_VISTA);
		notificacion.setMensaje("Yo necesito "+truequeTengo.getTengo2()==null?null:truequeTengo.getTengo2().getNombre()+" A cambio te puedo ofrecer "+truequeTengo.getTengo()==null?null:truequeTengo.getTengo().getNombre()+"\n"+mensaje);
		notificacionDao.save(notificacion);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#enviarNotificacionMensajeTrueque(co.icesi.troca.model.trueque.TruequeMensaje)
	 */
	@Override
	public void enviarNotificacionMensajeTrueque(TruequeMensaje truequeMensaje) {
		Notificacion notificacion= new Notificacion();
		notificacion.setCreador(truequeMensaje.getUsuarioEmisor());
		notificacion.setFecha(new Date());
		notificacion.setModulo(Modulo.MENSAJE_TRUEQUE);
		notificacion.setReferenceId(truequeMensaje.getTrueque().getId().toString());
		notificacion.setUsuario(truequeMensaje.getUsuarioReceptor());
		notificacion.setEstado(EstadoNotificacion.NO_VISTA);
		notificacion.setMensaje("Nueva respuesta en tu trueque con "+truequeMensaje.getUsuarioEmisor().getNombreCompleto());
		notificacionDao.save(notificacion);
		
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#crearNotificacionSolicitudTruequeProyecto(co.icesi.troca.model.trueque.TruequeTengo, java.lang.String)
	 */
	@Override
	public void crearNotificacionSolicitudTruequeProyecto(
			TruequeTengo truequeTengo, String mensaje) {
		Notificacion notificacion= new Notificacion();
		notificacion.setCreador(truequeTengo.getTrueque().getUsuarioTrueque1());
		notificacion.setFecha(new Date());
		notificacion.setModulo(Modulo.TRUEQUE_NECESITO);
		notificacion.setReferenceId(truequeTengo.getTrueque().getId().toString());
		notificacion.setUsuario(truequeTengo.getTrueque().getUsuarioTrueque2());
		notificacion.setEstado(EstadoNotificacion.NO_VISTA);
		notificacion.setMensaje("Veo que necesitan "+truequeTengo.getNecesito().getNombre()+" Yo lo tengo y a cambio les pido "+truequeTengo.getTengo().getNombre()+"\n"+mensaje);
		notificacionDao.save(notificacion);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#crearNotificacionComentarioNoticia(co.icesi.troca.model.trueque.TruequeTengo, java.lang.String)
	 */
	@Override
	public void crearNotificacionComentarioNoticia(NoticiaComentario noticiaComentario) {
		
			Notificacion notificacion= new Notificacion();
			notificacion.setCreador(noticiaComentario.getUsuario());
			notificacion.setFecha(Calendar.getInstance().getTime());
			notificacion.setModulo(Modulo.NOTICIA);
			notificacion.setReferenceId(noticiaComentario.getId().toString());
			notificacion.setUsuario(noticiaComentario.getNoticia().getUsuario());
			notificacion.setEstado(EstadoNotificacion.NO_VISTA);
			notificacion.setMensaje(notificacion.getUsuario().getNombreCompleto()+" Ha comentado en tu noticia");
			notificacionDao.save(notificacion);
		
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#crearNotificacionFinalizarTrueque(co.icesi.troca.model.trueque.Trueque)
	 */
	@Override
	public void crearNotificacionFinalizarTrueque(Trueque trueque,Usuario creador) {
		Notificacion notificacion= new Notificacion();
		notificacion.setCreador(creador);
		notificacion.setFecha(Calendar.getInstance().getTime());
		notificacion.setModulo(Modulo.FINALIZACION_TRUEQUE);
		notificacion.setReferenceId(trueque.getId().toString());
		notificacion.setUsuario(trueque.getUsuarioTrueque1().equals(creador)?trueque.getUsuarioTrueque2():trueque.getUsuarioTrueque1());
		EstadoTruequeEnum estadoTruequeUsuario=trueque.getUsuarioTrueque1().equals(creador)?trueque.getEstadoUsuario1():trueque.getEstadoUsuario2();
		EstadoTruequeEnum estado=trueque.getEstado();
		notificacion.setEstado(EstadoNotificacion.NO_VISTA);
		String msjComplemento=estado.equals(EstadoTruequeEnum.ACTIVO)&&estadoTruequeUsuario.equals(EstadoTruequeEnum.ACTIVO)?"Para que se finalize realmente debes finalizarlo tu también":"";
		notificacion.setMensaje(new StringBuilder("Finalizaron tu trueque con ").append(creador.getNombreCompleto()).append(msjComplemento).toString());
		notificacionDao.save(notificacion);
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.notificacion.NotificacionService#crearNotificacionCancelarTrueque(co.icesi.troca.model.trueque.Trueque, co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void crearNotificacionCancelarTrueque(Trueque trueque,
			Usuario usuario) {
		Notificacion notificacion= new Notificacion();
		notificacion.setCreador(usuario);
		notificacion.setFecha(Calendar.getInstance().getTime());
		notificacion.setModulo(Modulo.CANCELACION_TRUEQUE);
		notificacion.setReferenceId(trueque.getId().toString());
		notificacion.setEstado(EstadoNotificacion.NO_VISTA);
		notificacion.setUsuario(trueque.getUsuarioTrueque1().equals(usuario)?trueque.getUsuarioTrueque2():trueque.getUsuarioTrueque1());
		notificacion.setMensaje(new StringBuilder("Cancelaron tu trueque con ").append(usuario.getNombreCompleto()).toString());
		notificacionDao.save(notificacion);
		
	}

}
