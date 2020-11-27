/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: ServicePerfil.java
 * Fecha de creacion : Noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/ 
package com.ofasin.os.ebanking.service;

import com.ofasin.os.ebanking.model.DominioPerfil;
import com.ofasin.os.ebanking.business.PerfilIface;

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
public class ServicePerfil implements PerfilIface{
PerfilIface ejb;

    @Override
    public List<DominioPerfil> getAll() throws Exception {
     ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        
        return ejb.getAll();
    }

    @Override
    public List<DominioPerfil> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
      
        try {
            ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return ejb.getListaPagination(first,pageSize, filters );
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
        try {
            ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.rowCount(filters);
    }

    @Override
    public DominioPerfil getById(DominioPerfil obj) throws Exception {
         try {
            ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getById(obj);
    }

    @Override
    public DominioPerfil guardar(DominioPerfil obj) throws Exception {
         try {
            ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.guardar(obj);
    }

    @Override
    public DominioPerfil actualizar(DominioPerfil obj) throws Exception {
         try {
            ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.actualizar(obj);
    }

    @Override
    public DominioPerfil borrar(DominioPerfil obj) throws Exception {
       try {
            ejb = (PerfilIface)Utilidades.getEJBRemote("ejbPerfil", PerfilIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceResguardo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.borrar(obj);
    }
    
}
