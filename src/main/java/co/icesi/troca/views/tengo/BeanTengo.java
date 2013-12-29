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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import co.icesi.troca.commons.BaseBean;
import co.icesi.troca.model.tengo.EstadoTengo;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.tengo.TipoTengo;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.views.login.Login;

import com.sun.faces.context.ExternalContextImpl;

/**
 * Bean que controla el registro de los tengos del usuario
 * 
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
	 * 11/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         MAX_RESULTS_2
	 */
	private static final int MAX_RESULTS_2 = 15;

	/**
	 * 1/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         MAX_RESULTS
	 */
	private static final int MAX_RESULTS = 2;

	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         login
	 */
	@ManagedProperty(value = "#{login}")
	private Login login;

	/**
	 * 28/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         editarTengo
	 */
	@ManagedProperty(value = "#{editarTengo}")
	private EditarTengo editarTengo;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         tengo
	 */
	private Tengo tengo;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         tipoTengo
	 */
	private String tipoTengo;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ultimosTengos
	 */
	private List<Tengo> ultimosTengos;

	/**
	 * 11/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         ultimosTengos2
	 */
	private List<Tengo> ultimosTengos2;

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         in
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
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         tengoService
	 */
	@ManagedProperty(value = "#{tengoService}")
	private TengoService tengoService;

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	public void crearTengo() {
		tengo.setTipo(TipoTengo.valueOf(tipoTengo));
		tengo.setEstado(EstadoTengo.ACTIVO);
		tengo.setOwner(login.getUsuario());
		tengo.setFechaRegistro(new Date());
		String ext = tengo.getExtension();
		tengo = tengoService.save(tengo);
		tengo.setExtension(ext);
		if (in != null) {
			try {

				uploadPhotoFile();
			} catch (Exception e) {
				mensajeError(e.toString());
			}
			tengo.setFoto(tengo.getId() + tengo.getExtension());
			tengo = tengoService.save(tengo);
		}
		runJavascript("pnlCon.close();");
		login.reloadTengosProyectos();
		goTo("/paginas/perfil/perfil.jsf");
	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	public void crearTengoYPrepararOtro() {
		tengo.setTipo(TipoTengo.valueOf(tipoTengo));
		tengo.setEstado(EstadoTengo.ACTIVO);
		tengo.setOwner(login.getUsuario());
		tengo.setFechaRegistro(new Date());
		String ext = tengo.getExtension();
		tengo = tengoService.save(tengo);
		tengo.setExtension(ext);
		if (in != null) {
			try {

				uploadPhotoFile();
			} catch (Exception e) {
				mensajeError(e.toString());
			}
			tengo.setFoto(tengo.getId() + tengo.getExtension());
			tengo = tengoService.save(tengo);
		}
		tengo = new Tengo();
		login.reloadTengosProyectos();

	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 */
	public void editarTengo(Tengo tengo) {

		this.tengo = tengo;
		this.tipoTengo = tengo.getTipo().name();
		editarTengo.setTengo(tengo);
		editarTengo.setTipoTengo(tengo.getTipo().name());
		goTo("/paginas/tengo/edit.jsf");
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 */
	public void eliminarTengo(Tengo tengo) {
		tengoService.delete(tengo);
		login.getUsuario().getTengos().remove(tengo);
		login.reloadTengosProyectos();
		goTo("/paginas/perfil/perfil.jsf");
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
	 * @date 31/10/2013
	 * @return the tengo
	 */
	public Tengo getTengo() {
		return tengo;
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
	 * @date 1/11/2013
	 * @return the ultimosTengos
	 */
	public List<Tengo> getUltimosTengos() {
		return ultimosTengos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 11/12/2013
	 * @return the ultimosTengos2
	 */
	public List<Tengo> getUltimosTengos2() {
		return ultimosTengos2;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 */
	public void goToCreate() {
		tengo = new Tengo();
		in = null;
		goTo("/paginas/tengo/crear_tengo.jsf");

	}

	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 */
	@PostConstruct
	public void init() {
		tengo = new Tengo();
		ultimosTengos = tengoService.findUltimosTengo(MAX_RESULTS);
		ultimosTengos2 = tengoService.findUltimosTengo(MAX_RESULTS_2);
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 28/11/2013
	 * @param editarTengo
	 *            the editarTengo to set
	 */
	public void setEditarTengo(EditarTengo editarTengo) {
		this.editarTengo = editarTengo;
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
	 * @date 31/10/2013
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengo
	 *            the tengo to set
	 */
	public void setTengo(Tengo tengo) {
		this.tengo = tengo;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengoService
	 *            the tengoService to set
	 */
	public void setTengoService(TengoService tengoService) {
		this.tengoService = tengoService;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tipoTengo
	 *            the tipoTengo to set
	 */
	public void setTipoTengo(String tipoTengo) {
		this.tipoTengo = tipoTengo;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @param ultimosTengos
	 *            the ultimosTengos to set
	 */
	public void setUltimosTengos(List<Tengo> ultimosTengos) {
		this.ultimosTengos = ultimosTengos;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 11/12/2013
	 * @param ultimosTengos2
	 *            the ultimosTengos2 to set
	 */
	public void setUltimosTengos2(List<Tengo> ultimosTengos2) {
		this.ultimosTengos2 = ultimosTengos2;
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
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @throws Exception
	 */
	public void uploadPhotoFile() {
		ExternalContextImpl request;
		request = (ExternalContextImpl) FacesContext.getCurrentInstance()
				.getExternalContext();

		String path = request.getRealPath("/foto/tengo/");
		OutputStream out;
		try {
			out = new FileOutputStream(path + "/" + tengo.getId()
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
		} catch (Exception e) {
			mensajeError(e.toString());
		}
	}
}
