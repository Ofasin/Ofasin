package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Roll;
import com.ofasin.procesos.entities.Wayuu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-25T06:03:09")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Long> iduser;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> statusUser;
    public static volatile SingularAttribute<Users, Roll> idroll;
    public static volatile SingularAttribute<Users, String> user;
    public static volatile SingularAttribute<Users, Date> fechaAcceso;
    public static volatile SingularAttribute<Users, Wayuu> idusuario;

}