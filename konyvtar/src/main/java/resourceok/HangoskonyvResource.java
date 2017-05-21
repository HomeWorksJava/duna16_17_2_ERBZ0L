/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceok;

import alapok.Hangoskonyv;
import interfacek.HangoskonyvService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Bacton
 */
@Path("hangoskonyv")
@RequestScoped
public class HangoskonyvResource {
    @Inject
           HangoskonyvService hangoskonyvserv;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
    public HangoskonyvResource(){
        log.info("HangoskonyvResource peldany letrejott");
    }
 @GET
 @Path("osszes")
 @Produces(MediaType.APPLICATION_JSON)
 public List<Hangoskonyv> getHangoskonyv()
 {
     return hangoskonyvserv.getAll();
 }
 @GET
 @Path("cim")
 @Produces(MediaType.APPLICATION_JSON)
 public Hangoskonyv getHangoskonyvByCim (/*@PathParam("iro")*/String cim)
 {
    return hangoskonyvserv.getHangoskonyvByCim(cim);
 }
 @GET
 @Path("id")
 @Produces(MediaType.APPLICATION_JSON)
 public Hangoskonyv getHangoskonyvById (/*@PathParam("iro")*/Long id)
 {
    return hangoskonyvserv.getHangoskonyvById(id);
 }
 @POST
 @Path("hozzaad")
 @Produces(MediaType.TEXT_PLAIN)
    public String insertHangoskonyv(@FormParam("cim")String cim,
                            @FormParam("kiado")String kiado,
                            @FormParam("megjelenesiev")String megjelenesiev,
                            @FormParam("hossz")String hossz)
    {
        Hangoskonyv hangoskonyv = new Hangoskonyv();
         
        try
        {
           hangoskonyv.setHossz(Integer.parseInt(hossz));
           hangoskonyv.setMegjelenesiev(Integer.parseInt(megjelenesiev));
        }
        catch(NumberFormatException ex)
        {
           log.error("Nem szam",ex);
        }        
           hangoskonyv.setCim(cim);
           hangoskonyv.setKiado(kiado);
            
//            em.getTransaction().begin();
           hangoskonyvserv.save(hangoskonyv);
//            em.getTransaction().commit();
          
          return " ok ";
      }
}
