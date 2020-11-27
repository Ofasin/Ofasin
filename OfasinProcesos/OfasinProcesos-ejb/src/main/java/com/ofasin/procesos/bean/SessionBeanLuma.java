/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioLuma;
import com.ofasin.procesos.entities.Luma;
import com.ofasin.os.ebanking.business.LumaIface;
import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.procesos.entities.Asociacion;
import com.ofasin.procesos.entities.Resguardo;
import com.ofasin.os.ebanking.model.DominioUsers;

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
 * @author Heidelber Newman
 */
@Stateless(name = "ejbLuma")
public class SessionBeanLuma implements LumaIface{
@PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;

    @Override
    public List<DominioLuma> getAll() throws Exception {
       List<Luma> entityLuma = new ArrayList<>();
        List<DominioLuma> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.Luma.class);
                entityLuma= criteria.list();
                int cont = 1;
                if(entityLuma.size()>0){
                    for(Luma obj: entityLuma) {   
                    
                    DominioAsociacion asociacion = new DominioAsociacion();
                    DominioResguardo resguardo  = new DominioResguardo();
                    resguardo.setIdresguardo(obj.getIdresguardo().getIdresguardo());
                    resguardo.setDescrip(obj.getIdresguardo().getDescrip());
                    asociacion.setIdasocicion(obj.getIdasociacion().getIdasocicion());
                    asociacion.setBarrio(obj.getIdasociacion().getBarrio());
                    asociacion.setDireccion(obj.getIdasociacion().getDireccion());
                    asociacion.setNombre(obj.getIdasociacion().getNombre());
                    
                    DominioLuma dominio = new DominioLuma();
                    dominio.setIdluma(obj.getIdluma());
                    dominio.setDescrluma(obj.getDescrluma());
                    dominio.setFecactuliza(obj.getFecactuliza());
                    dominio.setLatitud(obj.getLatitud());
                    dominio.setIdresguardo(resguardo);
                    dominio.setIdresguardo(resguardo);
                    dominio.setIdasociacion(asociacion);
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
                
             
        } catch (Exception e) {
            e.printStackTrace();
            DominioLuma dominio = new DominioLuma();
            dominio.setCont(1);
            dominio.setStatus(false);
            dominio.setMsg("Error de Transaccion : "+e.getMessage());
            listaDominio.add(dominio);
        }
        return listaDominio; 
    }

    @Override
    public List<DominioLuma> getListaPagination(int first, int pageSize, Map<String, Object> filters, DominioUsers user) {
        List<Luma> entityLuma = new ArrayList<>();
        List<DominioLuma> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.Luma.class);
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
            
