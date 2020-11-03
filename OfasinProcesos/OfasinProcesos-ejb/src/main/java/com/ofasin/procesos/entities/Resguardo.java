/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion Perfiles.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: Resguardo.java
 * Fecha de creacion : Noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

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
 * @author Heidelber Gonzalez Iguaran
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
    private String descrip;
    @OneToMany(mappedBy = "idresguardo", fetch = FetchType.LAZY)
    private List<Luma> lumaList;

    public Resguardo() {
    }

    public Resguardo(Long idresguardo) {
        this.idresguardo = idresguardo;
    }

    public Resguardo(Long idresguardo, String descrip) {
        this.idresguardo = idresguardo;
        this.descrip = descrip;
    }

    public Long getIdresguardo() {
        return idresguardo;
    }

    public void setIdresguardo(Long idresguardo) {
        this.idresguardo = idresguardo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
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
        return "com.ofasin.procesos.entities.Resguardo[ idresguardo=" + idresguardo + " ]";
    }
    
}
