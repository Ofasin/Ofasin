/**
 * Todos los Derechos Reservados © 2019 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema AGORA
 * Nombre de archivo: TipEducacionIface.java
 * Fecha de creacion : Febrero, 2019
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioTipProfesion;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Heidelber
 */

@Remote
public interface TipProfesionIface {
    List<DominioTipProfesion> getAll() throws Exception;
    public List<DominioTipProfesion> getListaPagination(int first, int pageSize, Map<String, Object> filters) ;
    public int rowCount(Map<String, Object> filters) ;
    public DominioTipProfesion getById(DominioTipProfesion obj) throws Exception;
    public DominioTipProfesion guardar(DominioTipProfesion obj) throws Exception;
    public DominioTipProfesion actualizar(DominioTipProfesion obj) throws Exception;
    public DominioTipProfesion borrar(DominioTipProfesion obj) throws Exception;
    
}
