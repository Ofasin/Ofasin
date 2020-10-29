/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.business.ImagenesIface;
import com.ofasin.os.ebanking.model.DominioImagenes;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HeidelberGonzalezIguran
 */
public class BeanWelcome implements Serializable {
    private DominioImagenes imagen;
    private ImagenesIface service;
    private List<DominioImagenes> images;
    
    /**
     * @return the imagen
     */
    public DominioImagenes getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(DominioImagenes imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the service
     */
    public ImagenesIface getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(ImagenesIface service) {
        this.service = service;
    }

    /**
     * @return the images
     */
    public List<DominioImagenes> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<DominioImagenes> images) {
        this.images = images;
    }
    
    public void getAllImages() {
        setImages(service.getAllImages());
       System.out.println("# Size Images: "+getImages().size());
    }
    
    public void addImagen() {
        service.addImage(getImagen());
        System.out.println("############## Add Image success. . ."+getImagen().getName());
    }
    
    public void deleteImagen() {
        service.deleteImage(getImagen());
        System.out.println("##### Delete Image success. . ."+getImagen().getName());
    }
}
