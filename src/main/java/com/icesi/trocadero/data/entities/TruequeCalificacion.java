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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Entity
@Table(name = "trueque_calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TruequeCalificacion.findAll", query = "SELECT t FROM TruequeCalificacion t"),
    @NamedQuery(name = "TruequeCalificacion.findById", query = "SELECT t FROM TruequeCalificacion t WHERE t.id = :id"),
    @NamedQuery(name = "TruequeCalificacion.findByPuntajeText", query = "SELECT t FROM TruequeCalificacion t WHERE t.puntajeText = :puntajeText"),
    @NamedQuery(name = "TruequeCalificacion.findByTrueque", query = "SELECT t FROM TruequeCalificacion t WHERE t.trueque = :trueque"),
    @NamedQuery(name = "TruequeCalificacion.findByPuntajeVal", query = "SELECT t FROM TruequeCalificacion t WHERE t.puntajeVal = :puntajeVal"),
    @NamedQuery(name = "TruequeCalificacion.findByUsuario", query = "SELECT t FROM TruequeCalificacion t WHERE t.usuario = :usuario")})
public class TruequeCalificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "puntaje_text")
    private String puntajeText;
    @Column(name = "trueque")
    private Integer trueque;
    @Column(name = "puntaje_val")
    private Integer puntajeVal;
    @Column(name = "usuario")
    private Integer usuario;

    public TruequeCalificacion() {
    }

    public TruequeCalificacion(Integer id) {
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

    public Integer getTrueque() {
        return trueque;
    }

    public void setTrueque(Integer trueque) {
        this.trueque = trueque;
    }

    public Integer getPuntajeVal() {
        return puntajeVal;
    }

    public void setPuntajeVal(Integer puntajeVal) {
        this.puntajeVal = puntajeVal;
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
        if (!(object instanceof TruequeCalificacion)) {
            return false;
        }
        TruequeCalificacion other = (TruequeCalificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icesi.trocadero.data.entities.TruequeCalificacion[ id=" + id + " ]";
    }

}
