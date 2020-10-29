package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Perfildetll;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-28T06:06:41")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, BigInteger> idsector;
    public static volatile SingularAttribute<Producto, String> nombreproducto;
    public static volatile SingularAttribute<Producto, BigDecimal> valor;
    public static volatile ListAttribute<Producto, Perfildetll> perfildetllList;
    public static volatile SingularAttribute<Producto, String> descpproducto;
    public static volatile SingularAttribute<Producto, Long> idproducto;

}