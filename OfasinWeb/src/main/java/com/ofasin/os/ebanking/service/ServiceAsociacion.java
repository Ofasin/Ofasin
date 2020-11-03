/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: ServiceTipEducacion.java
 * Fecha de creacion : Octubre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/ 


package com.ofasin.os.ebanking.service;

import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.os.ebanking.business.AsociacionIface;

import com.ofasin.os.ebanking.utils.Utilidades;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;


/**
 *
 * @author Heidelber Gonzalez iguaran
 */

@Service
public class ServiceAsociacion implements AsociacionIface{
AsociacionIface ejb;
    
    @Override
    public List<DominioAsociacion> getAll() throws Exception {
        ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        return ejb.getAll();
    }

    @Override
    public List<DominioAsociacion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        try {
            ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceAsociacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getListaPagination(first,pageSize, filters );
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
         try {
            ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceAsociacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.rowCount(filters);
    }

    @Override
    public DominioAsociacion getById(DominioAsociacion obj) throws Exception {
       try {
            ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceAsociacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getById(obj);
    }

    @Override
    public DominioAsociacion guardar(DominioAsociacion obj) throws Exception {
        try {
            ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceAsociacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.guardar(obj);
    }

    @Override
    public DominioAsociacion actualizar(DominioAsociacion obj) throws Exception {
        try {
            ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceAsociacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.actualizar(obj);
    }

    @Override
    public DominioAsociacion borrar(DominioAsociacion obj) throws Exception {
        try {
            ejb = (AsociacionIface)Utilidades.getEJBRemote("ejbAsociacion", AsociacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceAsociacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.borrar(obj);
    }
    
}
