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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "presupuesto", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p")
    , @NamedQuery(name = "Presupuesto.findByIdpresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.idpresupuesto = :idpresupuesto")
    , @NamedQuery(name = "Presupuesto.findByObs", query = "SELECT p FROM Presupuesto p WHERE p.obs = :obs")})
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpresupuesto")
    private Long idpresupuesto;
    @Column(name = "obs")
    private String obs;
    @OneToMany(mappedBy = "idpresupuesto", fetch = FetchType.LAZY)
    private List<Presupuestodetll> presupuestodetllList;
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil idperfil;
    @JoinColumn(name = "idsector", referencedColumnName = "idsector")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sector idsector;

    public Presupuesto() {
    }

    public Presupuesto(Long idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public Long getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(Long idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @XmlTransient
    public List<Presupuestodetll> getPresupuestodetllList() {
        return presupuestodetllList;
    }

    public void setPresupuestodetllList(List<Presupuestodetll> presupuestodetllList) {
        this.presupuestodetllList = presupuestodetllList;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    public Sector getIdsector() {
        return idsector;
    }

    public void setIdsector(Sector idsector) {
        this.idsector = idsector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpresupuesto != null ? idpresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idpresupuesto == null && other.idpresupuesto != null) || (this.idpresupuesto != null && !this.idpresupuesto.equals(other.idpresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Presupuesto[ idpresupuesto=" + idpresupuesto + " ]";
    }
    
}
