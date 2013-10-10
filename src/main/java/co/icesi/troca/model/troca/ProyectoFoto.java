/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.troca;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "proyecto_foto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoFoto.findAll", query = "SELECT p FROM ProyectoFoto p"),
    @NamedQuery(name = "ProyectoFoto.findById", query = "SELECT p FROM ProyectoFoto p WHERE p.id = :id"),
    @NamedQuery(name = "ProyectoFoto.findByFotografia", query = "SELECT p FROM ProyectoFoto p WHERE p.fotografia = :fotografia"),
    @NamedQuery(name = "ProyectoFoto.findByProyecto", query = "SELECT p FROM ProyectoFoto p WHERE p.proyecto = :proyecto")})
public class ProyectoFoto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fotografia")
    private String fotografia;
    @Column(name = "proyecto")
    private Integer proyecto;

    public ProyectoFoto() {
    }

    public ProyectoFoto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
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
        if (!(object instanceof ProyectoFoto)) {
            return false;
        }
        ProyectoFoto other = (ProyectoFoto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.ProyectoFoto[ id=" + id + " ]";
    }

}
