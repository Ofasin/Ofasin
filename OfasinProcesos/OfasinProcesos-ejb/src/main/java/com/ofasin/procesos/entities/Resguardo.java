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
@Table(name = "resguardo", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resguardo.findAll", query = "SELECT r FROM Resguardo r")
    , @NamedQuery(name = "Resguardo.findByIdresguardo", query = "SELECT r FROM Resguardo r WHERE r.idresguardo = :idresguardo")
    , @NamedQuery(name = "Resguardo.findByDescrip", query = "SELECT r FROM Resguardo r WHERE r.descrip = :descrip")})
public class Resguardo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resguardo_generator")
    @SequenceGenerator(name="resguardo_generator", sequenceName = "sec_resguardo", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idresguardo")
    private Long idresguardo;
    @Basic(optional = false)
    @Column(name = "descrip")
    private long descrip;
    @OneToMany(mappedBy = "idresguardo")
    private List<Luma> lumaList;

    public Resguardo() {
    }

    public Resguardo(Long idresguardo) {
        this.idresguardo = idresguardo;
    }

    public Resguardo(Long idresguardo, long descrip) {
        this.idresguardo = idresguardo;
        this.descrip = descrip;
    }

    public Long getIdresguardo() {
        return idresguardo;
    }

    public void setIdresguardo(Long idresguardo) {
        this.idresguardo = idresguardo;
    }

    public long getDescrip() {
        return descrip;
    }

    public void setDescrip(long descrip) {
        this.descrip = descrip;
    }

    @XmlTransient
    public List<Luma> getLumaList() {
        return lumaList;
    }

    public void setLumaList(List<Luma> lumaList) {
        this.lumaList = lumaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresguardo != null ? idresguardo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resguardo)) {
            return false;
        }
        Resguardo other = (Resguardo) object;
        if ((this.idresguardo == null && other.idresguardo != null) || (this.idresguardo != null && !this.idresguardo.equals(other.idresguardo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Resguardo[ idresguardo=" + idresguardo + " ]";
    }
    
}
