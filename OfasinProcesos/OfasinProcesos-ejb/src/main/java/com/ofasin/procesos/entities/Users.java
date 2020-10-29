/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "users", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIduser", query = "SELECT u FROM Users u WHERE u.iduser = :iduser")
    , @NamedQuery(name = "Users.findByUser", query = "SELECT u FROM Users u WHERE u.user = :user")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByFechaAcceso", query = "SELECT u FROM Users u WHERE u.fechaAcceso = :fechaAcceso")
    , @NamedQuery(name = "Users.findByStatusUser", query = "SELECT u FROM Users u WHERE u.statusUser = :statusUser")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
    @SequenceGenerator(name="users_generator", sequenceName = "sec_users", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "iduser")
    private Long iduser;
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "fecha_acceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcceso;
    @Basic(optional = false)
    @Column(name = "status_user")
    private String statusUser;
    @JoinColumn(name = "idroll", referencedColumnName = "idroll")
    @ManyToOne(optional = false)
    private Roll idroll;
    @JoinColumn(name = "idusuario", referencedColumnName = "idwayuu")
    @ManyToOne(optional = false)
    private Wayuu idusuario;

    public Users() {
    }

    public Users(Long iduser) {
        this.iduser = iduser;
    }

    public Users(Long iduser, String user, String password, Date fechaAcceso, String statusUser) {
        this.iduser = iduser;
        this.user = user;
        this.password = password;
        this.fechaAcceso = fechaAcceso;
        this.statusUser = statusUser;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    public Roll getIdroll() {
        return idroll;
    }

    public void setIdroll(Roll idroll) {
        this.idroll = idroll;
    }

    public Wayuu getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Wayuu idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Users[ iduser=" + iduser + " ]";
    }
    
}
