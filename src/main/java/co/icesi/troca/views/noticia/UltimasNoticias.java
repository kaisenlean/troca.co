/**
 * 
 */
package co.icesi.troca.views.noticia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.services.noticia.NoticiaService;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UltimasNoticias
 * @date 1/12/2013
 *
 */
@ManagedBean
@RequestScoped
public class UltimasNoticias extends BaseBean implements Serializable {

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
	
	
	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * noticiaService
	 */
	@ManagedProperty(value="#{noticiaService}")
	private NoticiaService noticiaService;
	
	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * noticias
	 */
	private List<Noticia> noticias;
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	*/
	@PostConstruct
	public void init(){
		
		noticias=noticiaService.findUltimasNoticias(MAX_RESULTS);
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param noticiaService the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the noticias
	 */
	public List<Noticia> getNoticias() {
		return noticias;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param noticias the noticias to set
	 */
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
