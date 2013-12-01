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

}
