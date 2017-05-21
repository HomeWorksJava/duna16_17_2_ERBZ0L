/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacek;

import alapok.Konyv;
import java.util.List;

/**
 *
 * @author Bacton
 */
public interface KonyvService {
    public List<Konyv> getAll();
    public Konyv getKonyvByIro(String pIro);
    public Konyv getKonyvById(Long pId);
    public Konyv getKonyvByCim(String pCim);
    public void save(Konyv pKonyv);
}
