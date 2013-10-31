/**
 * 
 */
package co.icesi.troca.views.noticia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.services.noticia.NoticiaService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class BeanNoticia
 * @date 31/10/2013
 *
 */
@ManagedBean(eager=true)
@ViewScoped
public class BeanNoticia implements Serializable {

	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{noticiaService}")
	private NoticiaService noticiaService;
	
	private List<Noticia> ultimasNoticias ;
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@PostConstruct
	public void init(){
		
		ultimasNoticias=noticiaService.findUltimasNoticias();
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

}
