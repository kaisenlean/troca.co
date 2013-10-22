/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.trueque;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "trueque_mensaje")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "TruequeMensaje.findAll", query = "SELECT t FROM TruequeMensaje t"),
		@NamedQuery(name = "TruequeMensaje.findById", query = "SELECT t FROM TruequeMensaje t WHERE t.id = :id"),
		@NamedQuery(name = "TruequeMensaje.findByTrueque", query = "SELECT t FROM TruequeMensaje t WHERE t.trueque = :trueque"),
		@NamedQuery(name = "TruequeMensaje.findByUsuarioEmisor", query = "SELECT t FROM TruequeMensaje t WHERE t.usuarioEmisor = :usuarioEmisor"),
		@NamedQuery(name = "TruequeMensaje.findByUsuarioReceptor", query = "SELECT t FROM TruequeMensaje t WHERE t.usuarioReceptor = :usuarioReceptor"),
		@NamedQuery(name = "TruequeMensaje.findByMensaje", query = "SELECT t FROM TruequeMensaje t WHERE t.mensaje = :mensaje") })
public class TruequeMensaje implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "trueque")
	private Integer trueque;
	@Column(name = "usuario_emisor")
	private Integer usuarioEmisor;
	@Column(name = "usuario_receptor")
	private Integer usuarioReceptor;
	@Column(name = "mensaje")
	private String mensaje;

	public TruequeMensaje() {
	}

	public TruequeMensaje(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTrueque() {
		return trueque;
	}

	public void setTrueque(Integer trueque) {
		this.trueque = trueque;
	}

	public Integer getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(Integer usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public Integer getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(Integer usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TruequeMensaje)) {
			return false;
		}
		TruequeMensaje other = (TruequeMensaje) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.TruequeMensaje[ id=" + id
				+ " ]";
	}

}
