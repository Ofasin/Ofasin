/**
 * Todos los Derechos Reservados © 2019 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema de Control y verificacion de Simpatisantes
 * Nombre de archivo: BeanGeneric.java
 * Fecha de creacion : Febrero, 2019
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

package com.ofasin.os.ebanking.bean;

import java.io.Serializable;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;

public abstract class BeanGeneric<T> implements Serializable {
    public abstract void llenaLista();
    public abstract void save(ActionEvent event);
    public abstract void updateRow(ActionEvent ae);
    public abstract void update(RowEditEvent event);
    public abstract void delete(ActionEvent event);
    public abstract void onUpdateInsertRow(Object obj);
    public abstract void deleteAllSelect(ActionEvent ae);
    private String tituloPantalla;
    private String accion;
    private boolean showSave;
    private boolean showUpdate;

    /**
     * @return the tituloPantalla
     */
    public String getTituloPantalla() {
        return tituloPantalla;
    }

    /**
     * @param tituloPantalla the tituloPantalla to set
     */
    public void setTituloPantalla(String tituloPantalla) {
        this.tituloPantalla = tituloPantalla;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the showSave
     */
    public boolean isShowSave() {
        return showSave;
    }

    /**
     * @param showSave the showSave to set
     */
    public void setShowSave(boolean showSave) {
        this.showSave = showSave;
    }

    /**
     * @return the showUpdate
     */
    public boolean isShowUpdate() {
        return showUpdate;
    }

    /**
     * @param showUpdate the showUpdate to set
     */
    public void setShowUpdate(boolean showUpdate) {
        this.showUpdate = showUpdate;
    }
}
