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
@Table(name = "trueque_tengo")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "TruequeTengo.findAll", query = "SELECT t FROM TruequeTengo t"),
		@NamedQuery(name = "TruequeTengo.findById", query = "SELECT t FROM TruequeTengo t WHERE t.id = :id"),
		@NamedQuery(name = "TruequeTengo.findByTengo", query = "SELECT t FROM TruequeTengo t WHERE t.tengo = :tengo"),
		@NamedQuery(name = "TruequeTengo.findByTrueque", query = "SELECT t FROM TruequeTengo t WHERE t.trueque = :trueque") })
public class TruequeTengo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "tengo")
	private Integer tengo;
	@Column(name = "trueque")
	private Integer trueque;

	public TruequeTengo() {
	}

	public TruequeTengo(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTengo() {
		return tengo;
	}

	public void setTengo(Integer tengo) {
		this.tengo = tengo;
	}

	public Integer getTrueque() {
		return trueque;
	}

	public void setTrueque(Integer trueque) {
		this.trueque = trueque;
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
		if (!(object instanceof TruequeTengo)) {
			return false;
		}
		TruequeTengo other = (TruequeTengo) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.TruequeTengo[ id=" + id
				+ " ]";
	}

}
