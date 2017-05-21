/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alapok;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Bacton
 */
@Entity
@NamedQueries({@NamedQuery(name = "Hangoskonyv.osszes", query = "SELECT h FROM Hangoskonyv h"),
               @NamedQuery(name = "Hangoskonyv.searchById", query = "SELECT h FROM Hangoskonyv h WHERE h.id = :id"),
               @NamedQuery(name = "Hangoskonyv.searchByCim", query = "SELECT h FROM Hangoskonyv h WHERE h.cim = :cim"),
})
public class Hangoskonyv extends Kozos implements Serializable{
    protected Integer hossz;

    /*public Hangoskonyv(Integer hossz, Long id, String cim, String kiado, Integer megjelenesiev) {
        super(id, cim, kiado, megjelenesiev);
        this.hossz = hossz;
    }*/

    
    public Integer getHossz() {
        return hossz;
    }

    public void setHossz(Integer hossz) {
        this.hossz = hossz;
    }
    
}
