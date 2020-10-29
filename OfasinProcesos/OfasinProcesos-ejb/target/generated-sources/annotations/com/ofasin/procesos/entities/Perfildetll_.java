package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Perfil;
import com.ofasin.procesos.entities.Producto;
import com.ofasin.procesos.entities.Sector;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-28T06:06:41")
@StaticMetamodel(Perfildetll.class)
public class Perfildetll_ { 

    public static volatile SingularAttribute<Perfildetll, Sector> idsector;
    public static volatile SingularAttribute<Perfildetll, BigDecimal> precioprodct;
    public static volatile SingularAttribute<Perfildetll, Long> idperfildetll;
    public static volatile SingularAttribute<Perfildetll, Perfil> idperfil;
    public static volatile SingularAttribute<Perfildetll, BigDecimal> valordetll;
    public static volatile SingularAttribute<Perfildetll, Producto> idproducto;
    public static volatile SingularAttribute<Perfildetll, BigDecimal> cantprodct;
    public static volatile SingularAttribute<Perfildetll, String> observacion;

}