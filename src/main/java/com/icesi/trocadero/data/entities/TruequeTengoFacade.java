/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icesi.trocadero.data.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Elmer Jose Diaz Lazo
 * @email elmerdiazlazo@gmail.com
 * @date 3/10/2013
 */
@Stateless
public class TruequeTengoFacade extends AbstractFacade<TruequeTengo> {
    @PersistenceContext(unitName = "demo_trocadero_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TruequeTengoFacade() {
        super(TruequeTengo.class);
    }

}
