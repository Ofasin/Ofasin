/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;

/**
 *
 * @author SergioRios
 */
public class DominioImagenes extends DominioGeneric {
    private long idImage;
    private String url;
    private String name;

    /**
     * @return the idImage
     */
    public long getIdImage() {
        return idImage;
    }

    /**
     * @param idImage the idImage to set
     */
    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
