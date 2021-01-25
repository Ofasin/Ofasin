/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema AGORA
 * Nombre de archivo: PredupuestodetllIface.java
 * Fecha de creacion : Diciembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioPresupuestodetll;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Heidelber
 */

@Remote
public interface PresupuestodetllIface {
    List<DominioPresupuestodetll> getAll() throws Exception;
    public List<DominioPresupuestodetll> getListaPagination(int first, int pageSize, Map<String, Object> filters) ;
    public int rowCount(Map<String, Object> filters) ;
    public DominioPresupuestodetll getById(DominioPresupuestodetll obj) throws Exception;
    public DominioPresupuestodetll guardar(DominioPresupuestodetll obj) throws Exception;
    public DominioPresupuestodetll actualizar(DominioPresupuestodetll obj) throws Exception;
    public DominioPresupuestodetll borrar(DominioPresupuestodetll obj) throws Exception;
    
}
