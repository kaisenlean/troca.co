package co.icesi.troca.model.notificacion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.icesi.troca.model.usuario.Usuario;

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
	
	/**
	 * 18/12/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * estado
	 */
	@Enumerated(EnumType.STRING)
	private EstadoNotificacion estado;
	
	
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
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 18/12/2013
	 * @return the estado
	 */
	public EstadoNotificacion getEstado() {
		return estado;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 18/12/2013
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoNotificacion estado) {
		this.estado = estado;
	}
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 9/12/2013
	* @return
	*/
	public String getMensajeCompleto(){
		
		return extraerMensaje();
	
	}
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 23/12/2013
	*/
	private String extraerMensaje() {
		if (modulo.equals(Modulo.PROYECTO)) {
			return new StringBuilder(creador.getNombreCompleto()).append(mensaje).toString();
		}
		
		if (modulo.equals(Modulo.TRUEQUE_TENGO)) {
			return new StringBuilder("Nueva propuesta de Trueque por ").append(creador.getNombreCompleto()).toString();
		}
		
		if (modulo.equals(Modulo.MENSAJE_TRUEQUE)) {
			return new StringBuilder("Nueva respuesta en tu trueque con ").append(creador.getNombreCompleto()).toString();
		}
		
		if (modulo.equals(Modulo.TRUEQUE_NECESITO)) {
			return new StringBuilder("Nueva  propuesta de Trueque por ").append(creador==null?"":creador.getNombreCompleto()).toString();
		}
		return mensaje==null?"NO message Detail":mensaje;
	}
}
