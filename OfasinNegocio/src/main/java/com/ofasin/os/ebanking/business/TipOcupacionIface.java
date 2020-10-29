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

package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioTipOcupacion;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Heidelber
 */

@Remote
public interface TipOcupacionIface {
    List<DominioTipOcupacion> getAll() throws Exception;
    public List<DominioTipOcupacion> getListaPagination(int first, int pageSize, Map<String, Object> filters) ;
    public int rowCount(Map<String, Object> filters) ;
    public DominioTipOcupacion getById(DominioTipOcupacion obj) throws Exception;
    public DominioTipOcupacion guardar(DominioTipOcupacion obj) throws Exception;
    public DominioTipOcupacion actualizar(DominioTipOcupacion obj) throws Exception;
    public DominioTipOcupacion borrar(DominioTipOcupacion obj) throws Exception;
    
}
