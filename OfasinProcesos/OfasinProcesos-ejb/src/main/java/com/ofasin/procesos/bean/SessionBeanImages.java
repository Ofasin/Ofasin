/**
 * Todos los Derechos Reservados © 2021 Wayuu - Soft .
 * Sistema InvGuajira.
 * Este software contiene información propiedad exclusiva de Wayuu - Soft considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionBeanImages.java
 * Fecha de creacion : Octubre, 2020
 * @author : HeidelberGonzalezIguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/
package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.business.ImagenesIface;
import com.ofasin.os.ebanking.model.DominioImagenes;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;

@Stateless(name = "ActaNacimientotfr")
public class SessionBeanImages implements ImagenesIface {
    @PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;

    public List<DominioImagenes>  setImages() {
        int cont = 1;
        List<DominioImagenes> images = new ArrayList<>();
        DominioImagenes img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("cat.jpg");
        img.setName("CAT");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("google.jpg");
        img.setName("Google");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("logo_citi.png");
        img.setName("Citi");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("logo_imss.jpg");
        img.setName("IMSS");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("logo_sagarpa.jpg");
        img.setName("SAGARPA");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("logo_sfp.jpg");
        img.setName("SFP");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("pemex.jpg");
        img.setName("PEMEX");
        images.add(img);
        img = new DominioImagenes();
        img.setIdImage(cont++);
        img.setUrl("pfizer.jpg");
        img.setName("pFizer");
        images.add(img);
        return images;
    }
    
    @Override
    public List<DominioImagenes> getAllImages() {
     /* try {
            Query query = em.createNamedQuery("DominioImagenes.findAll");
            List<com.hpapg.sistema.entities.DominioImagenes> lista = query.getResultList();
            if(lista.size() > 0) {
                List<DominioImagenes> imagenes = new ArrayList<>();
                for(com.hpapg.sistema.entities.DominioImagenes img: lista) {
                    DominioImagenes imagen = new DominioImagenes();
                    imagen.setIdImage(img.getIdImage());
                    imagen.setName(img.getName());
                    imagen.setUrl(img.getUrl());
                    imagenes.add(imagen);
                }
                return imagenes;
            } else {
                List<DominioImagenes> imagenes = new ArrayList<>();
                return imagenes;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        */
         try {
            
            Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.Imagenes.class);
                
           // Query query = em.createNamedQuery("DominioImagenes.findAll");
            
            List<com.ofasin.procesos.entities.Imagenes> lista = criteria.list();
            if(lista.size() > 0) {
                List<DominioImagenes> imagenes = new ArrayList<>();
                lista.stream().map((img) -> {
                    DominioImagenes imagen = new DominioImagenes();
                    imagen.setIdImage(img.getIdimagen());
                    imagen.setName(" : "+img.getName());
                    imagen.setUrl(img.getUrl());
                    return imagen;
                }).forEachOrdered((imagen) -> {
                    imagenes.add(imagen);
                });
                return imagenes;
            } else {
                List<DominioImagenes> imagenes = new ArrayList<>();
                return imagenes;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
     
    }

    @Override
    public void addImage(DominioImagenes imagen) {
        com.ofasin.procesos.entities.Imagenes img = new com.ofasin.procesos.entities.Imagenes();
        img.setName(imagen.getName());
        img.setUrl(imagen.getUrl());
        em.persist(img);
    }

    @Override
    public void deleteImage(DominioImagenes imagen) {
        com.ofasin.procesos.entities.Imagenes img = getImageByNombre(imagen);
        if(img != null) {
            em.remove(img);
        }
    }
    
    private com.ofasin.procesos.entities.Imagenes getImageByNombre(DominioImagenes imagen) {
        try {
            Query query = em.createNamedQuery("Imagenes.findByName");
            query.setParameter("name", imagen.getName());
            List<com.ofasin.procesos.entities.Imagenes> lista = query.getResultList();
            if(lista.size() > 0) {
                com.ofasin.procesos.entities.Imagenes img = lista.get(0);
                return img;
            } else {
                return null;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /* @Override
    public DominioUsers validarLogin(DominioUsers obj) {
         obj.setStatus(true);
                obj.setMsg("Provando haber. . .");
            return obj;
    }*/

}
