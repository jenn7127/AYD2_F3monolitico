/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase.fas2.jpa;

import fase.fas2.modelo.Asignacionvehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jenni
 */
@Stateless
public class AsignacionvehiculoFacade extends AbstractFacade<Asignacionvehiculo> {

    @PersistenceContext(unitName = "Fase2MonolitoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionvehiculoFacade() {
        super(Asignacionvehiculo.class);
    }
    
}
