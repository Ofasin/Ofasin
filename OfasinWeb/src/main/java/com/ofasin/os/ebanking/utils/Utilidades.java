/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.utils;

import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author HeidelberGonzalez
 */
public class Utilidades {
    public static Object getEJBRemote1(String nameEJB,String iface)throws Exception{
        Context context;
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.put(Context.PROVIDER_URL, "http://localhost:8080");
        try {
            context= new InitialContext(props);
            String lookup = nameEJB+"#"+iface;
            
            return context.lookup(lookup);
        } catch (Exception e) {
            throw new Exception("NO se encontro el Bean: "+nameEJB);
        }
}
    
    public static Object getEJBRemote(String beanName, String viewClassName)throws Exception{
       final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final String appName = "OfasinProcesos-ear-1.0-SNAPSHOT";
        final String moduleName = "OfasinProcesos-ejb-1.0-SNAPSHOT";
        final String distinctName = "";
        final Context context = new InitialContext(jndiProperties);
        String lookup = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.err.println("lookup: "+lookup);
        Object obj = context.lookup(lookup);
        return obj;
        
} 
    public static Object getEJBRemote3(String nameEJB, String iface) throws Exception {
        Context context;
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        props.put(Context.PROVIDER_URL, "http://localhost:7001");
        try {
            context = new InitialContext(props);
            String lookup = nameEJB+"#"+iface;
            System.out.println("Lookup: "+lookup);
            return context.lookup(lookup);
        } catch(Exception ex) {
            throw new Exception("No se encontro el EJB: '"+nameEJB+"'.");
        }
    }
}
