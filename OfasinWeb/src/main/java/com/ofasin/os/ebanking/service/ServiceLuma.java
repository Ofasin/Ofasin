/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: ServiceLuma.java
 * Fecha de creacion : Octubre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/ 



package com.ofasin.os.ebanking.service;

import com.ofasin.os.ebanking.model.DominioLuma;
import com.ofasin.os.ebanking.model.DominioUsers;
import com.ofasin.os.ebanking.business.LumaIface;
import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.os.ebanking.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;



@Service
public class ServiceLuma implements LumaIface{
    LumaIface ejb;

    @Override
    public List<DominioLuma> getAll() throws Exception {
        ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        return ejb.getAll();
    }

    @Override
    public List<DominioLuma> getListaPagination(int first, int pageSize, Map<String, Object> filters,DominioUsers user) {
        try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
                       
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ejb.getListaPagination(first,pageSize, filters,user );
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
         try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.rowCount(filters);
    }

    @Override
    public DominioLuma getById(DominioLuma obj) throws Exception {
        try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getById(obj);
    }

    @Override
    public DominioLuma guardar(DominioLuma obj) throws Exception {
         try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.guardar(obj);
    }

    @Override
    public DominioLuma actualizar(DominioLuma obj) throws Exception {
         try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.actualizar(obj);
    }

    @Override
    public DominioLuma borrar(DominioLuma obj) throws Exception {
        try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.borrar(obj);
    }

    @Override
    public List<DominioAsociacion> getListaAsociacion() {
         try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
            
            
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getListaAsociacion();
    }

    @Override
    public List<DominioResguardo> getListaResguardo() {
         try {
            ejb = (LumaIface)Utilidades.getEJBRemote("ejbLuma", LumaIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getListaResguardo();
    }
    
    
}
