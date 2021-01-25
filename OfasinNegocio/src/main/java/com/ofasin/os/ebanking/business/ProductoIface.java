/**
 * Todos los Derechos Reservados © 2020 WAYUU - SOFT.
 * Sistema de Control y verificacion de Simpatisantes.
 * Este software contiene información propiedad exclusiva de WAYUU - SOFT considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: ProductoIface.java
 * Fecha de creacion : Diciembre, 2020
 * @author : Heidelber Gonzalez Iguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/

package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioProducto;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

@Remote
public interface ProductoIface {
    List<DominioProducto> getAll() throws Exception;
    public List<DominioProducto> getListaPagination(int first, int pageSize, Map<String, Object> filters) ;
    public int rowCount(Map<String, Object> filters) ;
    public DominioProducto getById(DominioProducto obj) throws Exception;
    public DominioProducto guardar(DominioProducto obj) throws Exception;
    public DominioProducto actualizar(DominioProducto obj) throws Exception;
    public DominioProducto borrar(DominioProducto obj) throws Exception;
    
}
