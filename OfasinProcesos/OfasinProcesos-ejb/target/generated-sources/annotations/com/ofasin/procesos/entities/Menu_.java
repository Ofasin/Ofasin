package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Permisos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-10T11:07:52")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> icono;
    public static volatile SingularAttribute<Menu, Short> estado;
    public static volatile SingularAttribute<Menu, Long> menuid;
    public static volatile ListAttribute<Menu, Permisos> permisosList;
    public static volatile SingularAttribute<Menu, Long> idmenu;
    public static volatile SingularAttribute<Menu, Integer> orden;
    public static volatile SingularAttribute<Menu, Integer> nivel;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, String> url;

}