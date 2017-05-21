/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceok;

import alapok.Konyv;
import interfacek.KonyvService;
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
@Path("konyv")
@RequestScoped
public class KonyvResource {
    @Inject
           KonyvService konyvserv;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
    public KonyvResource(){
        log.info("KonyvResource peldany letrejott");
    }
    
 @GET
 @Path("osszes")
 @Produces(MediaType.APPLICATION_JSON)
 public List<Konyv> getKonyv()
 {
     return konyvserv.getAll();
 }
 @GET
 @Path("iro")
 @Produces(MediaType.APPLICATION_JSON)
 public Konyv getKonyvByIro (/*@PathParam("iro")*/String iro)
 {
    return konyvserv.getKonyvByIro(iro);
 }
 @GET
 @Path("cim")
 @Produces(MediaType.APPLICATION_JSON)
 public Konyv getKonyvByCim (/*@PathParam("iro")*/String cim)
 {
    return konyvserv.getKonyvByCim(cim);
 }
 @GET
 @Path("id")
 @Produces(MediaType.APPLICATION_JSON)
 public Konyv getKonyvById (/*@PathParam("iro")*/Long Id)
 {
    return konyvserv.getKonyvById(Id);
 }
 @POST
 @Path("hozzaad")
 @Produces(MediaType.TEXT_PLAIN)
    public String insertKonyv(@FormParam("cim")String cim,
                            @FormParam("kiado")String kiado,
                            @FormParam("megjelenesiev")String megjelenesiev,
                            @FormParam("iro")String iro)
                           
    {
        Konyv konyv = new Konyv();
         
        try
        {
           konyv.setMegjelenesiev(Integer.parseInt(megjelenesiev));
        }
        catch(NumberFormatException ex)
        {
           log.error("Nem szam",ex);
        }        
           konyv.setCim(cim);
           konyv.setKiado(kiado);
           konyv.setIro(iro);
            
//            em.getTransaction().begin();
           konyvserv.save(konyv);
//            em.getTransaction().commit();
          
          return " ok ";
      }
}
