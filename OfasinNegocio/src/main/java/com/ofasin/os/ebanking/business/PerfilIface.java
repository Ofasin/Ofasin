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

import com.ofasin.os.ebanking.model.DominioPerfil;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Heidelber
 */

@Remote
public interface PerfilIface {
    List<DominioPerfil> getAll() throws Exception;
    public List<DominioPerfil> getListaPagination(int first, int pageSize, Map<String, Object> filters) ;
    public int rowCount(Map<String, Object> filters) ;
    public DominioPerfil getById(DominioPerfil obj) throws Exception;
    public DominioPerfil guardar(DominioPerfil obj) throws Exception;
    public DominioPerfil actualizar(DominioPerfil obj) throws Exception;
    public DominioPerfil borrar(DominioPerfil obj) throws Exception;
    
}
