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

public class DominioMenu extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    
    private Long idmenu;
    private long menuid;
    private int nivel;
    private int orden;
    private String nombre;
    private String url;
    private String icono;
    private short estado;
    private List<DominioPermisos> permisosList;

    public DominioMenu() {
    }

    public DominioMenu(Long idmenu) {
        this.idmenu = idmenu;
    }

    public DominioMenu(Long idmenu, long menuid, int nivel, int orden, String nombre, String url, short estado) {
        this.idmenu = idmenu;
        this.menuid = menuid;
        this.nivel = nivel;
        this.orden = orden;
        this.nombre = nombre;
        this.url = url;
        this.estado = estado;
    }

    public Long getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Long idmenu) {
        this.idmenu = idmenu;
    }

    public long getMenuid() {
        return menuid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
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

   
    
}
