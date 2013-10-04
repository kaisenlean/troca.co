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
@Table(name = "proyecto_video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoVideo.findAll", query = "SELECT p FROM ProyectoVideo p"),
    @NamedQuery(name = "ProyectoVideo.findById", query = "SELECT p FROM ProyectoVideo p WHERE p.id = :id"),
    @NamedQuery(name = "ProyectoVideo.findByVideo", query = "SELECT p FROM ProyectoVideo p WHERE p.video = :video"),
    @NamedQuery(name = "ProyectoVideo.findByProyecto", query = "SELECT p FROM ProyectoVideo p WHERE p.proyecto = :proyecto")})
public class ProyectoVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "video")
    private String video;
    @Column(name = "proyecto")
    private Integer proyecto;

    public ProyectoVideo() {
    }

    public ProyectoVideo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getProyecto() {
        return proyecto;
    }

    public void setProyecto(Integer proyecto) {
        this.proyecto = proyecto;
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
        if (!(object instanceof ProyectoVideo)) {
            return false;
        }
        ProyectoVideo other = (ProyectoVideo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.ProyectoVideo[ id=" + id + " ]";
    }

}
