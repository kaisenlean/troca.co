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
@Table(name = "proyecto_tengo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoTengo.findAll", query = "SELECT p FROM ProyectoTengo p"),
    @NamedQuery(name = "ProyectoTengo.findById", query = "SELECT p FROM ProyectoTengo p WHERE p.id = :id"),
    @NamedQuery(name = "ProyectoTengo.findByNombre", query = "SELECT p FROM ProyectoTengo p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProyectoTengo.findByProyecto", query = "SELECT p FROM ProyectoTengo p WHERE p.proyecto = :proyecto"),
    @NamedQuery(name = "ProyectoTengo.findByDescripcion", query = "SELECT p FROM ProyectoTengo p WHERE p.descripcion = :descripcion")})
public class ProyectoTengo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "proyecto")
    private Integer proyecto;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public ProyectoTengo() {
    }

    public ProyectoTengo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getProyecto() {
        return proyecto;
    }

    public void setProyecto(Integer proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof ProyectoTengo)) {
            return false;
        }
        ProyectoTengo other = (ProyectoTengo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.ProyectoTengo[ id=" + id + " ]";
    }

}
