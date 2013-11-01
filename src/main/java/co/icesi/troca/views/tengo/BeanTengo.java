/**
 * 
 */
package co.icesi.troca.views.tengo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.tengo.EstadoTengo;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.tengo.TipoTengo;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.views.login.Login;

/**
 * Bean que controla el registro de los tengos del usuario
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanTengo
 * @date 31/10/2013
 *
 */
@ManagedBean
@ViewScoped
public class BeanTengo extends BaseBean implements Serializable {

	/**
	 * 1/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * MAX_RESULTS
	 */
	private static final int MAX_RESULTS = 2;

	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{login}")
	private Login login;
	
	private Tengo tengo;
	
	private String tipoTengo;
	
	private List<Tengo> ultimosTengos;
	
	@PostConstruct
	public void init(){
		tengo=new Tengo();
		ultimosTengos=tengoService.findUltimosTengo(MAX_RESULTS);
	}
	
	@ManagedProperty( value="#{tengoService}")
	private TengoService tengoService;
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	public void crearTengo(){
		tengo.setTipo(TipoTengo.valueOf(tipoTengo));
		tengo.setEstado(EstadoTengo.ACTIVO);
		tengo.setOwner(login.getUsuario());
		tengo.setFechaRegistro(new Date());
		tengoService.save(tengo);
		runJavascript("pnlCon.hide();");

	}
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	public void crearTengoYPrepararOtro(){
		tengo.setTipo(TipoTengo.valueOf(tipoTengo));
		tengo.setEstado(EstadoTengo.ACTIVO);
		tengo.setOwner(login.getUsuario());
		tengo.setFechaRegistro(new Date());
		tengoService.save(tengo);
		tengo=new Tengo();
		
		
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return the tengo
	 */
	public Tengo getTengo() {
		return tengo;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengo the tengo to set
	 */
	public void setTengo(Tengo tengo) {
		this.tengo = tengo;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengoService the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return the tipoTengo
	 */
	public String getTipoTengo() {
		return tipoTengo;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tipoTengo the tipoTengo to set
	 */
	public void setTipoTengo(String tipoTengo) {
		this.tipoTengo = tipoTengo;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @return the ultimosTengos
	 */
	public List<Tengo> getUltimosTengos() {
		return ultimosTengos;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @param ultimosTengos the ultimosTengos to set
	 */
	public void setUltimosTengos(List<Tengo> ultimosTengos) {
		this.ultimosTengos = ultimosTengos;
	}
	
}
