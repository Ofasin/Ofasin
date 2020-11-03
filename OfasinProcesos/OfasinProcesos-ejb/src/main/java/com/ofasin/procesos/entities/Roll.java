/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "roll", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roll.findAll", query = "SELECT r FROM Roll r")
    , @NamedQuery(name = "Roll.findByIdroll", query = "SELECT r FROM Roll r WHERE r.idroll = :idroll")
    , @NamedQuery(name = "Roll.findByNombre", query = "SELECT r FROM Roll r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Roll.findByDescripcion", query = "SELECT r FROM Roll r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Roll.findByEstado", query = "SELECT r FROM Roll r WHERE r.estado = :estado")})
public class Roll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roll_generator")
    @SequenceGenerator(name="roll_generator", sequenceName = "sec_roll", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idroll")
    private Long idroll;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroll", fetch = FetchType.LAZY)
    private List<Permisos> permisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroll", fetch = FetchType.LAZY)
    private List<Users> usersList;

    public Roll() {
    }

    public Roll(Long idroll) {
        this.idroll = idroll;
    }

    public Roll(Long idroll, String nombre, short estado) {
        this.idroll = idroll;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdroll() {
        return idroll;
    }

    public void setIdroll(Long idroll) {
        this.idroll = idroll;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroll != null ? idroll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roll)) {
            return false;
        }
        Roll other = (Roll) object;
        if ((this.idroll == null && other.idroll != null) || (this.idroll != null && !this.idroll.equals(other.idroll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Roll[ idroll=" + idroll + " ]";
    }
    
}
