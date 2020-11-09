/**
 * Todos los Derechos Reservados © 2020 Wayuu - Soft .
 * Sistema Ofasin.
 * Este software contiene información propiedad exclusiva de Wayuu - Soft considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionBeanResguardo.java
 * Fecha de creacion : Octubre, 2020
 * @author : HeidelberGonzalezIguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

package com.ofasin.procesos.bean;
import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.procesos.entities.Resguardo;
import com.ofasin.os.ebanking.business.ResguardoIface;
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

@Stateless(name = "ejbResguardo")
public class SessionBeanResguardo implements ResguardoIface{
    @PersistenceContext(unitName = "persistenceOFASIN")
    EntityManager em;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<DominioResguardo> getAll() throws Exception {
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

    @Override
    public List<DominioResguardo> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        List<Resguardo> entityResguardo = new ArrayList<>();
        List<DominioResguardo> listaDominio = new ArrayList<>();
        
        try {
            Session session = this.em.unwrap(Session.class);
            Criteria criteria;
            criteria = session.createCriteria(com.ofasin.procesos.entities.Resguardo.class);
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
            criteria.addOrder(Order.asc("idresguardo"));
             entityResguardo=criteria.list();
        
            int cont = first+1;
            int pos = 0;
            if(entityResguardo.size()>0){
                    for(Resguardo obj: entityResguardo) {            
                    DominioResguardo dominio = new DominioResguardo();
                    dominio.setIdresguardo(obj.getIdresguardo());
                    dominio.setDescrip(obj.getDescrip());
                    dominio.setCont(cont++);
                    dominio.setPosicion(pos++);
                    dominio.setStatus(true);
                    listaDominio.add(dominio);
                    }
                }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error : "+e.getMessage());
            DominioResguardo dominio = new DominioResguardo();
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
            criteria = session.createCriteria(com.ofasin.procesos.entities.Resguardo.class);
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
    public DominioResguardo getById(DominioResguardo obj) throws Exception {
        Resguardo entity;
        try {
            entity = em.find(Resguardo.class, obj.getIdresguardo());
           obj.setIdresguardo(entity.getIdresguardo());
           obj.setDescrip(entity.getDescrip());
           obj.setStatus(true);
           obj.setMsg("Registro Encontrado");
        } catch(Exception e) {
            obj.setStatus(false);
            obj.setMsg("Error de transaccion : \n"+e);
        }
        return obj;
    }

    @Override
    public DominioResguardo guardar(DominioResguardo obj) throws Exception {
       Resguardo entity = new Resguardo();
        try{
        entity.setDescrip(obj.getDescrip());
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
    public DominioResguardo actualizar(DominioResguardo obj) throws Exception {
        Resguardo entity = new Resguardo();
        try{
        entity = em.find(Resguardo.class, obj.getIdresguardo());
        entity.setDescrip(obj.getDescrip());
        
        em.merge(entity);
        obj.setIdresguardo(entity.getIdresguardo());
        obj.setDescrip(entity.getDescrip());
        obj.setStatus(true);
        obj.setMsg("Registro Actualizado Exitosamente");
        
        } catch(Exception e) {
            obj.setMsg("Error de Transaccion : \n"+e);
            obj.setStatus(false);
        }
        return obj;
    }

    @Override
    public DominioResguardo borrar(DominioResguardo obj) throws Exception {
        Resguardo entity = new Resguardo();
        try{
            entity = em.find(Resguardo.class, obj.getIdresguardo());
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


