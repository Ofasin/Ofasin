package com.ofasin.os.ebanking.bean;

import com.ofasin.os.ebanking.details.Usuario;
import com.ofasin.os.ebanking.model.DominioUsers;
import com.ofasin.os.ebanking.business.UsersLoginIface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author HeidelberGonzalezIguaran
 */

public class BeanLogin implements AuthenticationProvider {
    private UsersLoginIface serviceLogin;
    String roll;

    
    /**
     * @return the serviceLogin
     */
    public UsersLoginIface getServiceLogin() {
        return serviceLogin;
    }
    
    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    /**
     * @param serviceLogin the serviceLogin to set
     */
    public void setServiceLogin(UsersLoginIface serviceLogin) {
        this.serviceLogin = serviceLogin;
    }

    public boolean userExist(DominioUsers user) {
        try {
            user = getServiceLogin().Login(user);
            if(user.isStatus()) {
                setRoll(user.getIdroll().getNombre());
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userLogin = authentication.getPrincipal().toString();
        String passwordLogin = authentication.getCredentials().toString();
        System.out.println("EnBeanLoginAlIrUser: " + userLogin);
        System.out.println("EnBeanLoginAlIrPassword: " + passwordLogin);
        DominioUsers user = new DominioUsers();
        user.setUser(userLogin);
        user.setPassword(passwordLogin);
        if(userExist(user)) {
            List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();
            //autoridades.add(new SimpleGrantedAuthority("ROLE_USER"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_VIP"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_VENDEDOR"));
            autoridades.add(new SimpleGrantedAuthority(getRoll()));
            Usuario userDetails = new Usuario();
            userDetails.setUsername(userLogin);
            userDetails.setPassword(passwordLogin);
            userDetails.setFecha(new Date());
            userDetails.setNombre(userLogin);
            Authentication customAuthentication = new UsernamePasswordAuthenticationToken(userDetails, 
                    passwordLogin, autoridades);
            BeanMenu menu = new BeanMenu();
            menu.setUser(user);
            menu.setVisibleMenu(true);
            menu.setDisInicio(true);
            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("beanMenu", menu);
            session.setAttribute("userInSession", user);
            return customAuthentication;
        } else {
            System.out.println("Usuario o Contraseña Inválidos.");
            throw new BadCredentialsException("Usuario o Contraseña Inválidos.");
        }
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
}
