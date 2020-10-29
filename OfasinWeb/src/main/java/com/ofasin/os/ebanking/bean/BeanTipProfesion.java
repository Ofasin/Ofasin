/**
 * Todos los Derechos Reservados © 2019 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema AGORA
 * Nombre de archivo: BeanTipProfesion.java
 * Fecha de creacion : Febrero, 2019
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/
package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.model.DominioTipProfesion;
import com.ofasin.os.ebanking.business.TipProfesionIface;
import com.ofasin.os.ebanking.bean.modelolazy.modeloLazyTipProfesion;
import com.ofasin.os.ebanking.globals.Global;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import org.primefaces.context.PrimeRequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.primefaces.PrimeFaces;






public class BeanTipProfesion extends BeanGeneric {
    private final static Logger log = Logger.getLogger(BeanTipProfesion.class);
    private DominioTipProfesion tipProfesion;
    private TipProfesionIface service;
    private LazyDataModel<DominioTipProfesion> listaModel;
    private List<DominioTipProfesion> listaTiposProfesion;
    private List<DominioTipProfesion> lista;

    public DominioTipProfesion getTipProfesion() {
        return tipProfesion;
    }

    public void setTipProfesion(DominioTipProfesion tipProfesion) {
        this.tipProfesion = tipProfesion;
    }

    public TipProfesionIface getService() {
        return service;
    }

    public void setService(TipProfesionIface service) {
        this.service = service;
    }

    public LazyDataModel<DominioTipProfesion> getListaModel() {
        return listaModel;
    }

    public void setListaModel(LazyDataModel<DominioTipProfesion> listaModel) {
        this.listaModel = listaModel;
    }

    public List<DominioTipProfesion> getListaTiposProfesion() {
        return listaTiposProfesion;
    }

    public void setListaTiposProfesion(List<DominioTipProfesion> listaTiposProfesion) {
        this.listaTiposProfesion = listaTiposProfesion;
    }

    public List<DominioTipProfesion> getLista() {
        return lista;
    }

    public void setLista(List<DominioTipProfesion> lista) {
        this.lista = lista;
    }
    
     @PostConstruct
    public void llenaTipoProfesion() {
        try {
            setLista(service.getAll());
        } catch(Exception e) {
            Global.addMsgErr("Error  ", e.getMessage());
            log.error("ERROR llenaTiposProfesiones : "+e);
        }
    }


    @Override
    public void llenaLista() {
         listaModel = new modeloLazyTipProfesion(getService());
    setListaModel(listaModel);
    }

    @Override
    public void save(ActionEvent event) {
        setAccion("save");
        // RequestContext context = RequestContext.getCurrentInstance();
        try{
            
            
        DominioTipProfesion obj = (DominioTipProfesion)service.guardar(tipProfesion);
        
        if(obj.isStatus()) {
            Global.addMsg("Registro Insertado", "El registro se insertó correctamente");
        } else {
            Global.addMsgErr("Error en Transacción", obj.getMsg());
             PrimeFaces.current().ajax().addCallbackParam("errorTransaction", obj.getMsg());
            //context.addCallbackParam("errorTransaction", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        
        PrimeFaces.current().ajax().addCallbackParam("statusTransaction", obj.isStatus());
        }catch (Exception ex) {
            Logger.getLogger(BeanTipProfesion.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void updateRow(ActionEvent ae) {
         setAccion("update");
        try{
            
        DominioTipProfesion obj = (DominioTipProfesion)service.actualizar(tipProfesion);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+tipProfesion.getCont()+"'\n se actualizo correctamente");
        } else {
            
            Global.addMsgErr("Error : ", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        }catch (Exception ex) {
            Logger.getLogger(BeanTipProfesion.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void update(RowEditEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ActionEvent event) {
        //RequestContext context = RequestContext.getCurrentInstance();
        if(tipProfesion.getIdtipprofesion()!= null) {
            
            try {
               
                 DominioTipProfesion obj = (DominioTipProfesion)service.borrar(tipProfesion);
                 if(obj.isStatus()) {
                Global.addMsg("Registro Borrado", "El Registro '"+tipProfesion.getCont()+"'\n se eliminó correctamente");
            } else {
                Global.addMsgErr("Error", obj.getMsg());
                PrimeFaces.current().ajax().addCallbackParam("errorTransaction", obj.getMsg());
                //context.addCallbackParam("errorTransaction", obj.getMsg());
                log.error("ERROR : "+obj.getMsg());
            }
            PrimeFaces.current().ajax().addCallbackParam("statusTransaction", obj.isStatus());
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(BeanTipProfesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
        } else {
            PrimeFaces.current().ajax().addCallbackParam("statusTransaction", false);
            PrimeFaces.current().ajax().addCallbackParam("errorTransaction", "El campo 'IdTipoGasto' is required");
        }
    }

    @Override
    public void onUpdateInsertRow(Object obj) {
         if(obj == null) {
            setTituloPantalla("Nuevo Registro");
            setShowSave(true);
            setShowUpdate(false);
            tipProfesion = new DominioTipProfesion();
            tipProfesion.setPosicion((listaModel.getRowCount()%listaModel.getPageSize()));
        } else {
            
            setTituloPantalla("Actualizando Registro");
            setShowSave(false);            
            setShowUpdate(true);            
            tipProfesion = (DominioTipProfesion)obj;
             
        }
    }

    @Override
    public void deleteAllSelect(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showTipoProfesion(final SelectEvent event) {
        setTituloPantalla("Consulta de Registro");
        tipProfesion = (DominioTipProfesion)event.getObject();
        tipProfesion.setDisabled(true);
    }
    
}
