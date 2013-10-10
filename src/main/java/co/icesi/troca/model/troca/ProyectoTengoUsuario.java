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
@Table(name = "proyecto_tengo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoTengoUsuario.findAll", query = "SELECT p FROM ProyectoTengoUsuario p"),
    @NamedQuery(name = "ProyectoTengoUsuario.findById", query = "SELECT p FROM ProyectoTengoUsuario p WHERE p.id = :id"),
    @NamedQuery(name = "ProyectoTengoUsuario.findByTengo", query = "SELECT p FROM ProyectoTengoUsuario p WHERE p.tengo = :tengo"),
    @NamedQuery(name = "ProyectoTengoUsuario.findByProyecto", query = "SELECT p FROM ProyectoTengoUsuario p WHERE p.proyecto = :proyecto")})
public class ProyectoTengoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tengo")
    private Integer tengo;
    @Column(name = "proyecto")
    private Integer proyecto;

    public ProyectoTengoUsuario() {
    }

    public ProyectoTengoUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTengo() {
        return tengo;
    }

    public void setTengo(Integer tengo) {
        this.tengo = tengo;
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
        if (!(object instanceof ProyectoTengoUsuario)) {
            return false;
        }
        ProyectoTengoUsuario other = (ProyectoTengoUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.ProyectoTengoUsuario[ id=" + id + " ]";
    }

}
