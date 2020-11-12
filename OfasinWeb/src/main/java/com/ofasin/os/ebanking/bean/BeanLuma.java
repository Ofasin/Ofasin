/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Comunidades Indigenas.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: BeanLuma.java
 * Fecha de creacion : Noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/
package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.model.DominioLuma;
import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.os.ebanking.model.DominioResguardo;
import com.ofasin.os.ebanking.business.LumaIface;
import com.ofasin.os.ebanking.bean.modelolazy.modeloLazyLuma;
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

/**
 *
 * @author Heidelber Newman
 */
public class BeanLuma extends BeanGeneric  {
     private final static Logger log = Logger.getLogger(BeanLuma.class);
    private DominioLuma luma;
    private LumaIface service;
    private DominioAsociacion asociacion;

    private DominioResguardo resguardo;
    private LazyDataModel<DominioLuma> listaModel;
    private List<DominioAsociacion> listaAsociacon;
     private List<DominioResguardo> listaResguardo;
    
    private List<DominioLuma> listaLuma;
    private List<DominioLuma> lista;  

    public DominioLuma getLuma() {
        return luma;
    }

    public void setLuma(DominioLuma luma) {
        this.luma = luma;
    }

    public LumaIface getService() {
        return service;
    }

    public void setService(LumaIface service) {
        this.service = service;
    }

    public LazyDataModel<DominioLuma> getListaModel() {
        return listaModel;
    }

    public void setListaModel(LazyDataModel<DominioLuma> listaModel) {
        this.listaModel = listaModel;
    }

    public List<DominioLuma> getListaLuma() {
        return listaLuma;
    }

    public void setListaLuma(List<DominioLuma> listaLuma) {
        this.listaLuma = listaLuma;
    }

    public List<DominioLuma> getLista() {
        return lista;
    }

    public void setLista(List<DominioLuma> lista) {
        this.lista = lista;
    }
    public List<DominioAsociacion> getListaAsociacon() {
        return listaAsociacon;
    }

    public void setListaAsociacon(List<DominioAsociacion> listaAsociacon) {
        this.listaAsociacon = listaAsociacon;
    }
    
    public List<DominioResguardo> getListaResguardo() {
        return listaResguardo;
    }

    public void setListaResguardo(List<DominioResguardo> listaResguardo) {
        this.listaResguardo = listaResguardo;
    }
    
    
    public DominioAsociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(DominioAsociacion asociacion) {
        this.asociacion = asociacion;
    }

    public DominioResguardo getResguardo() {
        return resguardo;
    }

    public void setResguardo(DominioResguardo resguardo) {
        this.resguardo = resguardo;
    }
    
     @PostConstruct
    public void llenaLuma() {
        try {
            setLista(service.getAll());
        } catch(Exception e) {
            Global.addMsgErr("Error  ", e.getMessage());
            log.error("ERROR llenaTiposProfesiones : "+e);
        }
    }

    @Override
    public void llenaLista() {
        
        listaModel = new modeloLazyLuma(getService());
        listaAsociacon= getService().getListaAsociacion();
        listaResguardo= getService().getListaResguardo();
        
        setListaModel(listaModel);
        setListaAsociacon(listaAsociacon);
        setListaResguardo(listaResguardo);
        
    }

    @Override
    public void save(ActionEvent event) {
         setAccion("save");
        // RequestContext context = RequestContext.getCurrentInstance();
        try{
            
            
        DominioLuma obj = (DominioLuma)service.guardar(luma);
        
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
            Logger.getLogger(BeanLuma.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void updateRow(ActionEvent ae) {
        setAccion("update");
        try{
            
        DominioLuma obj = (DominioLuma)service.actualizar(luma);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+luma.getCont()+"'\n se actualizo correctamente");
        } else {
            
            Global.addMsgErr("Error : ", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        }catch (Exception ex) {
            Logger.getLogger(BeanLuma.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void update(RowEditEvent event) {
        setAccion("update");
        try{
            
        DominioLuma obj = (DominioLuma)service.actualizar(luma);
        if(obj.isStatus()) {
            Global.addMsg("Registro Actualizado", "El registro :'"+luma.getCont()+"'\n se actualizo correctamente");
        } else {
            
            Global.addMsgErr("Error : ", obj.getMsg());
            log.error("ERROR : "+obj.getMsg());
        }
        }catch (Exception ex) {
            Logger.getLogger(BeanLuma.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    @Override
    public void delete(ActionEvent event) {
        //RequestContext context = RequestContext.getCurrentInstance();
        if(luma.getIdluma()!= null) {
            
            try {
               
                 DominioLuma obj = (DominioLuma)service.borrar(luma);
                 if(obj.isStatus()) {
                Global.addMsg("Registro Borrado", "El Registro '"+luma.getCont()+"'\n se eliminó correctamente");
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
            luma = new DominioLuma();
            luma.setPosicion((listaModel.getRowCount()%listaModel.getPageSize()));
        } else {
            setTituloPantalla("Actualizando Registro");
            setShowSave(false);            
            setShowUpdate(true);            
            luma = (DominioLuma)obj;
            
            
        }
    }

    @Override
    public void deleteAllSelect(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showLuma(final SelectEvent event) {
        setTituloPantalla("Consulta de Registro");
        luma = (DominioLuma)event.getObject();
        luma.setDisabled(true);
    }

    
}
