/**
 * Todos los Derechos Reservados © 2021 Wayuu - Soft .
 * Sistema Fredy.
 * Este software contiene información propiedad exclusiva de Wayuu - Soft considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ----------------------------------------------------------------------------
 * Nombre de Aplicacion: Sistema Ofasin
 * Nombre de archivo: SessionBeanUserLog.java
 * Fecha de creacion : Octubre, 2020
 * @author : HeidelberGonzalezIguaran
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 * ----------------------------------------------------------------------------
**/
package com.ofasin.procesos.bean;

import com.ofasin.os.ebanking.model.DominioUsers;
import com.ofasin.os.ebanking.model.DominioWayuu;
import com.ofasin.os.ebanking.model.DominioRoll;
import com.ofasin.procesos.entities.Users;
import com.ofasin.procesos.entities.Wayuu;
//import com.ofasin.procesos.entities.utils.Utils;
import com.ofasin.os.ebanking.business.UsersLoginIface;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Heidelber
 */

@Stateless(name = "ejbUserLog")
public class SessionUsersLog implements UsersLoginIface{
    
@PersistenceContext(unitName = "persistenceOFASIN")
 EntityManager em;   

    @Override
    public DominioUsers Login(DominioUsers obj) throws Exception {
        try{
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(com.ofasin.procesos.entities.Users.class)
                    .add(Restrictions.eq("user", obj.getUser()))
                    .add(Restrictions.eq("password", Cript(obj.getPassword())))
                    .setMaxResults(1);
            
            Users entity = (Users) criteria.uniqueResult();;   
              if(entity!=null) {   
                
                obj.setFechaAcceso(entity.getFechaAcceso());
                obj.setIduser(entity.getIduser());
                
                   DominioWayuu usu=new DominioWayuu();
                   usu.setIdwayuu(entity.getIdusuario().getIdwayuu());
                   usu.setTpdocumento(entity.getIdusuario().getTpdocumento());
                   usu.setDocumento(entity.getIdusuario().getDocumento());
                   usu.setNombres(entity.getIdusuario().getNombres());
                   usu.setPrnombre(entity.getIdusuario().getPrnombre());
                   usu.setSgnombre(entity.getIdusuario().getSgnombre());
                   usu.setPrape(entity.getIdusuario().getPrape());
                   usu.setSgape(entity.getIdusuario().getSgape());
                   usu.setTelefono(entity.getIdusuario().getTelefono());
                   usu.setOtroTelefono(entity.getIdusuario().getOtroTelefono());
                   usu.setDireccion(entity.getIdusuario().getDireccion());
                   
                  // usu.setLuma(entity.getIdusuario().getLuma());
                  // usu.setLuma(entity.getIdusuario().getLuma());
                  
                   usu.setEstado(entity.getIdusuario().getEstado());
                   
                   usu.setTipoUsuario(entity.getIdusuario().getTipoUsuario());
                   usu.setArchivo(entity.getIdusuario().getArchivo());
                   usu.setLatitud(entity.getIdusuario().getLatitud());
                   usu.setLongitud(entity.getIdusuario().getLongitud());
                   
                   DominioRoll roll= new DominioRoll();
                   roll.setIdroll(entity.getIdroll().getIdroll());
                   roll.setNombre(entity.getIdroll().getNombre());
                   roll.setDescripcion(entity.getIdroll().getDescripcion());
                   roll.setEstado(entity.getIdroll().getEstado());
                   
                   
                   obj.setIdroll(roll);
                   obj.setIdusuario(usu);
                   
                   obj.setStatus(true);
                   obj.setMsg("Usuario encontrado usando Criteria de Hibernate. . .");
                   obj.setUser(entity.getUser()+" En P1");
                   entity = null;
                   
                   
             } else {
                entity = null;
                obj.setStatus(false);
                obj.setMsg("El Usuario no fue encontrado. . .");
            }    
            return obj;
        } catch(Exception ex) {
            ex.printStackTrace();
            
            obj.setStatus(false);
                obj.setMsg("Ha cacheado un error : "+ex.getMessage()+"\nError : "+ex.toString());
                return obj;
            //throw new Exception("Error en validarUsuario: "+ex.getMessage(), ex);
            
        }
    }
    public String Cript(String texto){
       String textoSHA = DigestUtils.sha1Hex(texto);
        return textoSHA;
    }
    
}
