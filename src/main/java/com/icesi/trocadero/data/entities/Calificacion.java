/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icesi.trocadero.data.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c"),
    @NamedQuery(name = "Calificacion.findById", query = "SELECT c FROM Calificacion c WHERE c.id = :id"),
    @NamedQuery(name = "Calificacion.findByPuntajeText", query = "SELECT c FROM Calificacion c WHERE c.puntajeText = :puntajeText"),
    @NamedQuery(name = "Calificacion.findByUsuario", query = "SELECT c FROM Calificacion c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Calificacion.findByUsuarioRegistro", query = "SELECT c FROM Calificacion c WHERE c.usuarioRegistro = :usuarioRegistro")})
public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "puntaje_text")
    private String puntajeText;
    @Lob
    @Size(max = 16777215)
    @Column(name = "puntaje_val")
    private String puntajeVal;
    @Column(name = "usuario")
    private Integer usuario;
    @Column(name = "usuario_registro")
    private Integer usuarioRegistro;

    public Calificacion() {
    }

    public Calificacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuntajeText() {
        return puntajeText;
    }

    public void setPuntajeText(String puntajeText) {
        this.puntajeText = puntajeText;
    }

    public String getPuntajeVal() {
        return puntajeVal;
    }

    public void setPuntajeVal(String puntajeVal) {
        this.puntajeVal = puntajeVal;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Integer usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.Calificacion[ id=" + id + " ]";
    }

}
