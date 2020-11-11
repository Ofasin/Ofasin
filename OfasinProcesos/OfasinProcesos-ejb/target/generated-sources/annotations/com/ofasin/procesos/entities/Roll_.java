package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Permisos;
import com.ofasin.procesos.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-11T09:44:36")
@StaticMetamodel(Roll.class)
public class Roll_ { 

    public static volatile SingularAttribute<Roll, String> descripcion;
    public static volatile SingularAttribute<Roll, Short> estado;
    public static volatile ListAttribute<Roll, Users> usersList;
    public static volatile ListAttribute<Roll, Permisos> permisosList;
    public static volatile SingularAttribute<Roll, Long> idroll;
    public static volatile SingularAttribute<Roll, String> nombre;

}