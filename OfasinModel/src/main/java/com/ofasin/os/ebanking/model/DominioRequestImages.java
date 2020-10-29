/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;

/**
 *
 * @author JavaRevolutions
 */
public class DominioRequestImages implements Serializable {
    private String id;
    private String tipoImagen;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the tipoImagen
     */
    public String getTipoImagen() {
        return tipoImagen;
    }

    /**
     * @param tipoImagen the tipoImagen to set
     */
    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }
}
