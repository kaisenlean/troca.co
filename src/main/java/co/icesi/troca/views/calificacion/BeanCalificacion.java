/**
 * 
 */
package co.icesi.troca.views.calificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.Calificacion;
import co.icesi.troca.services.calificacion.CalificacionService;
import co.icesi.troca.views.login.Login;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanCalificacion
 * @date 9/12/2013
 * 
 */
@ManagedBean
@ViewScoped
public class BeanCalificacion extends BaseBean implements Serializable {

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
	 *         login
	 */
	@ManagedProperty(value = "#{login}")
	private Login login;

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         calificacionService
	 */
	@ManagedProperty(value = "#{calificacionService}")
	private CalificacionService calificacionService;

	private String promedio;

	/**
	 * 9/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         calificaciones
	 */
	private List<Calificacion> calificaciones = new ArrayList<Calificacion>();

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
	 * @return the promedio
	 */
	public String getPromedio() {
		return promedio;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 */
	@PostConstruct
	public void init() {
		calificaciones = calificacionService.findCalificacionByUsuario(login
				.getUsuario());
		calificaciones
				.addAll(calificacionService
						.findCalificacionByTruequeCanceladoByUsuario(login
								.getUsuario()));
		double promTemp = 0.0;
		for (Calificacion cf : calificaciones) {
			promTemp += cf.getPuntajeVal().doubleValue();
		}
		if (!calificaciones.isEmpty()) {

			promTemp /= calificaciones.size();
		}
		promedio = String.valueOf(promTemp);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param calificaciones
	 *            the calificaciones to set
	 */
	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param calificacionService
	 *            the calificacionService to set
	 */
	public void setCalificacionService(CalificacionService calificacionService) {
		this.calificacionService = calificacionService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param promedio
	 *            the promedio to set
	 */
	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

}
