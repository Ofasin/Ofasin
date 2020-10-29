/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

public class DominioRoll extends DominioGeneric {

    private static final long serialVersionUID = 1L;
   
    private Long idroll;
    private String nombre;
    private String descripcion;
    private short estado;
    private List<DominioPermisos> permisosList;
    private List<DominioUsers> usersList;

    public DominioRoll() {
    }

    public DominioRoll(Long idroll) {
        this.idroll = idroll;
    }

    public DominioRoll(Long idroll, String nombre, short estado) {
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

  
    public List<DominioPermisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<DominioPermisos> permisosList) {
        this.permisosList = permisosList;
    }

    
    public List<DominioUsers> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<DominioUsers> usersList) {
        this.usersList = usersList;
    }

   
    
}
