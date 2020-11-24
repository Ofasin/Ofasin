package com.ofasin.procesos.entities;

import com.ofasin.procesos.entities.Irruko;
import com.ofasin.procesos.entities.Luma;
import com.ofasin.procesos.entities.TipEducacion;
import com.ofasin.procesos.entities.TipOcupacion;
import com.ofasin.procesos.entities.TipPariente;
import com.ofasin.procesos.entities.TipProfesion;
import com.ofasin.procesos.entities.Users;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-24T09:08:57")
@StaticMetamodel(Wayuu.class)
public class Wayuu_ { 

    public static volatile SingularAttribute<Wayuu, TipOcupacion> tipOcupacion;
    public static volatile SingularAttribute<Wayuu, BigInteger> estado;
    public static volatile ListAttribute<Wayuu, Users> usersList;
    public static volatile SingularAttribute<Wayuu, String> prnombre;
    public static volatile SingularAttribute<Wayuu, String> sgape;
    public static volatile SingularAttribute<Wayuu, String> tpdocumento;
    public static volatile SingularAttribute<Wayuu, String> documento;
    public static volatile SingularAttribute<Wayuu, String> prape;
    public static volatile SingularAttribute<Wayuu, String> nombres;
    public static volatile SingularAttribute<Wayuu, String> sgnombre;
    public static volatile SingularAttribute<Wayuu, Float> longitud;
    public static volatile SingularAttribute<Wayuu, Date> fechanac;
    public static volatile SingularAttribute<Wayuu, Long> idwayuu;
    public static volatile SingularAttribute<Wayuu, String> telefono;
    public static volatile SingularAttribute<Wayuu, String> apellidos;
    public static volatile SingularAttribute<Wayuu, Float> latitud;
    public static volatile SingularAttribute<Wayuu, byte[]> archivo;
    public static volatile SingularAttribute<Wayuu, String> direccion;
    public static volatile SingularAttribute<Wayuu, Luma> luma;
    public static volatile SingularAttribute<Wayuu, TipEducacion> tipEdu;
    public static volatile SingularAttribute<Wayuu, TipPariente> parentesco;
    public static volatile SingularAttribute<Wayuu, BigInteger> estcivil;
    public static volatile SingularAttribute<Wayuu, Irruko> irruko;
    public static volatile SingularAttribute<Wayuu, String> tipoUsuario;
    public static volatile SingularAttribute<Wayuu, String> sexo;
    public static volatile SingularAttribute<Wayuu, TipProfesion> profesion;
    public static volatile SingularAttribute<Wayuu, String> otroTelefono;

}