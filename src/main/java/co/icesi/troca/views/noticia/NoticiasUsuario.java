/**
 * 
 */
package co.icesi.troca.views.noticia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.noticia.Noticia;
import co.icesi.troca.services.noticia.NoticiaService;
import co.icesi.troca.views.login.Login;

import com.sun.faces.context.ExternalContextImpl;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class NoticiasUsuario
 * @date 1/12/2013
 * 
 */
@ManagedBean
@ViewScoped
public class NoticiasUsuario extends BaseBean implements Serializable {

	
	
	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * SEVEN
	 */
	private static final int SEVEN = 7;
	private List<Noticia> ultimasNoticias;
	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         noticiaService
	 */
	@ManagedProperty(value = "#{noticiaService}")
	private NoticiaService noticiaService;
	
	@ManagedProperty(value="#{beanNoticia}")
	private BeanNoticia beanNoticia;
	

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ultimasNoticias
	 */
	private List<Noticia> noticias;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         noticia
	 */
	private Noticia noticia = new Noticia();

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         login
	 */
	@ManagedProperty(value = "#{login}")
	private Login login;

	/**
	 * 30/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         file
	 */
	private UploadedFile file;
	/**
	 * 30/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         in
	 */
	private InputStream in;

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 30/11/2013
	 * @param event
	 */
	public void uploadHandlerPhoto1() {
		try {
			in = file.getInputstream();
			noticia.setExtension(detectarExtension(file.getFileName()));
		} catch (IOException e) {
			mensajeError(e.toString());
		}

	}
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @param noticia
	*/
	public void eliminarNoticia(Noticia noticia){
		noticiaService.delete(noticia);
		goTo("/paginas/perfil/perfil.jsf");
	}
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	*/
	public void volverPerfil(){
		goTo("/paginas/perfil/perfil.jsf");
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	* @throws Exception
	*/
	@SuppressWarnings("resource")
	public void uploadPhotoFile() throws Exception {
		ExternalContextImpl request;
		request = (ExternalContextImpl) FacesContext.getCurrentInstance()
				.getExternalContext();

		String path = request.getRealPath("/foto/noticia/");
		OutputStream out = new FileOutputStream(path + "/" + noticia.getId()
				+ noticia.getExtension());

		if (in != null) {
			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1) {
					out.write(b);

				}

			}
		}

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 */
	public void guardarNoticia() {
		String ext = noticia.getExtension();
		noticia.setUsuario(login.getUsuario());
		noticia.setFecha(new Date());
		noticia = noticiaService.save(noticia);
		noticia.setExtension(ext);
		if (in!=null) {
			try {
				uploadPhotoFile();
				noticia.setFotografia( noticia.getId()
				+ noticia.getExtension());
				noticia=noticiaService.save(noticia);
				noticia=new Noticia();
				in=null;
				beanNoticia.init();
				init();
				
			} catch (Exception e) {
				mensajeError(e.toString());
			}
			
			
		}
		
		}
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	*/
	public void cargarNuevaNoticia(){
		noticia=new Noticia();
		init();
		goTo("/paginas/noticia/crear_noticia.jsf");
		
	}
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 1/12/2013
	*/
	public void saveNoticia(){
		guardarNoticia();
		goTo("/paginas/perfil/perfil.jsf#noticias");
		
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the noticiaService
	 */
	public NoticiaService getNoticiaService() {
		return noticiaService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param noticiaService
	 *            the noticiaService to set
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
	 * @param noticias
	 *            the noticias to set
	 */
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the noticia
	 */
	public Noticia getNoticia() {
		return noticia;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param noticia
	 *            the noticia to set
	 */
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 */
	@PostConstruct
	public void init() {
		if (login.getUsuario()!=null) {
			
		noticias = noticiaService
				.findNoticiasByUsuario(login.getUsuario() != null ? login
						.getUsuario() : null);
		}
		ultimasNoticias=noticiaService.findUltimasNoticias(SEVEN);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the ultimasNoticias
	 */
	public List<Noticia> getUltimasNoticias() {
		return ultimasNoticias;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param ultimasNoticias the ultimasNoticias to set
	 */
	public void setUltimasNoticias(List<Noticia> ultimasNoticias) {
		this.ultimasNoticias = ultimasNoticias;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 19/12/2013
	 * @return the beanNoticia
	 */
	public BeanNoticia getBeanNoticia() {
		return beanNoticia;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 19/12/2013
	 * @param beanNoticia the beanNoticia to set
	 */
	public void setBeanNoticia(BeanNoticia beanNoticia) {
		this.beanNoticia = beanNoticia;
	}
}
