/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciok;

import alapok.Film;
import genericdaoservice.GenericDaoService;
import genericdaoservice.GenericDaoServiceImpl;
import interfacek.FilmService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Bacton
 */
@Stateless
public class FilmServiceImpl implements FilmService{
    @Inject
    GenericDaoService gds;
    @Override
    public List<Film> getAll() {
       return (List<Film>)gds.getEntities("Film.osszes", new HashMap<>());
    }

    @Override
    public Film getFilmById(Long pId) {
       HashMap<String,Object> params = new HashMap<>();
       params.put("id", pId);
       return (Film)gds.getEntities("Film.searchById", params);
    
    }

    @Override
    public Film getFilmByCim(String pCim) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("cim", pCim);
        return (Film)gds.getEntities("Film.searchByCim", params);
    }

    @Override
    public void save(Film pFilm) {
        gds.save(pFilm);
    }
    
}
