/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: BeanAsociacion.java
 * Fecha de creacion : Noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/


package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.os.ebanking.business.AsociacionIface;
import com.ofasin.os.ebanking.bean.modelolazy.modeloLazyAsociacion;
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
 * @author Heidelber Gonzalez iguaran
 */


public class BeanAsociacion extends BeanGeneric{
    
    private final static Logger log = Logger.getLogger(BeanAsociacion.class);
    private DominioAsociacion asociacion;
    private AsociacionIface service;
    private LazyDataModel<DominioAsociacion> listaModel;
    private List<DominioAsociacion> listaAsociacion;
    private List<DominioAsociacion> lista;
    
    
    public DominioAsociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(DominioAsociacion asociacion) {
        this.asociacion = asociacion;
    }

    public AsociacionIface getService() {
        return service;
    }

    public void setService(AsociacionIface service) {
        this.service = service;
    }

    public LazyDataModel<DominioAsociacion> getListaModel() {
        return listaModel;
    }

    public void setListaModel(LazyDataModel<DominioAsociacion> listaModel) {
        this.listaModel = listaModel;
    }

    public List<DominioAsociacion> getListaAsociacion() {
        return listaAsociacion;
    }

    public void setListaAsociacion(List<DominioAsociacion> listaAsociacion) {
        this.listaAsociacion = listaAsociacion;
    }

    public List<DominioAsociacion> getLista() {
        return lista;
    }

    public void setLista(List<DominioAsociacion> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void llenaAsociacion() {
        try {
            setLista(service.getAll());
        } catch(Exception e) {
            Global.addMsgErr("Error  ", e.getMessage());
            log.error("ERROR llenaTiposEventos : "+e);
        }
    }
    

    @Override
    public void llenaLista() {
        listaModel = new modeloLazyAsociacion(getService());
    setListaModel(listaModel);
    }

    @Override
    public void save(ActionEvent event) {
        setAccion("save");
        //RequestContext context = RequestContext.getCurrentInstance();
        try{
            
            
        DominioAsociacion obj = (DominioAsociacion)service.guardar(asociacion);
        
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
            
        DominioAsociacion obj = (DominioAsociacion)service.actualizar(asociacion);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+asociacion.getIdasocicion()+"'\n se actualizo correctamente");
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
            
        DominioAsociacion obj = (DominioAsociacion)service.actualizar(asociacion);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+asociacion.getCont()+"'\n se actualizo correctamente");
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
        if(asociacion.getIdasocicion()!= null) {
            
            try {
               
                 DominioAsociacion obj = (DominioAsociacion)service.borrar(asociacion);
                 if(obj.isStatus()) {
                Global.addMsg("Registro Borrado", "El Registro '"+asociacion.getIdasocicion()+"'\n se eliminó correctamente");
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
            asociacion = new DominioAsociacion();
            asociacion.setPosicion((listaModel.getRowCount()%listaModel.getPageSize()));
        } else {
            
            setTituloPantalla("Actualizando Registro");
            setShowSave(false);            
            setShowUpdate(true);            
            asociacion = (DominioAsociacion)obj;
             
        }
    }

    @Override
    public void deleteAllSelect(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void showAsociacion(final SelectEvent event) {
        setTituloPantalla("Consulta de Registro");
        asociacion = (DominioAsociacion)event.getObject();
        asociacion.setDisabled(true);
    }
    
    public DominioAsociacion getById(DominioAsociacion obj) throws Exception {
        return (DominioAsociacion)service.getById(obj);
    }
    
}
