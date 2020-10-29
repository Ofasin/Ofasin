/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.utils;


import com.ofasin.os.ebanking.model.DominioUsers;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@ManagedBean
@SessionScoped
public class ImageStreamUserLog implements Serializable {
private StreamedContent imagem;
private StreamedContent imagem2;
    private BufferedImageOp op;
    
  public StreamedContent getImagem2() {
        return imagem2;
    }

    public void setImagem2(StreamedContent imagem2) {
        this.imagem2 = imagem2;
    }
public StreamedContent getImagem() {
        return imagem;
    }

    public void setImagem(StreamedContent imagem) {
        this.imagem = imagem;
    }
    
    
    public StreamedContent getFoto(byte[] obj) throws IOException {
        System.out.println("\nLlega ok1");
        FacesContext context = FacesContext.getCurrentInstance();

      /*   if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            System.out.println("\nLlega ok2");
            return new DefaultStreamedContent();
        } else {
        /*   String ids = context.getExternalContext().getRequestParameterMap().get("id");
            System.out.println("ids : "+ids);
            Long id = Long.valueOf(ids);
            System.out.println("foto" + id);
            String hql = "select vo from Foto vo where vo.id=" + id + "";
            System.out.println(hql);
            StreamedContent i = new DefaultStreamedContent(
                    new ByteArrayInputStream(
                            new FotoController().pegar(hql).getArquivo()));*/
           // return i;
           
           DefaultStreamedContent content = null;
           
           if (obj != null &&  obj.length > 0) {
			
               BufferedImage img = ImageIO.read(new ByteArrayInputStream(obj));
               Graphics2D g2 = img.createGraphics();
               op= null;
               g2.drawImage(img, op, 0, 0);
               ByteArrayOutputStream os = new ByteArrayOutputStream();
               ImageIO.write(img, "png", os);
               //FileInputStream fi = new FileInputStream(file);
               imagem= null;
               imagem = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png"); 
               setImagem2(new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png"));
              // byte[] imagem = obj;
                        
			//content = new DefaultStreamedContent(new ByteArrayInputStream(imagem), "image/jpg", "foto.jpg");
                       // System.out.println("\nLlega ok");
                       // System.out.println("\nimagem.leng : "+(int)obj.length);
                        // System.out.println("\nByte :"+Arrays.toString(obj));
                       //  System.out.println("\nddd ------------------------------- " + imagem.toString());
                        
		}
		      
		return imagem;
        }
   // }
public StreamedContent getImagen(byte[] obj) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
 
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
 
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(obj));
			int w = img.getWidth(null);
			int h = img.getHeight(null);
 
			// image is scaled two times at run time
			int scale = 2;
 
			BufferedImage bi = new BufferedImage(w * scale, h * scale,
					BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.getGraphics();
 
			g.drawImage(img, 10, 10, w * scale, h * scale, null);
 
			ImageIO.write(bi, "png", bos);
 
			return new DefaultStreamedContent(new ByteArrayInputStream(
					bos.toByteArray()), "image/png");
 
		}
	}
   
public StreamedContent getImageFromDB() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
 
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
 
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
			// Reading image from database assuming that product image (bytes)
			// of product id I1 which is already stored in the database.
                        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
                        HttpSession session = attr.getRequest().getSession(true);
                        DominioUsers user=  (DominioUsers) session.getAttribute("userInSession");
			byte[] image = user.getIdusuario().getArchivo();
			
 
			return new DefaultStreamedContent(new ByteArrayInputStream(image),
					"image/png");
 
		}
	}
    

   
}
