package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Wayuu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-24T09:08:57")
@StaticMetamodel(TipProfesion.class)
public class TipProfesion_ { 

    public static volatile SingularAttribute<TipProfesion, Long> idtipprofesion;
    public static volatile ListAttribute<TipProfesion, Wayuu> wayuuList;
    public static volatile SingularAttribute<TipProfesion, Date> fecdia;
    public static volatile SingularAttribute<TipProfesion, String> descrpprofesion;

}