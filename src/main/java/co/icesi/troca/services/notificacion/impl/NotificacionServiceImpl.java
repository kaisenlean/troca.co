/**
 * 
 */
package co.icesi.troca.services.notificacion.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.notificacion.Modulo;
import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.proyecto.ProyectoUsuario;
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
		notificacion.setMensaje(INVITACION_PROYECTO);
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
		notificacion.setReferenceId(truequeTengo.getId().toString());
		notificacion.setUsuario(truequeTengo.getTrueque().getUsuarioTrueque2());
		notificacion.setMensaje("Yo necesito "+truequeTengo.getTengo2().getNombre()+" A cambio te puedo ofrecer "+truequeTengo.getTengo().getNombre()+"\n"+mensaje);
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
		notificacion.setMensaje("Nueva respuesta en tu trueque con "+truequeMensaje.getUsuarioEmisor().getNombreCompleto());
		notificacionDao.save(notificacion);
		
	}

}
