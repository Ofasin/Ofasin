package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Asociacion;
import com.ofasin.procesos.entities.Perfil;
import com.ofasin.procesos.entities.Resguardo;
import com.ofasin.procesos.entities.Wayuu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-11T09:44:36")
@StaticMetamodel(Luma.class)
public class Luma_ { 

    public static volatile SingularAttribute<Luma, Float> latitud;
    public static volatile SingularAttribute<Luma, Float> longitud;
    public static volatile ListAttribute<Luma, Wayuu> wayuuList;
    public static volatile SingularAttribute<Luma, Resguardo> idresguardo;
    public static volatile SingularAttribute<Luma, Long> idluma;
    public static volatile SingularAttribute<Luma, String> descrluma;
    public static volatile SingularAttribute<Luma, Date> fecactuliza;
    public static volatile SingularAttribute<Luma, Asociacion> idasociacion;
    public static volatile ListAttribute<Luma, Perfil> perfilList;

}