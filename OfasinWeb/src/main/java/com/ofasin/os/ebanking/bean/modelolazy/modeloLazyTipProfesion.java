/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: modeloLazyTipProfesion.java
 * Fecha de creacion : Octubre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/


package com.ofasin.os.ebanking.bean.modelolazy;


import java.io.Serializable;
import org.primefaces.model.LazyDataModel;
import com.ofasin.os.ebanking.model.DominioTipProfesion;
import com.ofasin.os.ebanking.business.TipProfesionIface;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.SortOrder;

public class modeloLazyTipProfesion  extends LazyDataModel<DominioTipProfesion> implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<DominioTipProfesion> datasource;
    private TipProfesionIface service1;
    
    
    public modeloLazyTipProfesion(TipProfesionIface service) {
        this.service1=service;
    }
    
    public modeloLazyTipProfesion(List<DominioTipProfesion> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public DominioTipProfesion getRowData(String rowKey) {
        Integer id = Integer.valueOf(rowKey);

        for(DominioTipProfesion car : datasource) {
           
            
            if(id.equals(car.getCont()))
                return car;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(DominioTipProfesion car) {
        return car.getCont();
    }
    
    @Override
	public List<DominioTipProfesion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            
          
        try {
            
            this.datasource= this.service1.getListaPagination(first,pageSize,filters);
            
        } catch (Exception ex) {
            Logger.getLogger(modeloLazyTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         //rowCount
        int dataSize = datasource.size();
		
        try {
            
            this.setRowCount(this.service1.rowCount(filters));
        } catch (Exception ex) {
            Logger.getLogger(modeloLazyTipProfesion.class.getName()).log(Level.SEVERE, null, ex);
        }
		 //paginate
        if(dataSize > pageSize) {
            try {
                return datasource.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return datasource.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return datasource;
        }
	}
    
}
