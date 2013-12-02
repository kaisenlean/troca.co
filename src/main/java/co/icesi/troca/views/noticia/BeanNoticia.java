/**
 * 
 */
package co.icesi.troca.views.noticia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.views.login.Login;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanNoticia
 * @date 31/10/2013
 *
 */
@ManagedBean
@SessionScoped
public class BeanNoticia extends BaseBean implements Serializable {

	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * noticiaService
	 */
	@ManagedProperty(value="#{noticiaService}")
	private NoticiaService noticiaService;
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * ultimasNoticias
	 */
	private List<Noticia> ultimasNoticias ;
	
	
	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * ultimasNoticias2
	 */
	private List<Noticia> ultimasNoticias2 ;

	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * noticia
	 */
	private Noticia noticia;
	
	
	
	
	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * login
	 */
	@ManagedProperty(value="#{login}")
	private Login login;
	
	
	
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@PostConstruct
	public void init(){
		noticia=new Noticia();
		ultimasNoticias=noticiaService.findUltimasNoticias();
		ultimasNoticias2=noticiaService.findUltimasNoticias(7);

	}
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	*/
	public void verDetalleNoticia(Noticia noticia){
		this.noticia=noticia;
		goTo("/paginas/noticia/vista_noticia.jsf");
		
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param noticiaService the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return the ultimasNoticias
	 */
	public List<Noticia> getUltimasNoticias() {
		return ultimasNoticias;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param ultimasNoticias the ultimasNoticias to set
	 */
	public void setUltimasNoticias(List<Noticia> ultimasNoticias) {
		this.ultimasNoticias = ultimasNoticias;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @return the noticia
	 */
	public Noticia getNoticia() {
		return noticia;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param noticia the noticia to set
	 */
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 24/11/2013
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the ultimasNoticias2
	 */
	public List<Noticia> getUltimasNoticias2() {
		return ultimasNoticias2;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param ultimasNoticias2 the ultimasNoticias2 to set
	 */
	public void setUltimasNoticias2(List<Noticia> ultimasNoticias2) {
		this.ultimasNoticias2 = ultimasNoticias2;
	}
}
