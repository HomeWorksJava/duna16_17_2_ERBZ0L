/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacek;

import alapok.Film;
import java.util.List;

/**
 *
 * @author Bacton
 */
public interface FilmService {
    public List<Film> getAll();
    public Film getFilmById(Long pId);
    public Film getFilmByCim(String pCim);
    public void save(Film pFilm);
}
