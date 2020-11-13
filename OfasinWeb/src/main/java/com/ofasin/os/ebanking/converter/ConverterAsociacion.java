/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.ofasin.os.ebanking.model.DominioAsociacion;
import com.ofasin.os.ebanking.bean.BeanAsociacion;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Heidelber Gonzalez Iguaran
 */
public class ConverterAsociacion implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!value.equals("")) {
                        BeanAsociacion beanAsociacion = new BeanAsociacion();
                        DominioAsociacion dominioAsociacion = new DominioAsociacion();
                        dominioAsociacion.setIdasocicion(Long.valueOf(value));
            try {
                dominioAsociacion = beanAsociacion.getById(dominioAsociacion);
            } catch (Exception ex) {
                Logger.getLogger(ConverterAsociacion.class.getName()).log(Level.SEVERE, null, ex);
            }
			return dominioAsociacion;
		} else {
			return null;
		}
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
			DominioAsociacion tipPro = (DominioAsociacion) value;
			return String.valueOf(tipPro.getIdasocicion());
		} else {
			return null;
		}
    }
    
}
