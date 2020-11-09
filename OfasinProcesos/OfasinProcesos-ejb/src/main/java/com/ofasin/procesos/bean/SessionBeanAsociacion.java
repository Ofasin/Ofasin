/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.procesos.entities.Asociacion;
import com.ofasin.os.ebanking.business.AsociacionIface;
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

        


/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

@Stateless(name = "ejbAsociacion")
public class SessionBeanAsociacion implements AsociacionIface{
@PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;

    @Override
    public List<DominioAsociacion> getAll() throws Exception {
        List<Asociacion> entityAsociacion = new ArrayList<>();
        List<DominioAsociacion> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.Asociacion.class);
                entityAsociacion= criteria.list();
                int cont = 1;
                if(entityAsociacion.size()>0){
                    for(Asociacion obj: entityAsociacion) {            
                    DominioAsociacion dominio = new DominioAsociacion();
                    dominio.setIdasocicion(obj.getIdasocicion());
                    dominio.setNombre(obj.getNombre());
                    dominio.setBarrio(obj.getBarrio());
                    dominio.setDireccion(obj.getDireccion());
                    dominio.setTelefono(obj.getTelefono());
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
                
             
        } catch (Exception e) {
            e.printStackTrace();
            DominioAsociacion dominio = new DominioAsociacion();
            dominio.setCont(1);
            dominio.setStatus(false);
            dominio.setMsg("Error de Transaccion : "+e.getMessage());
            listaDominio.add(dominio);
        }
        return listaDominio; 
    }

    @Override
    public List<DominioAsociacion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
       List<Asociacion> entityAsociacion = new ArrayList<>();
        List<DominioAsociacion> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.Asociacion.class);
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
            criteria.addOrder(Order.asc("idasocicion"));
             entityAsociacion=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityAsociacion.size()>0){
                    for(Asociacion obj: entityAsociacion) {            
                    DominioAsociacion dominio = new DominioAsociacion();
                    dominio.setIdasocicion(obj.getIdasocicion());
                    dominio.setNombre(obj.getNombre());
                    dominio.setBarrio(obj.getBarrio());
                    dominio.setDireccion(obj.getDireccion());
                    dominio.setTelefono(obj.getTelefono());
                    dominio.setCont(cont++);
                    dominio.setPosicion(pos++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioAsociacion dominio = new DominioAsociacion();
            dominio.setStatus(false);
            dominio.setMsg("Error de transaccion : "+e.getMessage());
            listaDominio.add(dominio);
            
        }
        return listaDominio;
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
         try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.Asociacion.class);
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
    public DominioAsociacion getById(DominioAsociacion obj) throws Exception {
        Asociacion entity;
        try {
            entity = em.find(Asociacion.class, obj.getIdasocicion());
           obj.setIdasocicion(entity.getIdasocicion());
           obj.setNombre(entity.getNombre());
           obj.setBarrio(entity.getBarrio());
           obj.setDireccion(entity.getDireccion());
           obj.setTelefono(entity.getTelefono());
           obj.setStatus(true);
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioAsociacion guardar(DominioAsociacion obj) throws Exception {
         Asociacion entity = new Asociacion();
        try{
        entity.setNombre(obj.getNombre());
        entity.setBarrio(obj.getBarrio());
        entity.setDireccion(obj.getDireccion());
        entity.setTelefono(obj.getTelefono());
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
    public DominioAsociacion actualizar(DominioAsociacion obj) throws Exception {
        Asociacion entity = new Asociacion();
        try{
        entity = em.find(Asociacion.class, obj.getIdasocicion());
        entity.setNombre(obj.getNombre());
        entity.setBarrio(obj.getBarrio());
        entity.setDireccion(obj.getDireccion());
        entity.setTelefono(obj.getTelefono());
        
        em.merge(entity);
        obj.setIdasocicion(entity.getIdasocicion());
        obj.setNombre(entity.getNombre());
        obj.setStatus(true);
        obj.setMsg("Registro Actualizado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioAsociacion borrar(DominioAsociacion obj) throws Exception {
       Asociacion entity = new Asociacion();
        try{
            entity = em.find(Asociacion.class, obj.getIdasocicion());
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
