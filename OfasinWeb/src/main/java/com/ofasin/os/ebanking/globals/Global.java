

package com.ofasin.os.ebanking.globals;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Global {
    public final static String GENERAL = "General";
    public final static String INTERMEDIO = "Intermedio";
    public final static String ESPECIAL = "Especial";
    
    public static HttpSession getSession() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return (HttpSession)fc.getExternalContext().getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
        return request;
    }
    
    
    
    public static FacesContext getFC() {
        return FacesContext.getCurrentInstance();
    }
    
    public static void addMsg(String titulo, String msg) {
        FacesMessage mensaje = new FacesMessage(titulo, msg);
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public static void addMsgErr(String titulo, String msg) {
        FacesMessage mensaje = new FacesMessage(titulo, msg);
        mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public static void addMsgNulos(String msg) {
        FacesMessage mensaje = new FacesMessage("Campos Requeridos", msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public static void addRedir(String url){
        try {/*
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.redirect(url);
            */
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
            
        } catch (IOException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String getPropRB(String key) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "props");
        return bundle.getString(key);
    }
    
    public static java.util.Date getFechaHoy() {
        return new java.util.Date();
    }
    
    public static java.sql.Timestamp getFechaHoraHoy() {
        long ms = getFechaHoy().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(ms);
        return ts;
    }
}
