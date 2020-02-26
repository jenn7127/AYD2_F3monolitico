/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase.fas2.jpa;

import fase.fas2.modelo.Flotilla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jenni
 */
@Stateless
public class FlotillaFacade extends AbstractFacade<Flotilla> {

    @PersistenceContext(unitName = "Fase2MonolitoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlotillaFacade() {
        super(Flotilla.class);
    }
    
}
