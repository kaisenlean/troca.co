/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.proyecto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.icesi.troca.model.usuario.Usuario;

/**
 * 
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * owner
	 */
	@ManyToOne
	@JoinColumn(name = "owner",referencedColumnName="id")
	private Usuario owner;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * nombre
	 */
	@Column(name = "nombre")
	private String nombre;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * descripcion
	 */
	@Column(name = "descripcion")
	private String descripcion;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * descripcionLarga
	 */
	@Column(name = "descripcion_larga")
	private String descripcionLarga;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * licencia
	 */
	@Column(name = "licencia")
	private String licencia;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoria
	 */
	@Column(name = "categoria")
	private Integer categoria;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	*/
	public Proyecto() {
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param id
	*/
	public Proyecto(Integer id) {
		this.id = id;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public Integer getId() {
		return id;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param id
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public Usuario getOwner() {
		return owner;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param owner
	*/
	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param nombre
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public String getDescripcion() {
		return descripcion;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param descripcion
	*/
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param descripcionLarga
	*/
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public String getLicencia() {
		return licencia;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param licencia
	*/
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public Integer getCategoria() {
		return categoria;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param categoria
	*/
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Proyecto)) {
			return false;
		}
		Proyecto other = (Proyecto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.Proyecto[ id=" + id + " ]";
	}

}
