package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Presupuestodetll;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-25T06:03:09")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, Presupuestodetll> presupuestodetllList;
    public static volatile SingularAttribute<Producto, String> nombreproducto;
    public static volatile SingularAttribute<Producto, BigDecimal> valor;
    public static volatile SingularAttribute<Producto, String> descpproducto;
    public static volatile SingularAttribute<Producto, Long> idproducto;

}