            if(user.getIdroll().getNombre().equalsIgnoreCase("ROLE_LIDER")){
            criteria.createAlias("", "");
            }
            criteria.addOrder(Order.asc("idluma"));
            
            
             entityLuma=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityLuma.size()>0){
                    for(Luma obj: entityLuma) {            
                    DominioAsociacion asociacion = new DominioAsociacion();
                    DominioResguardo resguardo  = new DominioResguardo();
                    if(obj.getIdasociacion()!=null){
                    
                    asociacion.setIdasocicion(obj.getIdasociacion().getIdasocicion());
                    asociacion.setBarrio(obj.getIdasociacion().getBarrio());
                    asociacion.setDireccion(obj.getIdasociacion().getDireccion());
                    asociacion.setNombre(obj.getIdasociacion().getNombre());
                    }
                    if(obj.getIdresguardo()!=null){
                        
                        resguardo.setIdresguardo(obj.getIdresguardo().getIdresguardo());
                    resguardo.setDescrip(obj.getIdresguardo().getDescrip());
                    }
                    
                    
                    
                    DominioLuma dominio = new DominioLuma();
                    dominio.setIdluma(obj.getIdluma());
                    dominio.setDescrluma(obj.getDescrluma());
                    dominio.setFecactuliza(obj.getFecactuliza());
                    dominio.setLongitud(obj.getLongitud());
                    dominio.setLatitud(obj.getLatitud());
                    dominio.setIdresguardo(resguardo);
                    dominio.setIdasociacion(asociacion);
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioLuma dominio = new DominioLuma();
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
            criteria = session.createCriteria(com.ofasin.procesos.entities.Luma.class);
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
    public DominioLuma getById(DominioLuma obj) throws Exception {
         Luma entity;
        try {
            entity = em.find(Luma.class, obj.getIdluma());
            
            DominioAsociacion asociacion = new DominioAsociacion();
            DominioResguardo resguardo = new DominioResguardo();
            if (obj.getIdasociacion() != null) {

                asociacion.setIdasocicion(obj.getIdasociacion().getIdasocicion());
                asociacion.setBarrio(obj.getIdasociacion().getBarrio());
                asociacion.setDireccion(obj.getIdasociacion().getDireccion());
                asociacion.setNombre(obj.getIdasociacion().getNombre());
            }
            if (obj.getIdresguardo() != null) {

                resguardo.setIdresguardo(obj.getIdresguardo().getIdresguardo());
                resguardo.setDescrip(obj.getIdresguardo().getDescrip());
            }
            
           obj.setIdluma(entity.getIdluma());
           obj.setDescrluma(entity.getDescrluma());
           obj.setFecactuliza(entity.getFecactuliza());
           obj.setLatitud(entity.getLatitud());
           obj.setLongitud(entity.getLongitud() );
           obj.setStatus(true);
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioLuma guardar(DominioLuma obj) throws Exception {
        Luma entityLuma = new Luma();
        Asociacion entityAsociacion = new Asociacion();
        Resguardo entityResguardo = new Resguardo();
        try{
            if(obj.getIdasociacion()!=null){
                entityAsociacion.setIdasocicion(obj.getIdasociacion().getIdasocicion());
                entityLuma.setIdasociacion(entityAsociacion);
            }
        
            if(obj.getIdresguardo()!=null){
            entityResguardo.setIdresguardo(obj.getIdresguardo().getIdresguardo());
            entityLuma.setIdresguardo(entityResguardo);
            }
        
        entityLuma.setDescrluma(obj.getDescrluma());
        entityLuma.setFecactuliza(obj.getFecactuliza());
        entityLuma.setLatitud(obj.getLatitud());
        entityLuma.setLongitud(obj.getLongitud());
        em.persist(entityLuma);
        obj.setStatus(true);
        obj.setMsg("Registro Guardado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioLuma actualizar(DominioLuma obj) throws Exception {
         Luma entityLuma = new Luma();
         Asociacion entityAsociacion = new Asociacion();
         Resguardo entityResguardo = new Resguardo();
         
        try{
            
        
       
        entityLuma = em.find(Luma.class, obj.getIdluma());
        entityLuma.setDescrluma(obj.getDescrluma());
        entityLuma.setFecactuliza(obj.getFecactuliza());
        entityLuma.setLatitud(obj.getLatitud());
        entityLuma.setLongitud(obj.getLongitud());
        
        if(obj.getIdasociacion()!=null){
            entityAsociacion.setIdasocicion(obj.getIdasociacion().getIdasocicion());
            obj.setMsg("entityAsociacion.setIdasocicion = "+entityAsociacion.getIdasocicion()+"\n");
            entityLuma.setIdasociacion(entityAsociacion);
            }
            if(obj.getIdresguardo()!=null){
                 entityResguardo.setIdresguardo(obj.getIdresguardo().getIdresguardo());
                 obj.setMsg("entityResguardo.setIdresguardo = "+entityResguardo.getIdresguardo()+"\n"); 
                entityLuma.setIdresguardo(entityResguardo);
            }
        
        em.merge(entityLuma);
        obj.setIdluma(entityLuma.getIdluma());
        obj.setDescrluma(entityLuma.getDescrluma());
        obj.setStatus(true);
               
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioLuma borrar(DominioLuma obj) throws Exception {
        Luma entity = new Luma();
        try{
            entity = em.find(Luma.class, obj.getIdluma());
        em.remove(entity);
        obj.setStatus(true);
        obj.setMsg("Registro Borrado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public List<DominioAsociacion> getListaAsociacion() {
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
    public List<DominioResguardo> getListaResguardo() {
        List<Resguardo> entityResguardo = new ArrayList<>();
        List<DominioResguardo> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.Resguardo.class);
                entityResguardo= criteria.list();
                int cont = 1;
                if(entityResguardo.size()>0){
                    for(Resguardo obj: entityResguardo) {            
                    DominioResguardo dominio = new DominioResguardo();
                    dominio.setIdresguardo(obj.getIdresguardo());
                    dominio.setDescrip(obj.getDescrip());
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
                
             
        } catch (Exception e) {
            e.printStackTrace();
            DominioResguardo dominio = new DominioResguardo();
            dominio.setCont(1);
            dominio.setStatus(false);
            dominio.setMsg("Error de Transaccion : "+e.getMessage());
            listaDominio.add(dominio);
        }
        return listaDominio; 
    }
}
