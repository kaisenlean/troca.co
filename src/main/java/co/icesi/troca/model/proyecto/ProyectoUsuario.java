/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.proyecto;

import java.io.Serializable;

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
@Table(name = "proyecto_usuario")
public class ProyectoUsuario implements Serializable {
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
	@Column(name = "id")
	private Integer id;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyecto
	 */
	@ManyToOne
	@JoinColumn(name = "proyecto")
	private Proyecto proyecto;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * usuario
	 */
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	*/
	public ProyectoUsuario() {
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param id
	*/
	public ProyectoUsuario(Integer id) {
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
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param proyecto
	*/
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param usuario
	*/
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		if (!(object instanceof ProyectoUsuario)) {
			return false;
		}
		ProyectoUsuario other = (ProyectoUsuario) object;
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
		return "com.icesi.trocadero.data.entities.ProyectoUsuario[ id=" + id
				+ " ]";
	}

}
