/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.business;

import com.ofasin.os.ebanking.model.DominioUsers;
import javax.ejb.Remote;


/**
 *
 * @author Heidelber
 */

@Remote
public interface UsersLoginIface {
    DominioUsers Login (DominioUsers obj) throws Exception;
}
