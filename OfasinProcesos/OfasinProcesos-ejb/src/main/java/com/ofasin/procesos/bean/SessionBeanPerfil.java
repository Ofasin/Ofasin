/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control Ofasin.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionbeanPerfil.java
 * Fecha de creacion : Noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/
package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioPerfil;
import com.ofasin.procesos.entities.Perfil;
import com.ofasin.os.ebanking.business.PerfilIface;
import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.os.ebanking.model.DominioLuma;
import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.procesos.entities.Asociacion;
import com.ofasin.procesos.entities.Luma;
import com.ofasin.procesos.entities.Resguardo;

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

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author HEIDELBER GONZALEZ IGUARAN
 */
@Stateless(name = "ejbPerfil")
public class SessionBeanPerfil implements PerfilIface{
@PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;
    @Override
    public List<DominioPerfil> getAll() throws Exception {
        List<Perfil> entityPerfil = new ArrayList<>();
        List<DominioPerfil> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.Perfil.class);
                entityPerfil= criteria.list();
                int cont = 1;
                if(entityPerfil.size()>0){
                    for(Perfil obj: entityPerfil) {   
                    
                    DominioAsociacion asociacion = new DominioAsociacion();
                    DominioResguardo resguardo  = new DominioResguardo();
                    resguardo.setIdresguardo(obj.getIdluma().getIdresguardo().getIdresguardo());
                    resguardo.setDescrip(obj.getIdluma().getIdresguardo().getDescrip());
                    asociacion.setIdasocicion(obj.getIdluma().getIdasociacion().getIdasocicion());
                    asociacion.setBarrio(obj.getIdluma().getIdasociacion().getBarrio());
                    asociacion.setDireccion(obj.getIdluma().getIdasociacion().getDireccion());
                    asociacion.setNombre(obj.getIdluma().getIdasociacion().getNombre());
                    
                    DominioLuma luma = new DominioLuma();
                    luma.setIdluma(obj.getIdluma().getIdluma());
                    luma.setDescrluma(obj.getIdluma().getDescrluma());
                    luma.setFecactuliza(obj.getIdluma().getFecactuliza());
                    luma.setLatitud(obj.getIdluma().getLatitud());
                    luma.setIdresguardo(resguardo);
                    luma.setIdresguardo(resguardo);
                    luma.setIdasociacion(asociacion);
                    
                    DominioPerfil dominio = new DominioPerfil();
                    dominio.setContratista(obj.getContratista());
                    dominio.setDescrpperfil(obj.getDescrpperfil());
                    dominio.setFecradica(obj.getFecradica());
                    dominio.setIdluma(luma);
                    dominio.setIdperfil(obj.getIdperfil());
                    dominio.setMonto(obj.getMonto());
                    dominio.setObs(obj.getObs());
                    dominio.setTechopresp(obj.getTechopresp());
                    dominio.setVigencia(obj.getVigencia());
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
                
             
        } catch (Exception e) {
            e.printStackTrace();
            DominioPerfil dominio = new DominioPerfil();
            dominio.setCont(1);
            dominio.setStatus(false);
            dominio.setMsg("Error de Transaccion : "+e.getMessage());
            listaDominio.add(dominio);
        }
        return listaDominio; 
    }

