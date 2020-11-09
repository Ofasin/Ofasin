/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: ServiceResguardo.java
 * Fecha de creacion : Octubre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/ 

package com.ofasin.os.ebanking.service;

import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.os.ebanking.business.ResguardoIface;
import com.ofasin.os.ebanking.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;


/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

@Service
public class ServiceResguardo implements ResguardoIface{

    ResguardoIface ejb;
    
    @Override
    public List<DominioResguardo> getAll() throws Exception {
        ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        
        return ejb.getAll();
    }

    @Override
    public List<DominioResguardo> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        try {
            ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<DominioResguardo>  list = new ArrayList<>();
        list = ejb.getListaPagination(first,pageSize, filters );
        System.out.println("list.size = "+list.size());
        for(DominioResguardo str : list)
{
    //imprimimos el objeto pivote
    System.out.println("Contador : "+str.getCont());
    System.out.println("Mensaje : "+str.getMsg());
    System.out.println("IdResguardo : "+str.getIdresguardo());
    System.out.println("NombreResguardo : "+str.getDescrip());
}
        return ejb.getListaPagination(first,pageSize, filters );
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
       try {
            ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.rowCount(filters);
    }

    @Override
    public DominioResguardo getById(DominioResguardo obj) throws Exception {
         try {
            ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getById(obj);
    }

    @Override
    public DominioResguardo guardar(DominioResguardo obj) throws Exception {
         try {
            ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.guardar(obj);
    }

    @Override
    public DominioResguardo actualizar(DominioResguardo obj) throws Exception {
       try {
            ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.actualizar(obj);
    }

    @Override
    public DominioResguardo borrar(DominioResguardo obj) throws Exception {
         try {
            ejb = (ResguardoIface)Utilidades.getEJBRemote("ejbResguardo", ResguardoIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.borrar(obj);
    }
    
}
