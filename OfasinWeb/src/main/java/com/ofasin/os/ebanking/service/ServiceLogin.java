/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.service;

import com.ofasin.os.ebanking.model.DominioUsers;
import com.ofasin.os.ebanking.business.UsersLoginIface;
import com.ofasin.os.ebanking.utils.Utilidades;
import org.springframework.stereotype.Service;

/**
 *
 * @Heidelber Gonzalez Iguaran
 */
@Service
public class ServiceLogin implements UsersLoginIface {
    UsersLoginIface ejb;

    @Override
    public DominioUsers Login(DominioUsers obj) throws Exception {
        ejb = (UsersLoginIface)Utilidades.getEJBRemote("ejbUserLog", UsersLoginIface.class.getName());
        
        DominioUsers ret =new DominioUsers();
        ret=ejb.Login(obj);
        System.out.println("\n IdUser: "+ret.getIduser());
        System.out.println("Nombre: "+ret.getIdusuario().getPrnombre());
        System.out.println("Status: "+ret.isStatus());
        System.out.println("Mensaje: "+ret.getMsg());
        return ejb.Login(obj);
    }    
}
