/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.proyecto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "proyecto_foto")
public class ProyectoFoto implements Serializable {
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         id
	 */
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         fotografia
	 */
	@Column(name = "fotografia")
	private String fotografia;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         proyecto
	 */
	@Column(name = "proyecto")
	private Integer proyecto;

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 */
	public ProyectoFoto() {
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param id
	 */
	public ProyectoFoto(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProyectoFoto)) {
			return false;
		}
		ProyectoFoto other = (ProyectoFoto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return
	 */
	public String getFotografia() {
		return fotografia;
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
	 * @return
	 */
	public Integer getProyecto() {
		return proyecto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param fotografia
	 */
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
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
	 * @param proyecto
	 */
	public void setProyecto(Integer proyecto) {
		this.proyecto = proyecto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.ProyectoFoto[ id=" + id
				+ " ]";
	}

}
