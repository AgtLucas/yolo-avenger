/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yoloavengertest;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mi6.entities.Role;
import mi6.entities.User;
import mi6.remote.RoleFacadeRemote;
import mi6.remote.UserFacadeRemote;

/**
 *
 * @author AgtLucas
 */
public class YoloAvengerTest {
    
    private static final String JNDI_NAME
            = "java:global/YoloAvenger/YoloAvenger-ejb/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InitialContext ctx;
        Properties props = new Properties();
        try {
            props.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs",
                    "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");           
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            ctx = new InitialContext(props);                        
            UserFacadeRemote user = (UserFacadeRemote) ctx.lookup(JNDI_NAME + "UserFacade");                
            RoleFacadeRemote role = (RoleFacadeRemote) ctx.lookup(JNDI_NAME + "RoleFacade");
            
            System.out.println("Deleting users...");
            List<User> ltu = user.findAll();
            for(User uuu: ltu) {
                user.remove(uuu);
            }
            System.out.println("");
            
            System.out.println("Deleting roles...");
            List<Role> ltr = role.findAll();
            for(Role rrr: ltr) {
                role.remove(rrr);
            }
            System.out.println("");
            
            System.out.println("Creating user....");
            User uu = new User();
            uu.setName("Lucas");
            user.create(uu);
            System.out.println("User created!");
            System.out.println("");
            
            System.out.println("Creating role....");
            Role rr = new Role();
            rr.setName("Spy");
            role.create(rr);
            System.out.println("Role created!");  
            System.out.println("");
            
            List<User> listuser = user.findAll();            
            User u;
            System.out.println("=== Users ===");
            for (int i = 0; i < listuser.size(); i++) {
                u = (User) listuser.get(i);
                System.out.println("ID: " + u.getId() + " - Nome: " + u.getName());                
            }  
            System.out.println("Total of users: " + user.count());                                    
            
            System.out.println("");
            System.out.println("=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=");
            System.out.println("");
                        
            List<Role> listrole = role.findAll();            
            Role r;
            System.out.println("=== Roles ===");
            for (int i = 0; i < listrole.size(); i++) {
                r = (Role) listrole.get(i);
                System.out.println("ID: " + r.getId() + " - Nome: " + r.getName());                
            }  
            System.out.println("Total of roles: " + role.count());
            
        } catch (NamingException ex) {
            Logger.getLogger(YoloAvengerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
