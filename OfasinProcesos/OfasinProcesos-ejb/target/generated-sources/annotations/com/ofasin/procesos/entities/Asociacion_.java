package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Luma;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-08T20:17:04")
@StaticMetamodel(Asociacion.class)
public class Asociacion_ { 

    public static volatile SingularAttribute<Asociacion, Long> idasocicion;
    public static volatile SingularAttribute<Asociacion, String> barrio;
    public static volatile SingularAttribute<Asociacion, String> direccion;
    public static volatile ListAttribute<Asociacion, Luma> lumaList;
    public static volatile SingularAttribute<Asociacion, BigInteger> idmunicipio;
    public static volatile SingularAttribute<Asociacion, String> telefono;
    public static volatile SingularAttribute<Asociacion, String> nombre;

}