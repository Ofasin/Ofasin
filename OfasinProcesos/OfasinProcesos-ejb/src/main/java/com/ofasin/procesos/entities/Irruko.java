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
@Table(name = "irruko", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Irruko.findAll", query = "SELECT i FROM Irruko i")
    , @NamedQuery(name = "Irruko.findByIdirruko", query = "SELECT i FROM Irruko i WHERE i.idirruko = :idirruko")
    , @NamedQuery(name = "Irruko.findByDescrp", query = "SELECT i FROM Irruko i WHERE i.descrp = :descrp")})
public class Irruko implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "irruko_generator")
    @SequenceGenerator(name="irruko_generator", sequenceName = "sec_irruko", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idirruko")
    private Long idirruko;
    @Column(name = "descrp")
    private String descrp;
    @OneToMany(mappedBy = "irruko", fetch = FetchType.LAZY)
    private List<Wayuu> wayuuList;

    public Irruko() {
    }

    public Irruko(Long idirruko) {
        this.idirruko = idirruko;
    }

    public Long getIdirruko() {
        return idirruko;
    }

    public void setIdirruko(Long idirruko) {
        this.idirruko = idirruko;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
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
        hash += (idirruko != null ? idirruko.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Irruko)) {
            return false;
        }
        Irruko other = (Irruko) object;
        if ((this.idirruko == null && other.idirruko != null) || (this.idirruko != null && !this.idirruko.equals(other.idirruko))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Irruko[ idirruko=" + idirruko + " ]";
    }
    
}
