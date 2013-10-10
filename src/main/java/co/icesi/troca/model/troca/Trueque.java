/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.icesi.troca.model.troca;

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
@Table(name = "trueque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trueque.findAll", query = "SELECT t FROM Trueque t"),
    @NamedQuery(name = "Trueque.findById", query = "SELECT t FROM Trueque t WHERE t.id = :id"),
    @NamedQuery(name = "Trueque.findByUsuarioTrueque1", query = "SELECT t FROM Trueque t WHERE t.usuarioTrueque1 = :usuarioTrueque1"),
    @NamedQuery(name = "Trueque.findByUsuarioTrueque2", query = "SELECT t FROM Trueque t WHERE t.usuarioTrueque2 = :usuarioTrueque2"),
    @NamedQuery(name = "Trueque.findByEstado", query = "SELECT t FROM Trueque t WHERE t.estado = :estado")})
public class Trueque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "usuario_trueque_1")
    private Integer usuarioTrueque1;
    @Column(name = "usuario_trueque_2")
    private Integer usuarioTrueque2;
    @Column(name = "estado")
    private String estado;

    public Trueque() {
    }

    public Trueque(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioTrueque1() {
        return usuarioTrueque1;
    }

    public void setUsuarioTrueque1(Integer usuarioTrueque1) {
        this.usuarioTrueque1 = usuarioTrueque1;
    }

    public Integer getUsuarioTrueque2() {
        return usuarioTrueque2;
    }

    public void setUsuarioTrueque2(Integer usuarioTrueque2) {
        this.usuarioTrueque2 = usuarioTrueque2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Trueque)) {
            return false;
        }
        Trueque other = (Trueque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.Trueque[ id=" + id + " ]";
    }

}
