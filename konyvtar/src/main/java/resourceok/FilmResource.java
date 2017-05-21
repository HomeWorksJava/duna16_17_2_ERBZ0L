/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceok;

import alapok.Film;
import interfacek.FilmService;
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
@Path("film")
@RequestScoped
public class FilmResource {
    @Inject
           FilmService filmserv;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
    public FilmResource(){
        log.info("FilmResource peldany letrejott");
    }
 @GET
 @Path("osszes")
 @Produces(MediaType.APPLICATION_JSON)
 public List<Film> getFilm()
 {
     return filmserv.getAll();
 }
 @GET
 @Path("cim")
 @Produces(MediaType.APPLICATION_JSON)
 public Film getFilmByCim (/*@PathParam("iro")*/String cim)
 {
    return filmserv.getFilmByCim(cim);
 }
 @GET
 @Path("id")
 @Produces(MediaType.APPLICATION_JSON)
 public Film getFilmById (/*@PathParam("iro")*/Long id)
 {
    return filmserv.getFilmById(id);
 }
 @POST
 @Path("hozzaad")
 @Produces(MediaType.TEXT_PLAIN)
    public String insertFilm(@FormParam("cim")String cim,
                            @FormParam("kiado")String kiado,
                            @FormParam("megjelenesiev")String megjelenesiev,
                            @FormParam("hossz")String hossz,
                            @FormParam("felbontas")String felbontas)
    {
        Film film = new Film();
         
        try
        {
           film.setHossz(Integer.parseInt(hossz));
           film.setMegjelenesiev(Integer.parseInt(megjelenesiev));
        }
        catch(NumberFormatException ex)
        {
           log.error("Nem szam",ex);
        }        
           film.setCim(cim);
           film.setKiado(kiado);
           film.setFelbontas(felbontas);
            
//            em.getTransaction().begin();
           filmserv.save(film);
//            em.getTransaction().commit();
          
          return " ok ";
      }
}
