/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "tip_profesion", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipProfesion.findAll", query = "SELECT t FROM TipProfesion t")
    , @NamedQuery(name = "TipProfesion.findByIdtipprofesion", query = "SELECT t FROM TipProfesion t WHERE t.idtipprofesion = :idtipprofesion")
    , @NamedQuery(name = "TipProfesion.findByDescrpprofesion", query = "SELECT t FROM TipProfesion t WHERE t.descrpprofesion = :descrpprofesion")
    , @NamedQuery(name = "TipProfesion.findByFecdia", query = "SELECT t FROM TipProfesion t WHERE t.fecdia = :fecdia")})
public class TipProfesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipprofesion_generator")
    @SequenceGenerator(name="tipprofesion_generator", sequenceName = "sec_tipprofesion", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipprofesion")
    private Long idtipprofesion;
    @Basic(optional = false)
    @Column(name = "descrpprofesion")
    private String descrpprofesion;
    @Column(name = "fecdia")
    @Temporal(TemporalType.DATE)
    private Date fecdia;
    @OneToMany(mappedBy = "profesion")
    private List<Wayuu> wayuuList;

    public TipProfesion() {
    }

    public TipProfesion(Long idtipprofesion) {
        this.idtipprofesion = idtipprofesion;
    }

    public TipProfesion(Long idtipprofesion, String descrpprofesion) {
        this.idtipprofesion = idtipprofesion;
        this.descrpprofesion = descrpprofesion;
    }

    public Long getIdtipprofesion() {
        return idtipprofesion;
    }

    public void setIdtipprofesion(Long idtipprofesion) {
        this.idtipprofesion = idtipprofesion;
    }

    public String getDescrpprofesion() {
        return descrpprofesion;
    }

    public void setDescrpprofesion(String descrpprofesion) {
        this.descrpprofesion = descrpprofesion;
    }

    public Date getFecdia() {
        return fecdia;
    }

    public void setFecdia(Date fecdia) {
        this.fecdia = fecdia;
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
        hash += (idtipprofesion != null ? idtipprofesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipProfesion)) {
            return false;
        }
        TipProfesion other = (TipProfesion) object;
        if ((this.idtipprofesion == null && other.idtipprofesion != null) || (this.idtipprofesion != null && !this.idtipprofesion.equals(other.idtipprofesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipProfesion[ idtipprofesion=" + idtipprofesion + " ]";
    }
    
}
