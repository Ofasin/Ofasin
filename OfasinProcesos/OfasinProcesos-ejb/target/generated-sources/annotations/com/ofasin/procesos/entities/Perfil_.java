package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Luma;
import com.ofasin.procesos.entities.Perfildetll;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-28T06:06:41")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Date> vigencia;
    public static volatile SingularAttribute<Perfil, String> contratista;
    public static volatile SingularAttribute<Perfil, BigDecimal> monto;
    public static volatile SingularAttribute<Perfil, Date> fecradica;
    public static volatile SingularAttribute<Perfil, Luma> idluma;
    public static volatile SingularAttribute<Perfil, Long> idperfil;
    public static volatile SingularAttribute<Perfil, BigDecimal> techopresp;
    public static volatile ListAttribute<Perfil, Perfildetll> perfildetllList;
    public static volatile SingularAttribute<Perfil, String> descrpperfil;

}