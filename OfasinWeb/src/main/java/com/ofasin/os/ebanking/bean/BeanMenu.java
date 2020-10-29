/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.model.DominioUsers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HeidelberGonzalezIguaran
 */
public class BeanMenu implements Serializable {
    private DominioUsers user;
    private boolean visibleMenu = false;
    private boolean disInicio;
    private boolean disUsuarios;
    private boolean disAlumnos;
    private boolean disArticulos;
    private List<String> imgInventarios;
    
    private void resetMenu() {
        setDisAlumnos(false);
        setDisArticulos(false);
        setDisInicio(false);
        setDisUsuarios(false);
    }
    
    public void loadInventario() {
        String resources = "http://javarevolutions.com/resources/site/javarev/images/";
        String urlInventarios = resources+"SistemaInventarios/";
        imgInventarios = new ArrayList<String>();
        for(int i = 1; i <= 12; i++) {
            imgInventarios.add(urlInventarios+"inventarios"+(i)+".png");
        }
    }

    /**
     * @return the user
     */
    public DominioUsers getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(DominioUsers user) {
        this.user = user;
    }

    /**
     * @return the visibleMenu
     */
    public boolean isVisibleMenu() {
        return visibleMenu;
    }

    /**
     * @param visibleMenu the visibleMenu to set
     */
    public void setVisibleMenu(boolean visibleMenu) {
        this.visibleMenu = visibleMenu;
    }

    /**
     * @return the disInicio
     */
    public boolean isDisInicio() {
        return disInicio;
    }

    /**
     * @param disInicio the disInicio to set
     */
    public void setDisInicio(boolean disInicio) {
        this.disInicio = disInicio;
    }

    /**
     * @return the disUsuarios
     */
    public boolean isDisUsuarios() {
        return disUsuarios;
    }

    /**
     * @param disUsuarios the disUsuarios to set
     */
    public void setDisUsuarios(boolean disUsuarios) {
        this.disUsuarios = disUsuarios;
    }

    /**
     * @return the disAlumnos
     */
    public boolean isDisAlumnos() {
        return disAlumnos;
    }

    /**
     * @param disAlumnos the disAlumnos to set
     */
    public void setDisAlumnos(boolean disAlumnos) {
        this.disAlumnos = disAlumnos;
    }

    /**
     * @return the disArticulos
     */
    public boolean isDisArticulos() {
        return disArticulos;
    }

    /**
     * @param disArticulos the disArticulos to set
     */
    public void setDisArticulos(boolean disArticulos) {
        this.disArticulos = disArticulos;
    }

    /**
     * @return the imgInventarios
     */
    public List<String> getImgInventarios() {
        return imgInventarios;
    }

    /**
     * @param imgInventarios the imgInventarios to set
     */
    public void setImgInventarios(List<String> imgInventarios) {
        this.imgInventarios = imgInventarios;
    }
    
    public String disabledInicio() {
        resetMenu();
        setDisInicio(true);
        return "/content/welcome?faces-redirect=true";
    }
    
    public String disabledUsuarios() {
        resetMenu();
        setDisUsuarios(true);
        return "/content/usuarios/users?faces-redirect=true";
    }
    
    public String disabledAlumnos() {
        resetMenu();
        setDisAlumnos(true);
        return "/content/alumnos/students?faces-redirect=true";
    }
    
    public String disabledArticulos() {
        resetMenu();
        setDisArticulos(true);
        return "/content/articulos/products?faces-redirect=true";
    }
}
