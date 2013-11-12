/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.noticia;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "noticia_comentario")
public class NoticiaComentario implements Serializable {
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
	 * noticia
	 */
	@Column(name = "noticia")
	private Integer noticia;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * usuario
	 */
	@Column(name = "usuario")
	private Integer usuario;
	/**
	 * 12/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * comentario
	 */
	@Column(name = "comentario")
	private String comentario;

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	*/
	public NoticiaComentario() {
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param id
	*/
	public NoticiaComentario(Integer id) {
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
	public Integer getNoticia() {
		return noticia;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param noticia
	*/
	public void setNoticia(Integer noticia) {
		this.noticia = noticia;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public Integer getUsuario() {
		return usuario;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param usuario
	*/
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @return
	*/
	public String getComentario() {
		return comentario;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/11/2013
	* @param comentario
	*/
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		if (!(object instanceof NoticiaComentario)) {
			return false;
		}
		NoticiaComentario other = (NoticiaComentario) object;
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
		return "com.icesi.trocadero.data.entities.NoticiaComentario[ id=" + id
				+ " ]";
	}

}
