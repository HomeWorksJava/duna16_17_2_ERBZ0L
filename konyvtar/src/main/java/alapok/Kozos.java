/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alapok;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bacton
 */
@Entity
public class Kozos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String cim;
    protected String kiado;
    protected Integer megjelenesiev;

    /*public Kozos(long id, String cim, String kiado, Integer megjelenesiev) {
        this.id = id;
        this.cim = cim;
        this.kiado = kiado;
        this.megjelenesiev = megjelenesiev;
    }*/

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getKiado() {
        return kiado;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public Integer getMegjelenesiev() {
        return megjelenesiev;
    }

    public void setMegjelenesiev(Integer megjelenesiev) {
        this.megjelenesiev = megjelenesiev;
    }

    
    
    
    
}
