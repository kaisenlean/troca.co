/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.tengo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tengo_foto")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "TengoFoto.findAll", query = "SELECT t FROM TengoFoto t"),
		@NamedQuery(name = "TengoFoto.findById", query = "SELECT t FROM TengoFoto t WHERE t.id = :id"),
		@NamedQuery(name = "TengoFoto.findByFotografia", query = "SELECT t FROM TengoFoto t WHERE t.fotografia = :fotografia"),
		@NamedQuery(name = "TengoFoto.findByEstado", query = "SELECT t FROM TengoFoto t WHERE t.estado = :estado"),
		@NamedQuery(name = "TengoFoto.findByTengo", query = "SELECT t FROM TengoFoto t WHERE t.tengo = :tengo") })
public class TengoFoto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "fotografia")
	private String fotografia;
	@Column(name = "estado")
	private String estado;
	@Column(name = "tengo")
	private Integer tengo;

	public TengoFoto() {
	}

	public TengoFoto(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getTengo() {
		return tengo;
	}

	public void setTengo(Integer tengo) {
		this.tengo = tengo;
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
		if (!(object instanceof TengoFoto)) {
			return false;
		}
		TengoFoto other = (TengoFoto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.TengoFoto[ id=" + id + " ]";
	}

}
