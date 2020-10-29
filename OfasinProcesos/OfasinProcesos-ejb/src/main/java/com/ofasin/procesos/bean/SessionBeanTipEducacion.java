/**
 * Todos los Derechos Reservados © 2020 Wayuu - Soft .
 * Sistema Fredy.
 * Este software contiene información propiedad exclusiva de Wayuu - Soft considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionBeanTipEducacion.java
 * Fecha de creacion : Octubre, 2020
 * @author : HeidelberGonzalezIguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/


package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioTipEducacion;
import com.ofasin.procesos.entities.TipEducacion;
import com.ofasin.os.ebanking.business.TipEducacionIface;
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

@Stateless(name = "ejbTipEducacion")
public class SessionBeanTipEducacion implements TipEducacionIface{
    @PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;

    @Override
    public List<DominioTipEducacion> getAll() throws Exception {
        List<TipEducacion> entityTipEducacion = new ArrayList<>();
        List<DominioTipEducacion> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.TipEducacion.class);
                entityTipEducacion= criteria.list();
                int cont = 1;
                if(entityTipEducacion.size()>0){
                    for(TipEducacion obj: entityTipEducacion) {            
                    DominioTipEducacion dominio = new DominioTipEducacion();
                    dominio.setIdtipeducacion(obj.getIdtipeducacion());
                    dominio.setDescrptipeducacion(obj.getDescrptipeducacion());
                    dominio.setCont(cont++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
                
             
        } catch (Exception e) {
            e.printStackTrace();
            DominioTipEducacion dominio = new DominioTipEducacion();
            dominio.setCont(1);
            dominio.setStatus(false);
            dominio.setMsg("Error de Transaccion : "+e.getMessage());
            listaDominio.add(dominio);
        }
        return listaDominio; 
    }

    @Override
    public List<DominioTipEducacion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        List<TipEducacion> entityTipEducacion = new ArrayList<>();
        List<DominioTipEducacion> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.TipEducacion.class);
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
            criteria.addOrder(Order.asc("idtipeducacion"));
             entityTipEducacion=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityTipEducacion.size()>0){
                    for(TipEducacion obj: entityTipEducacion) {            
                    DominioTipEducacion dominio = new DominioTipEducacion();
                    dominio.setIdtipeducacion(obj.getIdtipeducacion());
                    dominio.setDescrptipeducacion(obj.getDescrptipeducacion());
                    dominio.setCont(cont++);
                    dominio.setPosicion(pos++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioTipEducacion dominio = new DominioTipEducacion();
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
            criteria = session.createCriteria(com.ofasin.procesos.entities.TipEducacion.class);
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
    public DominioTipEducacion getById(DominioTipEducacion obj) throws Exception {
       TipEducacion entity;
        try {
            entity = em.find(TipEducacion.class, obj.getIdtipeducacion());
           obj.setIdtipeducacion(entity.getIdtipeducacion());
           obj.setDescrptipeducacion(entity.getDescrptipeducacion());
           obj.setStatus(true);
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioTipEducacion guardar(DominioTipEducacion obj) throws Exception {
         TipEducacion entity = new TipEducacion();
        try{
        entity.setDescrptipeducacion(obj.getDescrptipeducacion());
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
    public DominioTipEducacion actualizar(DominioTipEducacion obj) throws Exception {
         TipEducacion entity = new TipEducacion();
        try{
        entity = em.find(TipEducacion.class, obj.getIdtipeducacion());
        entity.setDescrptipeducacion(obj.getDescrptipeducacion());
        
        em.merge(entity);
        obj.setIdtipeducacion(entity.getIdtipeducacion());
        obj.setDescrptipeducacion(entity.getDescrptipeducacion());
        obj.setStatus(true);
        obj.setMsg("Registro Actualizado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioTipEducacion borrar(DominioTipEducacion obj) throws Exception {
          TipEducacion entity = new TipEducacion();
        try{
            entity = em.find(TipEducacion.class, obj.getIdtipeducacion());
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
