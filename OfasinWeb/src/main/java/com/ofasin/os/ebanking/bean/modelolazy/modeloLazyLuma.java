/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: modeloLazyLuma.java
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
import com.ofasin.os.ebanking.model.DominioLuma;
import com.ofasin.os.ebanking.model.DominioUsers;
import com.ofasin.os.ebanking.business.LumaIface;
import com.ofasin.os.ebanking.globals.Global;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.SortOrder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class modeloLazyLuma extends LazyDataModel<DominioLuma> implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<DominioLuma> datasource;
    DominioLuma objAux;
    private LumaIface service1;
    private DominioUsers user;
    Boolean pSt1= false;
    Boolean pSt2= false;
    Boolean pSt3= false;
    Object objStr1;
    Object objStr2;
    Object objStr3;
    
    public modeloLazyLuma(LumaIface service,DominioLuma obj) {
        this.service1=service;
        this.objAux=obj;
    }
    
    public modeloLazyLuma(List<DominioLuma> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public DominioLuma getRowData(String rowKey) {
        Integer id = Integer.valueOf(rowKey);

        for(DominioLuma car : datasource) {
           
            
            if(id.equals(car.getCont()))
                return car;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(DominioLuma car) {
        return car.getCont();
    }
    
    @Override
	public List<DominioLuma> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            
          
        try {
            //HttpServletRequest request = Global.getRequest();
            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            DominioUsers user = new DominioUsers();
            user =(DominioUsers)session.getAttribute("userInSession");
            objAux.setUser(user);
            System.err.println("objAuxIdUserEnModeloLazyLuma : "+objAux.getUser().getIduser());
            System.err.println("objAuxUserEnModeloLazyLuma : "+objAux.getUser().getUser());
            System.err.println("objAuxPasswordEnModeloLazyLuma : "+objAux.getUser().getPassword());
            System.err.println("objAuxIdrollEnModeloLazyLuma : "+objAux.getUser().getIdroll().getNombre());
            this.datasource= this.service1.getListaPagination(first,pageSize,filters,objAux);
            
        } catch (Exception ex) {
            Logger.getLogger(modeloLazyLuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         //rowCount
        int dataSize = datasource.size();
		
        try {
            
            this.setRowCount(this.service1.rowCount(filters));
        } catch (Exception ex) {
            Logger.getLogger(modeloLazyLuma.class.getName()).log(Level.SEVERE, null, ex);
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
