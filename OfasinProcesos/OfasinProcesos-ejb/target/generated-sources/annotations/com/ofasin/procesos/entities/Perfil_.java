package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Luma;
import com.ofasin.procesos.entities.Presupuesto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-24T09:08:57")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Date> vigencia;
    public static volatile SingularAttribute<Perfil, String> obs;
    public static volatile SingularAttribute<Perfil, String> contratista;
    public static volatile SingularAttribute<Perfil, BigDecimal> monto;
    public static volatile SingularAttribute<Perfil, Date> fecradica;
    public static volatile SingularAttribute<Perfil, byte[]> archivo;
    public static volatile ListAttribute<Perfil, Presupuesto> presupuestoList;
    public static volatile SingularAttribute<Perfil, Luma> idluma;
    public static volatile SingularAttribute<Perfil, Long> idperfil;
    public static volatile SingularAttribute<Perfil, BigDecimal> techopresp;
    public static volatile SingularAttribute<Perfil, String> descrpperfil;

}