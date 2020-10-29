/**
 * Todos los Derechos Reservados © 2020 Wayuu - Soft .
 * Sistema Agora.
 * Este software contiene información propiedad exclusiva de Wayuu - Soft considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionBeanTipProfesion.java
 * Fecha de creacion : Octubre, 2020
 * @author : HeidelberGonzalezIguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/


package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioTipProfesion;
import com.ofasin.procesos.entities.TipProfesion;
import com.ofasin.os.ebanking.business.TipProfesionIface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Stateless(name = "ejbTipProfesion")
public class SessionBeanTipProfesion implements TipProfesionIface{
   
    @PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;

    @Override
    public List<DominioTipProfesion> getAll() throws Exception {
       List<TipProfesion> entityTipProfesion = new ArrayList<>();
        List<DominioTipProfesion> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(TipProfesion.class);
                entityTipProfesion= criteria.list();
                int cont = 1;
                if(entityTipProfesion.size()>0){
                    for(TipProfesion obj: entityTipProfesion) {            
                    DominioTipProfesion dominio = new DominioTipProfesion();
                    dominio.setIdtipprofesion(obj.getIdtipprofesion());
                    dominio.setDescrpprofesion(obj.getDescrpprofesion());
                    dominio.setCont(cont++);
                    listaDominio.add(dominio);
                    }
                }
                
             return listaDominio; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DominioTipProfesion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
         List<TipProfesion> entityTipProfesion = new ArrayList<>();
        List<DominioTipProfesion> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(TipProfesion.class);
            criteria.setFirstResult(first)
            .setMaxResults(pageSize);
            Map<String, Object> filtrs = filters;
            String key="";
            String vlr="";
            
            if (!filtrs.isEmpty()) {
                
                Iterator it = filtrs.entrySet().iterator(); 
                while (it.hasNext()) { 
                    Map.Entry e = (Map.Entry)it.next(); 
                    key=(String) e.getKey();
                    vlr=(String) e.getValue();
                    if (vlr instanceof String) {
			criteria.add(Restrictions.ilike(key,  vlr, MatchMode.ANYWHERE));
                    } else {
			criteria.add(Restrictions.eq(key, vlr));
                    }
                    
                } 
            }
            criteria.addOrder(Order.asc("descrpprofesion"));
             entityTipProfesion=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityTipProfesion.size()>0){
                    for(TipProfesion obj: entityTipProfesion) {            
                    DominioTipProfesion dominio = new DominioTipProfesion();
                    dominio.setIdtipprofesion(obj.getIdtipprofesion());
                    dominio.setDescrpprofesion(obj.getDescrpprofesion());
                    dominio.setCont(cont++);
                    dominio.setPosicion(pos++);
                    listaDominio.add(dominio);
                    }
                }
            
            
            return listaDominio; 
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioTipProfesion dominio = new DominioTipProfesion();
            dominio.setMsg("Error de transacion : "+e.getMessage());
            listaDominio.add(dominio);
            return listaDominio;
        }
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(TipProfesion.class);
             Map<String, Object> filtrs = filters;
            String key="";
            String vlr="";
            
            if (!filtrs.isEmpty()) {
                
                Iterator it = filtrs.entrySet().iterator(); 
                while (it.hasNext()) { 
                    Map.Entry e = (Map.Entry)it.next(); 
                    key=(String) e.getKey();
                    vlr=(String) e.getValue();
                    if (vlr instanceof String) {
			criteria.add(Restrictions.ilike(key,  vlr, MatchMode.ANYWHERE));
                    } else {
			criteria.add(Restrictions.eq(key, vlr));
                    }
                    
                } 
            }
            return criteria.list().size();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public DominioTipProfesion getById(DominioTipProfesion obj) throws Exception {
        TipProfesion entity;
        try {
            entity = em.find(TipProfesion.class, obj.getIdtipprofesion());
           obj.setIdtipprofesion(entity.getIdtipprofesion());
           obj.setDescrpprofesion(entity.getDescrpprofesion());
           obj.setStatus(true);
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioTipProfesion guardar(DominioTipProfesion obj) throws Exception {
        TipProfesion entity = new TipProfesion();
        try{
        entity.setDescrpprofesion(obj.getDescrpprofesion());
        em.persist(entity);
        obj.setStatus(true);
        obj.setMsg("Registro Guardado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioTipProfesion actualizar(DominioTipProfesion obj) throws Exception {
        TipProfesion entity = new TipProfesion();
        try{
        entity = em.find(TipProfesion.class, obj.getIdtipprofesion());
        entity.setDescrpprofesion(obj.getDescrpprofesion());
        
        em.merge(entity);
        obj.setIdtipprofesion(entity.getIdtipprofesion());
        obj.setDescrpprofesion(entity.getDescrpprofesion());
        obj.setStatus(true);
        obj.setMsg("Registro Actualizado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioTipProfesion borrar(DominioTipProfesion obj) throws Exception {
         TipProfesion entity = new TipProfesion();
        try{
            entity = em.find(TipProfesion.class, obj.getIdtipprofesion());
        em.remove(entity);
        obj.setStatus(true);
        obj.setMsg("Registro Borrado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }
     
}
