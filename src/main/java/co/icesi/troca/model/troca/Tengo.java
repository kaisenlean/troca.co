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
@Table(name = "tengo")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Tengo.findAll", query = "SELECT t FROM Tengo t"),
		@NamedQuery(name = "Tengo.findById", query = "SELECT t FROM Tengo t WHERE t.id = :id"),
		@NamedQuery(name = "Tengo.findByOwner", query = "SELECT t FROM Tengo t WHERE t.owner = :owner"),
		@NamedQuery(name = "Tengo.findByDescripcion", query = "SELECT t FROM Tengo t WHERE t.descripcion = :descripcion"),
		@NamedQuery(name = "Tengo.findByEstado", query = "SELECT t FROM Tengo t WHERE t.estado = :estado"),
		@NamedQuery(name = "Tengo.findByNombre", query = "SELECT t FROM Tengo t WHERE t.nombre = :nombre"),
		@NamedQuery(name = "Tengo.findByCategoria", query = "SELECT t FROM Tengo t WHERE t.categoria = :categoria") })
public class Tengo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "owner")
	private Integer owner;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "estado")
	private String estado;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "categoria")
	private Integer categoria;

	public Tengo() {
	}

	public Tengo(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
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
		if (!(object instanceof Tengo)) {
			return false;
		}
		Tengo other = (Tengo) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.Tengo[ id=" + id + " ]";
	}

}
