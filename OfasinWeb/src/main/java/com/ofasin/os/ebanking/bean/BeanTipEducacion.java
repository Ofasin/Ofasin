/**
 * Todos los Derechos Reservados © 2019 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema AGORA
 * Nombre de archivo: BeanTipEducacion.java
 * Fecha de creacion : Febrero, 2019
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/


package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.model.DominioTipEducacion;
import com.ofasin.os.ebanking.business.TipEducacionIface;
import com.ofasin.os.ebanking.bean.modelolazy.modeloLazyTipEducacion;
import com.ofasin.os.ebanking.globals.Global;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
//import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.primefaces.PrimeFaces;




public class BeanTipEducacion  extends BeanGeneric{
    private final static Logger log = Logger.getLogger(BeanTipEducacion.class);
    private DominioTipEducacion tipEducacion;
    private TipEducacionIface service;
    private LazyDataModel<DominioTipEducacion> listaModel;
    private List<DominioTipEducacion> listaTiposEducacion;
    private List<DominioTipEducacion> lista;

    public DominioTipEducacion getTipEducacion() {
        return tipEducacion;
    }

    public void setTipEducacion(DominioTipEducacion tipEducacion) {
        this.tipEducacion = tipEducacion;
    }

    public TipEducacionIface getService() {
        return service;
    }

    public void setService(TipEducacionIface service) {
        this.service = service;
    }

    public LazyDataModel<DominioTipEducacion> getListaModel() {
        return listaModel;
    }

    public void setListaModel(LazyDataModel<DominioTipEducacion> listaModel) {
        this.listaModel = listaModel;
    }

    public List<DominioTipEducacion> getListaTiposEducacion() {
        return listaTiposEducacion;
    }

    public void setListaTiposEducacion(List<DominioTipEducacion> listaTiposEducacion) {
        this.listaTiposEducacion = listaTiposEducacion;
    }

    public List<DominioTipEducacion> getLista() {
        return lista;
    }

    public void setLista(List<DominioTipEducacion> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void llenaTipoEducacion() {
        try {
            setLista(service.getAll());
        } catch(Exception e) {
            Global.addMsgErr("Error  ", e.getMessage());
            log.error("ERROR llenaTiposEventos : "+e);
        }
    }


    @Override
    public void llenaLista() {
         listaModel = new modeloLazyTipEducacion(getService());
    setListaModel(listaModel);
    }

    @Override
    public void save(ActionEvent event) {
        setAccion("save");
        //RequestContext context = RequestContext.getCurrentInstance();
        try{
            
            
        DominioTipEducacion obj = (DominioTipEducacion)service.guardar(tipEducacion);
        
        if(obj.isStatus()) {
            Global.addMsg("Registro Insertado", "El registro se insertó correctamente");
        } else {
            Global.addMsgErr("Error en Transacción", obj.getMsg());
            PrimeFaces.current().ajax().addCallbackParam("errorTransaction", obj.getMsg());
            //context.addCallbackParam("errorTransaction", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        PrimeFaces.current().ajax().addCallbackParam("statusTransaction", obj.isStatus());
        //context.addCallbackParam("statusTransaction", obj.isStatus());
        }catch (Exception ex) {
            Logger.getLogger(BeanTipEducacion.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void updateRow(ActionEvent ae) {
        setAccion("update");
        try{
            
        DominioTipEducacion obj = (DominioTipEducacion)service.actualizar(tipEducacion);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+tipEducacion.getIdtipeducacion()+"'\n se actualizo correctamente");
        } else {
            
            Global.addMsgErr("Error : ", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        }catch (Exception ex) {
            Logger.getLogger(BeanTipEducacion.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void update(RowEditEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ActionEvent event) {
         //RequestContext context = RequestContext.getCurrentInstance();
        if(tipEducacion.getIdtipeducacion()!= null) {
            
            try {
               
                 DominioTipEducacion obj = (DominioTipEducacion)service.borrar(tipEducacion);
                 if(obj.isStatus()) {
                Global.addMsg("Registro Borrado", "El Registro '"+tipEducacion.getIdtipeducacion()+"'\n se eliminó correctamente");
            } else {
                Global.addMsgErr("Error", obj.getMsg());
                PrimeFaces.current().ajax().addCallbackParam("errorTransaction", obj.getMsg());
                //context.addCallbackParam("errorTransaction", obj.getMsg());
                log.error("ERROR : "+obj.getMsg());
            }
                 PrimeFaces.current().ajax().addCallbackParam("statusTransaction", obj.isStatus());
            //context.addCallbackParam("statusTransaction", obj.isStatus());
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(BeanTipEducacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
        } else {
           PrimeFaces.current().ajax().addCallbackParam("statusTransaction", false);
            //context.addCallbackParam("statusTransaction", false);
            PrimeFaces.current().ajax().addCallbackParam("errorTransaction",  "El campo 'IdTipoGasto' is required");
            //context.addCallbackParam("errorTransaction", "El campo 'IdTipoGasto' is required");
        }
    }

    @Override
    public void onUpdateInsertRow(Object obj) {
        if(obj == null) {
            setTituloPantalla("Nuevo Registro");
            setShowSave(true);
            setShowUpdate(false);
            tipEducacion = new DominioTipEducacion();
            tipEducacion.setPosicion((listaModel.getRowCount()%listaModel.getPageSize()));
        } else {
            
            setTituloPantalla("Actualizando Registro");
            setShowSave(false);            
            setShowUpdate(true);            
            tipEducacion = (DominioTipEducacion)obj;
             
        }
    }

    @Override
    public void deleteAllSelect(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showTipoEducacion(final SelectEvent event) {
        setTituloPantalla("Consulta de Registro");
        tipEducacion = (DominioTipEducacion)event.getObject();
        tipEducacion.setDisabled(true);
    }
    
    
}
