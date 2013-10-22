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
@Table(name = "noticia_comentario")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "NoticiaComentario.findAll", query = "SELECT n FROM NoticiaComentario n"),
		@NamedQuery(name = "NoticiaComentario.findById", query = "SELECT n FROM NoticiaComentario n WHERE n.id = :id"),
		@NamedQuery(name = "NoticiaComentario.findByNoticia", query = "SELECT n FROM NoticiaComentario n WHERE n.noticia = :noticia"),
		@NamedQuery(name = "NoticiaComentario.findByUsuario", query = "SELECT n FROM NoticiaComentario n WHERE n.usuario = :usuario"),
		@NamedQuery(name = "NoticiaComentario.findByComentario", query = "SELECT n FROM NoticiaComentario n WHERE n.comentario = :comentario") })
public class NoticiaComentario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "noticia")
	private Integer noticia;
	@Column(name = "usuario")
	private Integer usuario;
	@Column(name = "comentario")
	private String comentario;

	public NoticiaComentario() {
	}

	public NoticiaComentario(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNoticia() {
		return noticia;
	}

	public void setNoticia(Integer noticia) {
		this.noticia = noticia;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.NoticiaComentario[ id=" + id
				+ " ]";
	}

}
