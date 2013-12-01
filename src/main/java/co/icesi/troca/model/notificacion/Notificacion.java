package co.icesi.troca.model.notificacion;

import co.icesi.troca.model.usuario.Usuario;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class Notificacion
* @date 1/12/2013
*
 */
@Entity
@Table(name="notificacion")
public class Notificacion implements Serializable {

	   
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String mensaje;
	
	@Column(name="reference_id")
	private String referenceId;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Modulo modulo;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="creador")
	private Usuario creador;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	
	private static final long serialVersionUID = 1L;

	public Notificacion() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}   
	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}   
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}   
	public Usuario getCreador() {
		return this.creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}   
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
   
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
