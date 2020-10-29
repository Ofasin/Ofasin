/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Heidelber Gonzalez
 */

public class DominioAsociacion extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    
    private Long idasocicion;
    private BigInteger idmunicipio;
    private String nombre;
    private String telefono;
    private String direccion;
    private String barrio;
    private List<DominioLuma> lumaList;

    public DominioAsociacion() {
    }

    public DominioAsociacion(Long idasocicion) {
        this.idasocicion = idasocicion;
    }

    public Long getIdasocicion() {
        return idasocicion;
    }

    public void setIdasocicion(Long idasocicion) {
        this.idasocicion = idasocicion;
    }

    public BigInteger getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(BigInteger idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    
    public List<DominioLuma> getLumaList() {
        return lumaList;
    }

    public void setLumaList(List<DominioLuma> lumaList) {
        this.lumaList = lumaList;
    }

    
    
}
