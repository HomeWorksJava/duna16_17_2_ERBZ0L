/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciok;

import alapok.Konyv;
import genericdaoservice.GenericDaoService;
import genericdaoservice.GenericDaoServiceImpl;
import interfacek.KonyvService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Bacton
 */
@Stateless
public class KonyvServiceImpl implements KonyvService{
    @Inject
    GenericDaoService gds;
    
    @Override
    public List<Konyv> getAll(){
        return (List<Konyv>)gds.getEntities("Konyv.osszes", new HashMap<>());
    }

    @Override
    public Konyv getKonyvByIro(String pIro) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("iro", pIro);
        return (Konyv)gds.getEntity("Konyv.getKonyvByIro", params);
    }

    @Override
    public Konyv getKonyvById(Long pId) {
       HashMap<String,Object> params = new HashMap<>();
       params.put("id", pId);
       return (Konyv)gds.getEntity("Konyv.getKonyvById", params);
    }

    @Override
    public Konyv getKonyvByCim(String pCim) {
    HashMap<String,Object> params = new HashMap<>();
    params.put("cim", pCim);
    return (Konyv)gds.getEntities("Konyv.getKonyvByCim", params);
    }

    @Override
    public void save(Konyv pKonyv) {
    gds.save(pKonyv);    
    }
}
