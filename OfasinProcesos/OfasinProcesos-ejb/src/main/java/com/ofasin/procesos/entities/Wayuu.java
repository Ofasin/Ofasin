/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "wayuu", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wayuu.findAll", query = "SELECT w FROM Wayuu w")
    , @NamedQuery(name = "Wayuu.findByIdwayuu", query = "SELECT w FROM Wayuu w WHERE w.idwayuu = :idwayuu")
    , @NamedQuery(name = "Wayuu.findByTpdocumento", query = "SELECT w FROM Wayuu w WHERE w.tpdocumento = :tpdocumento")
    , @NamedQuery(name = "Wayuu.findByDocumento", query = "SELECT w FROM Wayuu w WHERE w.documento = :documento")
    , @NamedQuery(name = "Wayuu.findByNombres", query = "SELECT w FROM Wayuu w WHERE w.nombres = :nombres")
    , @NamedQuery(name = "Wayuu.findByPrnombre", query = "SELECT w FROM Wayuu w WHERE w.prnombre = :prnombre")
    , @NamedQuery(name = "Wayuu.findBySgnombre", query = "SELECT w FROM Wayuu w WHERE w.sgnombre = :sgnombre")
    , @NamedQuery(name = "Wayuu.findByPrape", query = "SELECT w FROM Wayuu w WHERE w.prape = :prape")
    , @NamedQuery(name = "Wayuu.findBySgape", query = "SELECT w FROM Wayuu w WHERE w.sgape = :sgape")
    , @NamedQuery(name = "Wayuu.findByTelefono", query = "SELECT w FROM Wayuu w WHERE w.telefono = :telefono")
    , @NamedQuery(name = "Wayuu.findByOtroTelefono", query = "SELECT w FROM Wayuu w WHERE w.otroTelefono = :otroTelefono")
    , @NamedQuery(name = "Wayuu.findByDireccion", query = "SELECT w FROM Wayuu w WHERE w.direccion = :direccion")
    , @NamedQuery(name = "Wayuu.findByTipoUsuario", query = "SELECT w FROM Wayuu w WHERE w.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Wayuu.findByLatitud", query = "SELECT w FROM Wayuu w WHERE w.latitud = :latitud")
    , @NamedQuery(name = "Wayuu.findByLongitud", query = "SELECT w FROM Wayuu w WHERE w.longitud = :longitud")
    , @NamedQuery(name = "Wayuu.findBySexo", query = "SELECT w FROM Wayuu w WHERE w.sexo = :sexo")
    , @NamedQuery(name = "Wayuu.findByEstado", query = "SELECT w FROM Wayuu w WHERE w.estado = :estado")
    , @NamedQuery(name = "Wayuu.findByFechanac", query = "SELECT w FROM Wayuu w WHERE w.fechanac = :fechanac")
    , @NamedQuery(name = "Wayuu.findByEstcivil", query = "SELECT w FROM Wayuu w WHERE w.estcivil = :estcivil")
    , @NamedQuery(name = "Wayuu.findByApellidos", query = "SELECT w FROM Wayuu w WHERE w.apellidos = :apellidos")})
public class Wayuu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idwayuu")
    private Long idwayuu;
    @Column(name = "tpdocumento")
    private String tpdocumento;
    @Column(name = "documento")
    private String documento;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "prnombre")
    private String prnombre;
    @Column(name = "sgnombre")
    private String sgnombre;
    @Column(name = "prape")
    private String prape;
    @Column(name = "sgape")
    private String sgape;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "otro_telefono")
    private String otroTelefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Lob
    @Column(name = "archivo")
    private byte[] archivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Float latitud;
    @Column(name = "longitud")
    private Float longitud;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "estado")
    private BigInteger estado;
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Column(name = "estcivil")
    private BigInteger estcivil;
    @Column(name = "apellidos")
    private String apellidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private List<Users> usersList;
    @JoinColumn(name = "irruko", referencedColumnName = "idirruko")
    @ManyToOne(fetch = FetchType.LAZY)
    private Irruko irruko;
    @JoinColumn(name = "luma", referencedColumnName = "idluma")
    @ManyToOne(fetch = FetchType.LAZY)
    private Luma luma;
    @JoinColumn(name = "tip_edu", referencedColumnName = "idtipeducacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipEducacion tipEdu;
    @JoinColumn(name = "tip_ocupacion", referencedColumnName = "idtipocupacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipOcupacion tipOcupacion;
    @JoinColumn(name = "parentesco", referencedColumnName = "idtippariente")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipPariente parentesco;
    @JoinColumn(name = "profesion", referencedColumnName = "idtipprofesion")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipProfesion profesion;

    public Wayuu() {
    }

    public Wayuu(Long idwayuu) {
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

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Irruko getIrruko() {
        return irruko;
    }

    public void setIrruko(Irruko irruko) {
        this.irruko = irruko;
    }

    public Luma getLuma() {
        return luma;
    }

    public void setLuma(Luma luma) {
        this.luma = luma;
    }

    public TipEducacion getTipEdu() {
        return tipEdu;
    }

    public void setTipEdu(TipEducacion tipEdu) {
        this.tipEdu = tipEdu;
    }

    public TipOcupacion getTipOcupacion() {
        return tipOcupacion;
    }

    public void setTipOcupacion(TipOcupacion tipOcupacion) {
        this.tipOcupacion = tipOcupacion;
    }

    public TipPariente getParentesco() {
        return parentesco;
    }

    public void setParentesco(TipPariente parentesco) {
        this.parentesco = parentesco;
    }

    public TipProfesion getProfesion() {
        return profesion;
    }

    public void setProfesion(TipProfesion profesion) {
        this.profesion = profesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwayuu != null ? idwayuu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wayuu)) {
            return false;
        }
        Wayuu other = (Wayuu) object;
        if ((this.idwayuu == null && other.idwayuu != null) || (this.idwayuu != null && !this.idwayuu.equals(other.idwayuu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Wayuu[ idwayuu=" + idwayuu + " ]";
    }
    
}
