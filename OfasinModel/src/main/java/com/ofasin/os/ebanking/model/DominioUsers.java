/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Heidelber Gonzalez Iguaran
 */
public class DominioUsers extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    
    private Long iduser;
    private String user;
    private String password;
    private Date fechaAcceso;
    private String statusUser;
    private DominioRoll idroll;
    private DominioWayuu idusuario;

    public DominioUsers() {
    }

    public DominioUsers(Long iduser) {
        this.iduser = iduser;
    }

    public DominioUsers(Long iduser, String user, String password, Date fechaAcceso, String statusUser) {
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

    public DominioRoll getIdroll() {
        return idroll;
    }

    public void setIdroll(DominioRoll idroll) {
        this.idroll = idroll;
    }

    public DominioWayuu getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(DominioWayuu idusuario) {
        this.idusuario = idusuario;
    }

  
}
