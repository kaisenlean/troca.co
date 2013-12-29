/**
 * 
 */
package co.icesi.troca.views.notificacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.notificacion.EstadoNotificacion;
import co.icesi.troca.model.notificacion.Modulo;
import co.icesi.troca.model.notificacion.Notificacion;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.services.notificacion.NotificacionService;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.views.noticia.BeanNoticia;
import co.icesi.troca.views.proyecto.BeanProyecto;
import co.icesi.troca.views.trueque.BeanTrueque;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanNotificacion
 * @date 9/12/2013
 * 
 */
@ManagedBean
@RequestScoped
public class RedirectNotificacion extends BaseBean implements Serializable {

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         notificacionService
	 */
	@ManagedProperty(value = "#{notificacionService}")
	private NotificacionService notificacionService;

	@ManagedProperty(value = "#{tengoService}")
	private TengoService tengoService;

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         lista
	 */
	private List<Notificacion> lista;

	@ManagedProperty(value = "#{beanNoticia}")
	private BeanNoticia beanNoticia;

	@ManagedProperty(value = "#{noticiaService}")
	private NoticiaService noticiaService;

	@ManagedProperty(value = "#{beanTrueque}")
	private BeanTrueque beanTrueque;

	@ManagedProperty(value = "#{beanProyecto}")
	private BeanProyecto beanProyecto;

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 11/12/2013
	 * @return the beanProyecto
	 */
	public BeanProyecto getBeanProyecto() {
		return beanProyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the lista
	 */
	public List<Notificacion> getLista() {
		return lista;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param notificacion
	 */
	public void loadUrl(Notificacion notificacion) {

		notificacion.setEstado(EstadoNotificacion.VISTA);
		notificacionService.save(notificacion);

		if (notificacion.getModulo().equals(Modulo.TRUEQUE_TENGO)) {
			beanTrueque.verPnlTrueque((Trueque) tengoService.findById(
					Integer.valueOf(notificacion.getReferenceId()),
					Trueque.class));
		}
		if (notificacion.getModulo().equals(Modulo.TRUEQUE_NECESITO)) {
			beanTrueque.verPnlTrueque((Trueque) tengoService.findById(
					Integer.valueOf(notificacion.getReferenceId()),
					Trueque.class));
		}

		if (notificacion.getModulo().equals(Modulo.NOTICIA)) {
			Noticia not = noticiaService.findById(Integer.valueOf(notificacion
					.getReferenceId()));
			beanNoticia.verDetalleNoticia(not);
		}

		if (notificacion.getModulo().equals(Modulo.MENSAJE_TRUEQUE)) {
			beanTrueque.verPnlTrueque((Trueque) tengoService.findById(
					Integer.valueOf(notificacion.getReferenceId()),
					Trueque.class));
		}

		if (notificacion.getModulo().equals(Modulo.PROYECTO)) {
			beanProyecto.verDetalleProyecto2((Proyecto) tengoService.findById(
					Integer.valueOf(notificacion.getReferenceId()),
					Proyecto.class));
		}
		if (notificacion.getModulo().equals(Modulo.FINALIZACION_TRUEQUE)) {
			beanTrueque.verPnlTrueque((Trueque) tengoService.findById(
					Integer.valueOf(notificacion.getReferenceId()),
					Trueque.class));
		}

		if (notificacion.getModulo().equals(Modulo.CANCELACION_TRUEQUE)) {
			beanTrueque.verPnlTrueque((Trueque) tengoService.findById(
					Integer.valueOf(notificacion.getReferenceId()),
					Trueque.class));
		}

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param beanNoticia
	 *            the beanNoticia to set
	 */
	public void setBeanNoticia(BeanNoticia beanNoticia) {
		this.beanNoticia = beanNoticia;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 11/12/2013
	 * @param beanProyecto
	 *            the beanProyecto to set
	 */
	public void setBeanProyecto(BeanProyecto beanProyecto) {
		this.beanProyecto = beanProyecto;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param beanTrueque
	 *            the beanTrueque to set
	 */
	public void setBeanTrueque(BeanTrueque beanTrueque) {
		this.beanTrueque = beanTrueque;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(List<Notificacion> lista) {
		this.lista = lista;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param noticiaService
	 *            the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param notificacionService
	 *            the notificacionService to set
	 */
	public void setNotificacionService(NotificacionService notificacionService) {
		this.notificacionService = notificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param tengoService
	 *            the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
	}
}
