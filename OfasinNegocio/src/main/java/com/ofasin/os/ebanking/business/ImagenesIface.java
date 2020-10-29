/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioImagenes;
import java.util.List;
import javax.ejb.Remote;
/**
 *
 * @author SergioRios
 */
@Remote
public interface ImagenesIface {
    List<DominioImagenes> getAllImages();
    void addImage(DominioImagenes imagen);
    void deleteImage(DominioImagenes imagen);
}
