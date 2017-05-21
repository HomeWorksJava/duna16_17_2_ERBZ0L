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
@NamedQueries({@NamedQuery(name = "Film.osszes", query = "SELECT f FROM Film f"),
               @NamedQuery(name = "Film.searchById", query = "SELECT f FROM Film f WHERE f.id = :id"),
               @NamedQuery(name = "Film.searchByCim", query = "SELECT f FROM Film f WHERE f.cim = :cim"),
})
public class Film extends Hangoskonyv implements Serializable{
    private String felbontas;

   /*public Film(String felbontas, Integer hossz, long id, String cim, String kiado, Integer megjelenesiev) {
        super(hossz, id, cim, kiado, megjelenesiev);
        this.felbontas = felbontas;
    }*/

    

    
    public String getFelbontas() {
        return felbontas;
    }

    public void setFelbontas(String felbontas) {
        this.felbontas = felbontas;
    }
    
}
