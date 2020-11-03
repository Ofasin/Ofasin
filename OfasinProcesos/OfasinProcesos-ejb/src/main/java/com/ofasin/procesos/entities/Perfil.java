/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "perfil", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdperfil", query = "SELECT p FROM Perfil p WHERE p.idperfil = :idperfil")
    , @NamedQuery(name = "Perfil.findByDescrpperfil", query = "SELECT p FROM Perfil p WHERE p.descrpperfil = :descrpperfil")
    , @NamedQuery(name = "Perfil.findByFecradica", query = "SELECT p FROM Perfil p WHERE p.fecradica = :fecradica")
    , @NamedQuery(name = "Perfil.findByContratista", query = "SELECT p FROM Perfil p WHERE p.contratista = :contratista")
    , @NamedQuery(name = "Perfil.findByTechopresp", query = "SELECT p FROM Perfil p WHERE p.techopresp = :techopresp")
    , @NamedQuery(name = "Perfil.findByMonto", query = "SELECT p FROM Perfil p WHERE p.monto = :monto")
    , @NamedQuery(name = "Perfil.findByVigencia", query = "SELECT p FROM Perfil p WHERE p.vigencia = :vigencia")
    , @NamedQuery(name = "Perfil.findByObs", query = "SELECT p FROM Perfil p WHERE p.obs = :obs")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_generator")
    @SequenceGenerator(name="perfil_generator", sequenceName = "sec_perfil", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperfil")
    private Long idperfil;
    @Column(name = "descrpperfil")
    private String descrpperfil;
    @Column(name = "fecradica")
    @Temporal(TemporalType.DATE)
    private Date fecradica;
    @Column(name = "contratista")
    private String contratista;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "techopresp")
    private BigDecimal techopresp;
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "vigencia")
    @Temporal(TemporalType.DATE)
    private Date vigencia;
    @Column(name = "obs")
    private String obs;
    @OneToMany(mappedBy = "idperfil", fetch = FetchType.LAZY)
    private List<Presupuesto> presupuestoList;
    @JoinColumn(name = "idluma", referencedColumnName = "idluma")
    @ManyToOne(fetch = FetchType.LAZY)
    private Luma idluma;

    public Perfil() {
    }

    public Perfil(Long idperfil) {
        this.idperfil = idperfil;
    }

    public Long getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Long idperfil) {
        this.idperfil = idperfil;
    }

    public String getDescrpperfil() {
        return descrpperfil;
    }

    public void setDescrpperfil(String descrpperfil) {
        this.descrpperfil = descrpperfil;
    }

    public Date getFecradica() {
        return fecradica;
    }

    public void setFecradica(Date fecradica) {
        this.fecradica = fecradica;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public BigDecimal getTechopresp() {
        return techopresp;
    }

    public void setTechopresp(BigDecimal techopresp) {
        this.techopresp = techopresp;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    public Luma getIdluma() {
        return idluma;
    }

    public void setIdluma(Luma idluma) {
        this.idluma = idluma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
