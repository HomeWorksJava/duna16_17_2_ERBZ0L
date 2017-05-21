/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacek;


import alapok.Hangoskonyv;
import java.util.List;

/**
 *
 * @author Bacton
 */
public interface HangoskonyvService {
    public List<Hangoskonyv> getAll();
    public Hangoskonyv getHangoskonyvById(Long pId);
    public Hangoskonyv getHangoskonyvByCim(String pCim);
    public void save(Hangoskonyv pHangoskonyv);
}
