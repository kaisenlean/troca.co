/**
 * 
 */
package co.icesi.troca.views.trueque;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.trueque.EstadoTruequeEnum;
import co.icesi.troca.model.trueque.Trueque;
import co.icesi.troca.model.trueque.TruequeMensaje;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.views.login.Login;
import co.icesi.troca.views.perfil.PerfilDe;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanTrueque
 * @date 2/12/2013
 *
 */
@ManagedBean
@SessionScoped
public class BeanTrueque implements Serializable {

	/**
	 * 2/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idTengo;
	
	private String mensaje;
	
	private String textOtro;
	
	
	private Trueque trueque= new Trueque();
	
	
	@ManagedProperty(value="#{login}")
	private Login login;
	
	@ManagedProperty(value="#{tengoService}")
	private TengoService tengoService;
	
	@ManagedProperty(value="#{perfilDe}")
	private PerfilDe perfilDe;
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 2/12/2013
	*/
	public void RealizarTrueque(){
		
		trueque=new Trueque();
		trueque.setEstado(EstadoTruequeEnum.ACTIVO);
		trueque.setUsuarioTrueque1(login.getUsuario());
		trueque.setUsuarioTrueque2(perfilDe.getUsuario());
		if (idTengo==0) {
			Tengo tenTemp =new Tengo();
			tenTemp.setNombre(textOtro);
			tenTemp.setFechaRegistro(new Date());
			
	
		}
		
		
	}
	
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the idTengo
	 */
	public int getIdTengo() {
		return idTengo;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param idTengo the idTengo to set
	 */
	public void setIdTengo(int idTengo) {
		this.idTengo = idTengo;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the trueque
	 */
	public Trueque getTrueque() {
		return trueque;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param trueque the trueque to set
	 */
	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/12/2013
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @return the login
 */
public Login getLogin() {
	return login;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @param login the login to set
 */
public void setLogin(Login login) {
	this.login = login;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @param perfilDe the perfilDe to set
 */
public void setPerfilDe(PerfilDe perfilDe) {
	this.perfilDe = perfilDe;
}
/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @return the perfilDe
 */
public PerfilDe getPerfilDe() {
	return perfilDe;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @return the textOtro
 */
public String getTextOtro() {
	return textOtro;
}

/**
 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/12/2013
 * @param textOtro the textOtro to set
 */
public void setTextOtro(String textOtro) {
	this.textOtro = textOtro;
}


}
