/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.troca;

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
@Table(name = "ususario_recomendacion")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "UsusarioRecomendacion.findAll", query = "SELECT u FROM UsusarioRecomendacion u"),
		@NamedQuery(name = "UsusarioRecomendacion.findById", query = "SELECT u FROM UsusarioRecomendacion u WHERE u.id = :id"),
		@NamedQuery(name = "UsusarioRecomendacion.findByUsuario", query = "SELECT u FROM UsusarioRecomendacion u WHERE u.usuario = :usuario"),
		@NamedQuery(name = "UsusarioRecomendacion.findByUsuarioRecomienda", query = "SELECT u FROM UsusarioRecomendacion u WHERE u.usuarioRecomienda = :usuarioRecomienda"),
		@NamedQuery(name = "UsusarioRecomendacion.findByObservacion", query = "SELECT u FROM UsusarioRecomendacion u WHERE u.observacion = :observacion") })
public class UsusarioRecomendacion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "usuario")
	private Integer usuario;
	@Column(name = "usuario_recomienda")
	private Integer usuarioRecomienda;
	@Column(name = "observacion")
	private String observacion;

	public UsusarioRecomendacion() {
	}

	public UsusarioRecomendacion(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioRecomienda() {
		return usuarioRecomienda;
	}

	public void setUsuarioRecomienda(Integer usuarioRecomienda) {
		this.usuarioRecomienda = usuarioRecomienda;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
		if (!(object instanceof UsusarioRecomendacion)) {
			return false;
		}
		UsusarioRecomendacion other = (UsusarioRecomendacion) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.UsusarioRecomendacion[ id="
				+ id + " ]";
	}

}
