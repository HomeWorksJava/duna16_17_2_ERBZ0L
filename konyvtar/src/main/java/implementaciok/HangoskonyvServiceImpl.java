/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciok;

import alapok.Hangoskonyv;
import genericdaoservice.GenericDaoService;
import genericdaoservice.GenericDaoServiceImpl;
import interfacek.HangoskonyvService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Bacton
 */
@Stateless
public class HangoskonyvServiceImpl implements HangoskonyvService{
    @Inject
    GenericDaoService gds;
    @Override
    public List<Hangoskonyv> getAll() {
        return (List<Hangoskonyv>)gds.getEntities("Hangoskonyv.osszes", new HashMap<>());
    }

    @Override
    public Hangoskonyv getHangoskonyvById(Long pId) {
       HashMap<String,Object> params = new HashMap<>();
       params.put("id", pId);
       return (Hangoskonyv)gds.getEntities("Hangoskonyv.searchById", params);
    }

    @Override
    public Hangoskonyv getHangoskonyvByCim(String pCim) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("cim", pCim);
        return (Hangoskonyv)gds.getEntities("Hangoskonyv.searchByCim", params);
    }

    @Override
    public void save(Hangoskonyv pHangoskonyv) {
    gds.save(pHangoskonyv);
    }
    
}
