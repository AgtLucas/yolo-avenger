/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mi6.remote;

import java.util.List;
import javax.ejb.Remote;
import mi6.entities.UserRole;

/**
 *
 * @author AgtLucas
 */
@Remote
public interface UserRoleFacadeRemote {

    void create(UserRole userRole);

    void edit(UserRole userRole);

    void remove(UserRole userRole);

    UserRole find(Object id);

    List<UserRole> findAll();

    List<UserRole> findRange(int[] range);

    int count();
    
}
