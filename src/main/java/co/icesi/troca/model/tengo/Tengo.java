/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.tengo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import co.icesi.troca.model.Categoria;
import co.icesi.troca.model.usuario.Usuario;

/**
 * 
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "tengo")
public class Tengo implements Serializable {
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         owner
	 */
	@ManyToOne
	@JoinColumn(name = "owner", referencedColumnName = "id")
	private Usuario owner;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         descripcion
	 */
	@Column(name = "descripcion")
	private String descripcion;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         estado
	 */
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private EstadoTengo estado;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         nombre
	 */
	@Column(name = "nombre")
	private String nombre;
	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         categoria
	 */
	@JoinColumn(name = "categoria")
	private Categoria categoria;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         tipo
	 */
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoTengo tipo;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         foto
	 */
	@Column(name = "foto")
	private String foto;

	/**
	 * 12/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         fechaRegistro
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	/**
	 * 24/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         seleccionado
	 */
	@Transient
	private boolean seleccionado;

	/**
	 * 1/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         extension
	 */
	@Transient
	private String extension;
	
	
	@Transient
	private String mensaje;
	
	@Transient
	private int idTengo;

	/**
	 * 7/01/2014
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * textoOtro
	 */
	@Transient
	private String textoOtro;
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 */
	public Tengo() {
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param id
	 */
	public Tengo(Integer id) {
		this.id = id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return
	 */
	public Categoria getCategoria() {
		return categoria;
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
	 * @return
	 */
	public EstadoTengo getEstado() {
		return estado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @return the fechaRegistro
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return the foto
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return
	 */
	public String getFoto() {
		return foto;
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
	public String getNombre() {
		return nombre;
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
	 * @date 31/10/2013
	 * @return the tipo
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @return
	 */
	public TipoTengo getTipo() {
		return tipo;
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
	 * @date 24/11/2013
	 * @return the seleccionado
	 */
	public boolean isSeleccionado() {
		return seleccionado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	 * @param estado
	 */
	public void setEstado(EstadoTengo estado) {
		this.estado = estado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/12/2013
	 * @param extension
	 *            the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param fechaRegistro
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param foto
	 *            the foto to set
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
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
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @date 24/11/2013
	 * @param seleccionado
	 *            the seleccionado to set
	 */
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tipo
	 *            the tipo to set
	 */
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 12/11/2013
	 * @param tipo
	 */
	public void setTipo(TipoTengo tipo) {
		this.tipo = tipo;
	}

	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/01/2014
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	 /**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/01/2014
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/01/2014
	 * @return the idTengo
	 */
	public int getIdTengo() {
		return idTengo;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/01/2014
	 * @return the textoOtro
	 */
	public String getTextoOtro() {
		return textoOtro;
	}
	
	
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 7/01/2014
	 * @param textoOtro the textoOtro to set
	 */
	public void setTextoOtro(String textoOtro) {
		this.textoOtro = textoOtro;
	}
	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/01/2014
	 * @param idTengo the idTengo to set
	 */
	public void setIdTengo(int idTengo) {
		this.idTengo = idTengo;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "com.icesi.trocadero.data.entities.Tengo[ id=" + id + " ]";
	}

}
