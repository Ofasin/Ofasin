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
@Table(name = "sector", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
    , @NamedQuery(name = "Sector.findByIdsector", query = "SELECT s FROM Sector s WHERE s.idsector = :idsector")
    , @NamedQuery(name = "Sector.findByDescrp", query = "SELECT s FROM Sector s WHERE s.descrp = :descrp")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sector_generator")
    @SequenceGenerator(name="sector_generator", sequenceName = "sec_sector", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsector")
    private Long idsector;
    @Column(name = "descrp")
    private String descrp;
    @OneToMany(mappedBy = "idsector", fetch = FetchType.LAZY)
    private List<Presupuesto> presupuestoList;

    public Sector() {
    }

    public Sector(Long idsector) {
        this.idsector = idsector;
    }

    public Long getIdsector() {
        return idsector;
    }

    public void setIdsector(Long idsector) {
        this.idsector = idsector;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsector != null ? idsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idsector == null && other.idsector != null) || (this.idsector != null && !this.idsector.equals(other.idsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Sector[ idsector=" + idsector + " ]";
    }
    
}
