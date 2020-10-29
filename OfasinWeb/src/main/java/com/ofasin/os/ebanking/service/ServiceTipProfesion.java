/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: ServiceTipProfesion.java
 * Fecha de creacion : Octubre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/ 



package com.ofasin.os.ebanking.service;

import com.ofasin.os.ebanking.model.DominioTipProfesion;
import com.ofasin.os.ebanking.business.TipProfesionIface;
import com.ofasin.os.ebanking.utils.Utilidades;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;



@Service
public class ServiceTipProfesion implements TipProfesionIface{
    TipProfesionIface ejb;

    @Override
    public List<DominioTipProfesion> getAll() throws Exception {
        ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        return ejb.getAll();
    }

    @Override
    public List<DominioTipProfesion> getListaPagination(int first, int pageSize, Map<String, Object> filters) {
        try {
            ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ejb.getListaPagination(first,pageSize, filters );
    }

    @Override
    public int rowCount(Map<String, Object> filters) {
         try {
            ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.rowCount(filters);
    }

    @Override
    public DominioTipProfesion getById(DominioTipProfesion obj) throws Exception {
        try {
            ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.getById(obj);
    }

    @Override
    public DominioTipProfesion guardar(DominioTipProfesion obj) throws Exception {
         try {
            ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.guardar(obj);
    }

    @Override
    public DominioTipProfesion actualizar(DominioTipProfesion obj) throws Exception {
         try {
            ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.actualizar(obj);
    }

    @Override
    public DominioTipProfesion borrar(DominioTipProfesion obj) throws Exception {
        try {
            ejb = (TipProfesionIface)Utilidades.getEJBRemote("ejbTipProfesion", TipProfesionIface.class.getName());
        } catch (Exception ex) {
            Logger.getLogger(ServiceTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.borrar(obj);
    }
    
    
}
