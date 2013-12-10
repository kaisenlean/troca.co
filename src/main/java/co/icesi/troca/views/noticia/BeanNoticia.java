/**
 * 
 */
package co.icesi.troca.views.noticia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.model.noticia.NoticiaComentario;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.services.noticia.comentario.NoticiaComentarioService;
import co.icesi.troca.services.notificacion.NotificacionService;
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
	
	
	
	@ManagedProperty(value="#{noticiaComentarioService}")
	private NoticiaComentarioService noticiaComentarioService;
	
	/**
	 * 9/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * comentarios
	 */
	private List<NoticiaComentario> comentarios=new ArrayList<NoticiaComentario>();
	
	
	@ManagedProperty(value="#{notificacionService}")
	private NotificacionService notificacionService;
	
	private String comentar;
	
	
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
		comentarios=noticiaComentarioService.findComentariosByNoticia(noticia);
		goTo("/paginas/noticia/vista_noticia.jsf");
		
	}
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	*/
	public void agregarComentario(){
		NoticiaComentario nc=new NoticiaComentario();
		nc.setFecha(Calendar.getInstance().getTime());
		nc.setNoticia(noticia);
		nc.setComentario(comentar);
		nc.setUsuario(login.getUsuario());
		nc=noticiaComentarioService.save(nc);
		comentarios=noticiaComentarioService.findComentariosByNoticia(noticia);
		notificacionService.crearNotificacionComentarioNoticia(nc);
		comentar="";
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
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the comentarios
	 */
	public List<NoticiaComentario> getComentarios() {
		return comentarios;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<NoticiaComentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param noticiaComentarioService the noticiaComentarioService to set
	 */
	public void setNoticiaComentarioService(
			NoticiaComentarioService noticiaComentarioService) {
		this.noticiaComentarioService = noticiaComentarioService;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @return the comentar
	 */
	public String getComentar() {
		return comentar;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param comentar the comentar to set
	 */
	public void setComentar(String comentar) {
		this.comentar = comentar;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 9/12/2013
	 * @param notificacionService the notificacionService to set
	 */
	public void setNotificacionService(NotificacionService notificacionService) {
		this.notificacionService = notificacionService;
	}
}
