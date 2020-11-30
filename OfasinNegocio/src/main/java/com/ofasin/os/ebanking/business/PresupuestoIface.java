/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema AGORA
 * Nombre de archivo: ResguardoIface.java
 * Fecha de creacion : Noviembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioPresupuesto;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Heidelber
 */

@Remote
public interface PresupuestoIface {
    List<DominioPresupuesto> getAll() throws Exception;
    public List<DominioPresupuesto> getListaPagination(int first, int pageSize, Map<String, Object> filters) ;
    public int rowCount(Map<String, Object> filters) ;
    public DominioPresupuesto getById(DominioPresupuesto obj) throws Exception;
    public DominioPresupuesto guardar(DominioPresupuesto obj) throws Exception;
    public DominioPresupuesto actualizar(DominioPresupuesto obj) throws Exception;
    public DominioPresupuesto borrar(DominioPresupuesto obj) throws Exception;
    
}
