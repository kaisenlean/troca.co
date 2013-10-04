/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icesi.trocadero.data.entities;

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
@Table(name = "proyecto_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoUsuario.findAll", query = "SELECT p FROM ProyectoUsuario p"),
    @NamedQuery(name = "ProyectoUsuario.findById", query = "SELECT p FROM ProyectoUsuario p WHERE p.id = :id"),
    @NamedQuery(name = "ProyectoUsuario.findByProyecto", query = "SELECT p FROM ProyectoUsuario p WHERE p.proyecto = :proyecto"),
    @NamedQuery(name = "ProyectoUsuario.findByUsuario", query = "SELECT p FROM ProyectoUsuario p WHERE p.usuario = :usuario")})
public class ProyectoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "proyecto")
    private Integer proyecto;
    @Column(name = "usuario")
    private Integer usuario;

    public ProyectoUsuario() {
    }

    public ProyectoUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProyecto() {
        return proyecto;
    }

    public void setProyecto(Integer proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof ProyectoUsuario)) {
            return false;
        }
        ProyectoUsuario other = (ProyectoUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.ProyectoUsuario[ id=" + id + " ]";
    }

}
