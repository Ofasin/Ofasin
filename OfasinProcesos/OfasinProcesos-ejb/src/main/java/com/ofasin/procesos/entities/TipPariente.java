/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "tip_pariente", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipPariente.findAll", query = "SELECT t FROM TipPariente t")
    , @NamedQuery(name = "TipPariente.findByIdtippariente", query = "SELECT t FROM TipPariente t WHERE t.idtippariente = :idtippariente")
    , @NamedQuery(name = "TipPariente.findByDescrptppariente", query = "SELECT t FROM TipPariente t WHERE t.descrptppariente = :descrptppariente")})
public class TipPariente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tippariente_generator")
    @SequenceGenerator(name="tippariente_generator", sequenceName = "sec_tippariente", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtippariente")
    private Long idtippariente;
    @Basic(optional = false)
    @Column(name = "descrptppariente")
    private String descrptppariente;
    @OneToMany(mappedBy = "parentesco")
    private List<Wayuu> wayuuList;

    public TipPariente() {
    }

    public TipPariente(Long idtippariente) {
        this.idtippariente = idtippariente;
    }

    public TipPariente(Long idtippariente, String descrptppariente) {
        this.idtippariente = idtippariente;
        this.descrptppariente = descrptppariente;
    }

    public Long getIdtippariente() {
        return idtippariente;
    }

    public void setIdtippariente(Long idtippariente) {
        this.idtippariente = idtippariente;
    }

    public String getDescrptppariente() {
        return descrptppariente;
    }

    public void setDescrptppariente(String descrptppariente) {
        this.descrptppariente = descrptppariente;
    }

    @XmlTransient
    public List<Wayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<Wayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtippariente != null ? idtippariente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipPariente)) {
            return false;
        }
        TipPariente other = (TipPariente) object;
        if ((this.idtippariente == null && other.idtippariente != null) || (this.idtippariente != null && !this.idtippariente.equals(other.idtippariente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipPariente[ idtippariente=" + idtippariente + " ]";
    }
    
}
