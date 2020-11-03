/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: BeanTipEducacion.java
 * Fecha de creacion : noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/


package com.ofasin.os.ebanking.bean;


import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.os.ebanking.business.ResguardoIface;
import com.ofasin.os.ebanking.bean.modelolazy.modeloLazyResguardo;



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

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.primefaces.PrimeFaces;


/**
 *
 * @author Heidelber Gonzalez Iguaran
 */
public class BeanResguardo extends BeanGeneric{
    
    private final static Logger log = Logger.getLogger(BeanAsociacion.class);
    private DominioResguardo resguardo;
    private ResguardoIface service;
    private LazyDataModel<DominioResguardo> listaModel;
    private List<DominioResguardo> listaResguardo;
    private List<DominioResguardo> lista;

    public DominioResguardo getResguardo() {
        return resguardo;
    }

    public void setResguardo(DominioResguardo resguardo) {
        this.resguardo = resguardo;
    }

    public ResguardoIface getService() {
        return service;
    }

    public void setService(ResguardoIface service) {
        this.service = service;
    }

    public LazyDataModel<DominioResguardo> getListaModel() {
        return listaModel;
    }

    public void setListaModel(LazyDataModel<DominioResguardo> listaModel) {
        this.listaModel = listaModel;
    }

    public List<DominioResguardo> getListaResguardo() {
        return listaResguardo;
    }

    public void setListaResguardo(List<DominioResguardo> listaResguardo) {
        this.listaResguardo = listaResguardo;
    }

    public List<DominioResguardo> getLista() {
        return lista;
    }

    public void setLista(List<DominioResguardo> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void llenaResguardo() {
        try {
            setLista(service.getAll());
        } catch(Exception e) {
            Global.addMsgErr("Error  ", e.getMessage());
            log.error("ERROR llenaResguardo : "+e);
        }
    }

    @Override
    public void llenaLista() {
        listaModel = new modeloLazyResguardo(getService());
    setListaModel(listaModel);
    }

    @Override
    public void save(ActionEvent event) {
        setAccion("save");
        //RequestContext context = RequestContext.getCurrentInstance();
        try{
            
            
        DominioResguardo obj = (DominioResguardo)service.guardar(resguardo);
        
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
            
        DominioResguardo obj = (DominioResguardo)service.actualizar(resguardo);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+resguardo.getIdresguardo()+"'\n se actualizo correctamente");
        } else {
            
            Global.addMsgErr("Error : ", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        }catch (Exception ex) {
            Logger.getLogger(BeanAsociacion.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void update(RowEditEvent event) {
       setAccion("update");
        try{
            
        DominioResguardo obj = (DominioResguardo)service.actualizar(resguardo);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+resguardo.getCont()+"'\n se actualizo correctamente");
        } else {
            
            Global.addMsgErr("Error : ", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        }catch (Exception ex) {
            Logger.getLogger(BeanTipProfesion.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void delete(ActionEvent event) {
        //RequestContext context = RequestContext.getCurrentInstance();
        if(resguardo.getIdresguardo()!= null) {
            
            try {
               
                 DominioResguardo obj = (DominioResguardo)service.borrar(resguardo);
                 if(obj.isStatus()) {
                Global.addMsg("Registro Borrado", "El Registro '"+resguardo.getIdresguardo()+"'\n se eliminó correctamente");
            } else {
                Global.addMsgErr("Error", obj.getMsg());
                PrimeFaces.current().ajax().addCallbackParam("errorTransaction", obj.getMsg());
                //context.addCallbackParam("errorTransaction", obj.getMsg());
                log.error("ERROR : "+obj.getMsg());
            }
                 PrimeFaces.current().ajax().addCallbackParam("statusTransaction", obj.isStatus());
            //context.addCallbackParam("statusTransaction", obj.isStatus());
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(BeanAsociacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            resguardo = new DominioResguardo();
            resguardo.setPosicion((listaModel.getRowCount()%listaModel.getPageSize()));
        } else {
            
            setTituloPantalla("Actualizando Registro");
            setShowSave(false);            
            setShowUpdate(true);            
            resguardo = (DominioResguardo)obj;
             
        }
    }

    @Override
    public void deleteAllSelect(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showResguardo(final SelectEvent event) {
        setTituloPantalla("Consulta de Registro");
        resguardo = (DominioResguardo)event.getObject();
        resguardo.setDisabled(true);
    }
    
    
}
