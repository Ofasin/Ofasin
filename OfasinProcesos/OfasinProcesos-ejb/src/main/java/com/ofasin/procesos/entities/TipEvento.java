/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "tip_evento", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipEvento.findAll", query = "SELECT t FROM TipEvento t")
    , @NamedQuery(name = "TipEvento.findByIdtipevento", query = "SELECT t FROM TipEvento t WHERE t.idtipevento = :idtipevento")
    , @NamedQuery(name = "TipEvento.findByDescrptipevento", query = "SELECT t FROM TipEvento t WHERE t.descrptipevento = :descrptipevento")})
public class TipEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipevento_generator")
    @SequenceGenerator(name="tipevento_generator", sequenceName = "sec_tipevento", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipevento")
    private Long idtipevento;
    @Basic(optional = false)
    @Column(name = "descrptipevento")
    private String descrptipevento;

    public TipEvento() {
    }

    public TipEvento(Long idtipevento) {
        this.idtipevento = idtipevento;
    }

    public TipEvento(Long idtipevento, String descrptipevento) {
        this.idtipevento = idtipevento;
        this.descrptipevento = descrptipevento;
    }

    public Long getIdtipevento() {
        return idtipevento;
    }

    public void setIdtipevento(Long idtipevento) {
        this.idtipevento = idtipevento;
    }

    public String getDescrptipevento() {
        return descrptipevento;
    }

    public void setDescrptipevento(String descrptipevento) {
        this.descrptipevento = descrptipevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipevento != null ? idtipevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipEvento)) {
            return false;
        }
        TipEvento other = (TipEvento) object;
        if ((this.idtipevento == null && other.idtipevento != null) || (this.idtipevento != null && !this.idtipevento.equals(other.idtipevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipEvento[ idtipevento=" + idtipevento + " ]";
    }
    
}
