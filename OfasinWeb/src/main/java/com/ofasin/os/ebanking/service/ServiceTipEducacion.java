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

import com.ofasin.os.ebanking.model.DominioTipEducacion;
import com.ofasin.os.ebanking.business.TipEducacionIface;
import com.ofasin.os.ebanking.utils.Utilidades;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class ServiceTipEducacion implements TipEducacionIface{
    
    TipEducacionIface ejb;

    @Override
    public List<DominioTipEducacion> getAll() throws Exception {
       ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        return ejb.getAll();
    }

    @Override
    public List<DominioTipEducacion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        try {
            ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipEducacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getListaPagination(first,pageSize, filters );
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
        try {
            ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipEducacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.rowCount(filters);
    }

    @Override
    public DominioTipEducacion getById(DominioTipEducacion obj) throws Exception {
        try {
            ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipEducacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getById(obj);
    }

    @Override
    public DominioTipEducacion guardar(DominioTipEducacion obj) throws Exception {
        try {
            ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipEducacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.guardar(obj);
    }

    @Override
    public DominioTipEducacion actualizar(DominioTipEducacion obj) throws Exception {
       try {
            ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipEducacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.actualizar(obj);
    }

    @Override
    public DominioTipEducacion borrar(DominioTipEducacion obj) throws Exception {
        try {
            ejb = (TipEducacionIface)Utilidades.getEJBRemote("ejbTipEducacion", TipEducacionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipEducacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.borrar(obj);
    }
    
}
