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
@NamedQueries({
        @NamedQuery(name = "Konyv.osszes", query = "SELECT k FROM Konyv k"),
        @NamedQuery(name = "Konyv.getKonyvByIro", query = "SELECT k FROM Konyv k WHERE k.iro = :iro"),
        @NamedQuery(name = "Konyv.getKonyvById", query = "SELECT k FROM Konyv k WHERE k.id = :id"),
        @NamedQuery(name = "Konyv.getKonyvByCim", query = "SELECT k FROM Konyv k WHERE k.cim = :cim")})
public class Konyv extends Kozos implements Serializable {
    private String iro;

    /*public Konyv(String iro, long id, String cim, String kiado, Integer megjelenesiev) {
        super(id, cim, kiado, megjelenesiev);
        this.iro = iro;
    }*/

    public String getIro() {
        return iro;
    }

    public void setIro(String iro) {
        this.iro = iro;
    }
    
}
