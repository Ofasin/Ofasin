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
@Table(name = "municipios", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")
    , @NamedQuery(name = "Municipios.findByIdMunicipio", query = "SELECT m FROM Municipios m WHERE m.idMunicipio = :idMunicipio")
    , @NamedQuery(name = "Municipios.findByCodMunicipio", query = "SELECT m FROM Municipios m WHERE m.codMunicipio = :codMunicipio")
    , @NamedQuery(name = "Municipios.findByDescripMuncc", query = "SELECT m FROM Municipios m WHERE m.descripMuncc = :descripMuncc")})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipios_generator")
    @SequenceGenerator(name="municipios_generator", sequenceName = "sec_municipios", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_municipio")
    private Long idMunicipio;
    @Basic(optional = false)
    @Column(name = "cod_municipio")
    private String codMunicipio;
    @Basic(optional = false)
    @Column(name = "descrip_muncc")
    private String descripMuncc;

    public Municipios() {
    }

    public Municipios(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipios(Long idMunicipio, String codMunicipio, String descripMuncc) {
        this.idMunicipio = idMunicipio;
        this.codMunicipio = codMunicipio;
        this.descripMuncc = descripMuncc;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getDescripMuncc() {
        return descripMuncc;
    }

    public void setDescripMuncc(String descripMuncc) {
        this.descripMuncc = descripMuncc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Municipios[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
