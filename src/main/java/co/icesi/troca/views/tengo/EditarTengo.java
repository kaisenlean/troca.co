/**
 * 
 */
package co.icesi.troca.views.tengo;

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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import com.sun.faces.context.ExternalContextImpl;

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
@SessionScoped
public class EditarTengo extends BaseBean implements Serializable {


	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * login
	 */
	@ManagedProperty(value="#{login}")
	private Login login;
	
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * tengo
	 */
	private Tengo tengo=new Tengo();
	
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * tipoTengo
	 */
	private String tipoTengo;
	
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * ultimosTengos
	 */
	private List<Tengo> ultimosTengos;

	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	 */
	@PostConstruct
	public void init(){
		tengo=new Tengo();
	}
	
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * tengoService
	 */
	@ManagedProperty( value="#{tengoService}")
	private TengoService tengoService;
	
	
	
	
	
	
	/**
	 * 1/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * in
	 */
	private InputStream in;
	
	
	
	/**
	 * 30/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         file
	 */
	private UploadedFile file;
	
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

		String path = request.getRealPath("/foto/tengo/");
		OutputStream out = new FileOutputStream(path + "/" + tengo.getId()
				+ tengo.getExtension());

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
	 * @date 30/11/2013
	 * @param event
	 */
	public void uploadHandlerPhoto1() {
		try {
			in = file.getInputstream();
			tengo.setExtension(detectarExtension(file.getFileName()));
		} catch (IOException e) {
			mensajeError(e.toString());
		}

	}
	
	
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
		String ext= tengo.getExtension();
		tengo=tengoService.save(tengo);
		tengo.setExtension(ext);
		if (in!=null) {
			try {
				uploadPhotoFile();
				tengo.setFoto(tengo.getId()+tengo.getExtension());
				tengo=tengoService.save(tengo);
			} catch (Exception e) {
				mensajeError(e.toString());
			}
		}
		login.reloadTengosProyectos();
		
		goTo("/paginas/perfil/perfil.jsf");
		
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
		login.reloadTengosProyectos();
		
		
	}
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 28/11/2013
	*/
	public void eliminarTengo(Tengo tengo){
		tengoService.delete(tengo);
		login.getUsuario().getTengos().remove(tengo);
		login.reloadTengosProyectos();
		goTo("/paginas/perfil/perfil.jsf");
	}
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 28/11/2013
	*/
	public void editarTengo(Tengo tengo){
		
		this.tengo=tengo;
		this.tipoTengo=tengo.getTipo().name();
		goTo("/paginas/tengo/edit.jsf");
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
	 * @param file the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
