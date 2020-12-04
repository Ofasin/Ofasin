package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Presupuesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-03T10:45:13")
@StaticMetamodel(Sector.class)
public class Sector_ { 

    public static volatile SingularAttribute<Sector, Long> idsector;
    public static volatile ListAttribute<Sector, Presupuesto> presupuestoList;
    public static volatile SingularAttribute<Sector, String> descrp;

}