/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

public class DominioWayuu extends DominioGeneric  {

    private static final long serialVersionUID = 1L;
    private Long idwayuu;
    private String tpdocumento;
    private String documento;
    private String nombres;
    private String prnombre;
    private String sgnombre;
    private String prape;
    private String sgape;
    private String telefono;
    private String otroTelefono;
    private String direccion;
    private String tipoUsuario;
    private byte[] archivo;
    private Float latitud;
    private Float longitud;
    private String sexo;
    private BigInteger estado;
    private Date fechanac;
    private BigInteger estcivil;
    private String apellidos;
    private DominioLuma luma;
    private DominioTipEducacion tipEdu;
    private DominioTipOcupacion tipOcupacion;
    private DominioTipPariente parentesco;
    private DominioTipProfesion profesion;

    public DominioWayuu() {
    }

    public DominioWayuu(Long idwayuu) {
        this.idwayuu = idwayuu;
    }

    public Long getIdwayuu() {
        return idwayuu;
    }

    public void setIdwayuu(Long idwayuu) {
        this.idwayuu = idwayuu;
    }

    public String getTpdocumento() {
        return tpdocumento;
    }

    public void setTpdocumento(String tpdocumento) {
        this.tpdocumento = tpdocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrnombre() {
        return prnombre;
    }

    public void setPrnombre(String prnombre) {
        this.prnombre = prnombre;
    }

    public String getSgnombre() {
        return sgnombre;
    }

    public void setSgnombre(String sgnombre) {
        this.sgnombre = sgnombre;
    }

    public String getPrape() {
        return prape;
    }

    public void setPrape(String prape) {
        this.prape = prape;
    }

    public String getSgape() {
        return sgape;
    }

    public void setSgape(String sgape) {
        this.sgape = sgape;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOtroTelefono() {
        return otroTelefono;
    }

    public void setOtroTelefono(String otroTelefono) {
        this.otroTelefono = otroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public BigInteger getEstcivil() {
        return estcivil;
    }

    public void setEstcivil(BigInteger estcivil) {
        this.estcivil = estcivil;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public DominioLuma getLuma() {
        return luma;
    }

    public void setLuma(DominioLuma luma) {
        this.luma = luma;
    }

    public DominioTipEducacion getTipEdu() {
        return tipEdu;
    }

    public void setTipEdu(DominioTipEducacion tipEdu) {
        this.tipEdu = tipEdu;
    }

    public DominioTipOcupacion getTipOcupacion() {
        return tipOcupacion;
    }

    public void setTipOcupacion(DominioTipOcupacion tipOcupacion) {
        this.tipOcupacion = tipOcupacion;
    }

    public DominioTipPariente getParentesco() {
        return parentesco;
    }

    public void setParentesco(DominioTipPariente parentesco) {
        this.parentesco = parentesco;
    }

    public DominioTipProfesion getProfesion() {
        return profesion;
    }

    public void setProfesion(DominioTipProfesion profesion) {
        this.profesion = profesion;
    }

    
    
}
