/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mi6.remote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mi6.entities.User;

/**
 *
 * @author AgtLucas
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements mi6.remote.UserFacadeRemote {
    @PersistenceContext(unitName = "YoloAvenger-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
}