    @Override
    public List<DominioPerfil> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        List<Perfil> entityPerfil = new ArrayList<>();
        List<DominioPerfil> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.Perfil.class);
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
            criteria.addOrder(Order.asc("idperfil"));
             entityPerfil=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityPerfil.size()>0){
                    for(Perfil obj: entityPerfil) {            
                    DominioAsociacion asociacion = new DominioAsociacion();
                    DominioResguardo resguardo  = new DominioResguardo();
                    if(obj.getIdluma().getIdasociacion()!=null){
                    
                    asociacion.setIdasocicion(obj.getIdluma().getIdasociacion().getIdasocicion());
                    asociacion.setBarrio(obj.getIdluma().getIdasociacion().getBarrio());
                    asociacion.setDireccion(obj.getIdluma().getIdasociacion().getDireccion());
                    asociacion.setNombre(obj.getIdluma().getIdasociacion().getNombre());
                    }
                    if(obj.getIdluma().getIdresguardo()!=null){
                        
                        resguardo.setIdresguardo(obj.getIdluma().getIdresguardo().getIdresguardo());
                    resguardo.setDescrip(obj.getIdluma().getIdresguardo().getDescrip());
                    }
                    
                    
                    
                    DominioLuma luma = new DominioLuma();
                    luma.setIdluma(obj.getIdluma().getIdluma());
                    luma.setDescrluma(obj.getIdluma().getDescrluma());
                    luma.setFecactuliza(obj.getIdluma().getFecactuliza());
                    luma.setLongitud(obj.getIdluma().getLongitud());
                    luma.setLatitud(obj.getIdluma().getLatitud());
                    luma.setIdresguardo(resguardo);
                    luma.setIdasociacion(asociacion);
                    DominioPerfil dominio = new DominioPerfil();
                    dominio.setContratista(obj.getContratista());
                    dominio.setDescrpperfil(obj.getDescrpperfil());
                    dominio.setFecradica(obj.getFecradica());
                    dominio.setIdluma(luma);
                    dominio.setIdperfil(obj.getIdperfil());
                    dominio.setMonto(obj.getMonto());
                    dominio.setObs(obj.getObs());
                    dominio.setTechopresp(obj.getTechopresp());
                    dominio.setVigencia(obj.getVigencia());
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioPerfil dominio = new DominioPerfil();
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
            criteria = session.createCriteria(com.ofasin.procesos.entities.Perfil.class);
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
    public DominioPerfil getById(DominioPerfil obj) throws Exception {
        Perfil entity;
        try {
            entity = em.find(Perfil.class, obj.getIdperfil());
            
            DominioAsociacion asociacion = new DominioAsociacion();
            DominioResguardo resguardo = new DominioResguardo();
            DominioLuma luma = new DominioLuma();
            
            if (obj.getIdluma().getIdasociacion() != null) {

                asociacion.setIdasocicion(obj.getIdluma().getIdasociacion().getIdasocicion());
                asociacion.setBarrio(obj.getIdluma().getIdasociacion().getBarrio());
                asociacion.setDireccion(obj.getIdluma().getIdasociacion().getDireccion());
                asociacion.setNombre(obj.getIdluma().getIdasociacion().getNombre());
            }
            if (obj.getIdluma().getIdresguardo() != null) {

                resguardo.setIdresguardo(obj.getIdluma().getIdresguardo().getIdresguardo());
                resguardo.setDescrip(obj.getIdluma().getIdresguardo().getDescrip());
            }
            
           luma.setIdluma(entity.getIdluma().getIdluma());
           luma.setDescrluma(entity.getIdluma().getDescrluma());
           luma.setFecactuliza(entity.getIdluma().getFecactuliza());
           luma.setLatitud(entity.getIdluma().getLatitud());
           luma.setLongitud(entity.getIdluma().getLongitud() );
           obj.setIdluma(luma);
           obj.setContratista(entity.getContratista());
           obj.setDescrpperfil(entity.getDescrpperfil());
           obj.setFecradica(entity.getFecradica());
           obj.setIdperfil(entity.getIdperfil());
           obj.setMonto(entity.getMonto());
           obj.setObs(entity.getObs());
           obj.setTechopresp(entity.getTechopresp());
           
           obj.setStatus(true);
           
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioPerfil guardar(DominioPerfil obj) throws Exception {
        Perfil entityPerfil = new Perfil();
        Asociacion entityAsociacion = new Asociacion();
        Resguardo entityResguardo = new Resguardo();
        Luma entityLuma =new Luma();
        try{
            if(obj.getIdluma().getIdasociacion()!=null){
                entityAsociacion.setIdasocicion(obj.getIdluma().getIdasociacion().getIdasocicion());
                entityLuma.setIdasociacion(entityAsociacion);
            }
        
            if(obj.getIdluma().getIdresguardo()!=null){
            entityResguardo.setIdresguardo(obj.getIdluma().getIdresguardo().getIdresguardo());
            entityLuma.setIdresguardo(entityResguardo);
            }
        
        entityPerfil.setIdluma(entityLuma);
        entityPerfil.setArchivo(obj.getArchivo());
        entityPerfil.setContratista(obj.getContratista());
        entityPerfil.setDescrpperfil(obj.getDescrpperfil());
        entityPerfil.setFecradica(obj.getFecradica());
        entityPerfil.setMonto(obj.getMonto());
        entityPerfil.setObs(obj.getObs());
        entityPerfil.setTechopresp(obj.getTechopresp());
        entityPerfil.setVigencia(obj.getVigencia());
       
        em.persist(entityPerfil);
        obj.setStatus(true);
        obj.setMsg("Registro Guardado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioPerfil actualizar(DominioPerfil obj) throws Exception {
        Perfil entityPerfil =new Perfil();
        Luma entityLuma = new Luma();
         Asociacion entityAsociacion = new Asociacion();
         Resguardo entityResguardo = new Resguardo();
         
        try{
            
        
       
        entityPerfil = em.find(Perfil.class, obj.getIdperfil());
        
        entityLuma.setDescrluma(obj.getIdluma().getDescrluma());
        entityLuma.setFecactuliza(obj.getIdluma().getFecactuliza());
        entityLuma.setLatitud(obj.getIdluma().getLatitud());
        entityLuma.setLongitud(obj.getIdluma().getLongitud());
        
        if(obj.getIdluma().getIdasociacion()!=null){
            entityAsociacion.setIdasocicion(obj.getIdluma().getIdasociacion().getIdasocicion());
            
            entityLuma.setIdasociacion(entityAsociacion);
            }
            if(obj.getIdluma().getIdresguardo()!=null){
                 entityResguardo.setIdresguardo(obj.getIdluma().getIdresguardo().getIdresguardo());
                 
                entityLuma.setIdresguardo(entityResguardo);
            }
            
            entityPerfil.setIdluma(entityLuma);
        entityPerfil.setArchivo(obj.getArchivo());
        entityPerfil.setContratista(obj.getContratista());
        entityPerfil.setDescrpperfil(obj.getDescrpperfil());
        entityPerfil.setFecradica(obj.getFecradica());
        entityPerfil.setMonto(obj.getMonto());
        entityPerfil.setObs(obj.getObs());
        entityPerfil.setTechopresp(obj.getTechopresp());
        entityPerfil.setVigencia(obj.getVigencia());
        
        em.merge(entityPerfil);
        obj.setIdperfil(entityPerfil.getIdperfil());
        obj.setDescrpperfil(entityPerfil.getDescrpperfil());
        obj.setStatus(true);
               
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioPerfil borrar(DominioPerfil obj) throws Exception {
        Perfil entity = new Perfil();
        try{
            entity = em.find(Perfil.class, obj.getIdperfil());
        em.remove(entity);
        obj.setStatus(true);
        obj.setMsg("Registro Borrado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
