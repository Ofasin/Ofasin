/**
 * Todos los Derechos Reservados © 2020 Wayuu - Soft .
 * Sistema Fredy.
 * Este software contiene información propiedad exclusiva de Wayuu - Soft considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionBeanTipOcacion.java
 * Fecha de creacion : Octubre, 2020
 * @author : HeidelberGonzalezIguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/
package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioTipOcupacion;
import com.ofasin.procesos.entities.TipOcupacion;
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
import com.ofasin.os.ebanking.business.TipOcupacionIface;

@Stateless(name = "ejbTipOcupacion")
public class SessionBeanTipOcupacion implements TipOcupacionIface{

    @PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;
    
    @Override
    public List<DominioTipOcupacion> getAll() throws Exception {
        List<TipOcupacion> entityTipOcacion = new ArrayList<>();
        List<DominioTipOcupacion> listaDominio = new ArrayList<>();
        try {
                Session session = em.unwrap(Session.class);
                Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.TipOcupacion.class);
                entityTipOcacion= criteria.list();
                int cont = 1;
                if(entityTipOcacion.size()>0){
                    for(TipOcupacion obj: entityTipOcacion) {            
                    DominioTipOcupacion dominio = new DominioTipOcupacion();
                    dominio.setIdtipocupacion(obj.getIdtipocupacion());
                    dominio.setDecrptipocupacion(obj.getDecrptipocupacion());
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
    public List<DominioTipOcupacion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        List<TipOcupacion> entityTipOcacion = new ArrayList<>();
        List<DominioTipOcupacion> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.TipOcupacion.class);
            criteria.setFirstResult(first)
            .setMaxResults(pageSize);
            Map<String, Object> filtrs = filters;
            String key="";
            String vlr="";
            //System.out.println("estoy en SessionBean");
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
            criteria.addOrder(Order.asc("idtipocacion"));
             entityTipOcacion=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityTipOcacion.size()>0){
                    for(TipOcupacion obj: entityTipOcacion) {            
                    DominioTipOcupacion dominio = new DominioTipOcupacion();
                    dominio.setIdtipocupacion(obj.getIdtipocupacion());
                    dominio.setDecrptipocupacion(obj.getDecrptipocupacion());
                    dominio.setCont(cont++);
                    dominio.setPosicion(pos++);
                    listaDominio.add(dominio);
                    }
                }
            
            
            return listaDominio; 
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioTipOcupacion dominio = new DominioTipOcupacion();
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
            criteria = session.createCriteria(com.ofasin.procesos.entities.TipOcupacion.class);
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
    public DominioTipOcupacion getById(DominioTipOcupacion obj) throws Exception {
         TipOcupacion entity;
        try {
            
           // entity.setIdtipapoyo(obj.getIdtipapoyo());
            
            entity = em.find(TipOcupacion.class, obj.getIdtipocupacion());
           obj.setIdtipocupacion(entity.getIdtipocupacion());
           obj.setDecrptipocupacion(entity.getDecrptipocupacion());
           obj.setStatus(true);
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioTipOcupacion guardar(DominioTipOcupacion obj) throws Exception {
        TipOcupacion entity = new TipOcupacion();
        try{
        entity.setDecrptipocupacion(obj.getDecrptipocupacion());
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
    public DominioTipOcupacion actualizar(DominioTipOcupacion obj) throws Exception {
         TipOcupacion entity = new TipOcupacion();
        try{
        entity = em.find(TipOcupacion.class, obj.getIdtipocupacion());
        entity.setDecrptipocupacion(obj.getDecrptipocupacion());
        
        em.merge(entity);
        obj.setIdtipocupacion(entity.getIdtipocupacion());
        obj.setDecrptipocupacion(entity.getDecrptipocupacion());
        obj.setStatus(true);
        obj.setMsg("Registro Actualizado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioTipOcupacion borrar(DominioTipOcupacion obj) throws Exception {
         TipOcupacion entity = new TipOcupacion();
        try{
            entity = em.find(TipOcupacion.class, obj.getIdtipocupacion());
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
