/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IUser;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Khalil Bsaibes
 */
public class UserController implements IUser {

    private SessionFactory _sessionFactory;
    private Session _session;

    public UserController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    @Override
    public List<User> getAll() {
        List<User> users = _session.createQuery("From User").list();
        if (null == users || users.isEmpty()) {
            return null;
        }
        return users;
    }

    @Override
    public List<User> getByBranch(int brCode) {
        List<User> users = _session.createQuery("Select User.* From User, UserRole, BranchRole where "
                + "User.UsrCode = UserRole.UsrCode and UserRole.RoCode = BranchRole.RoCode and BranchRole.BrCode = " + brCode).list();
        if (null == users || users.isEmpty()) {
            return null;
        }
        return users;
    }

    @Override
    public User get(int usrCode) {
        Object objUser = _session.get(User.class, usrCode);
        if (null == objUser) {
            return null;
        }
        return (User) objUser;
    }

    @Override
    public List<Role> getRoles(User user) {
        List<Role> roles = _session.createQuery("Select Role.* From User, UserRole where "
                + "User.UsrCode = UserRole.UsrCode and User.UsrCode =  " + user.getUsrCode()).list();
        if (null == roles || roles.isEmpty()) {
            return null;
        }
        return roles;
    }

    @Override
    public List<Role> getRoles(int usrCode) {
        List<Role> roles = _session.createQuery("Select Role.* From User, UserRole where "
                + "User.UsrCode = UserRole.UsrCode and User.UsrCode =  " + usrCode).list();
        if (null == roles || roles.isEmpty()) {
            return null;
        }
        return roles;
    }

    @Override
    public List<Action> getAllowedActions(int usrCode) {
        List<Action> actions = _session.createQuery("Select Action.* From User, UserRole, RoleAction where "
                + "User.UsrCode = UserRole.UsrCode and UserRole.RoCode =  RoleAction.RoCode and User.UsrCode = " + usrCode).list();
        if (null == actions || actions.isEmpty()) {
            return null;
        }
        
        return actions;
    }
    
     @Override
    public List<Action> getAllowedActions(UserBranch userBranch ) {
        if ( null == userBranch )
            return null;
        List<Action> actions = _session.createQuery("Select Action.* From User, UserRole, RoleAction,RoleBranch where "
                + "User.UsrCode = UserRole.UsrCode and UserRole.RoCode =  RoleAction.RoCode and RoleBranch.RoCode = UserRole.RoCode and User.UsrCode = " + userBranch.getUserCode() +" and RoleBranch.BrCode = "+userBranch.getBrCode()).list();
        if (null == actions || actions.isEmpty()) {
            return null;
        }
        return actions;
    }

    @Override
    public List<Action> getAllowedActions(User user) {
        List<Action> actions = _session.createQuery("Select Action.* From User, UserRole, RoleAction where "
                + "User.UsrCode = UserRole.UsrCode and UserRole.RoCode =  RoleAction.RoCode and User.UsrCode = " + user.getUsrCode()).list();
        if (null == actions || actions.isEmpty()) {
            return null;
        }
        return actions;
    }

    
    @Override
    public int add(User user) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(user);
            tx.commit();
            return user.getUsrCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(User user) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(User user) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.delete(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int usrCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from User where UsrCode= " + usrCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean assignRole(UserRole userRole) {
        try {
            if (null == userRole || 
                    null == userRole.getRole() ||
                    null == userRole.getUser()) {
                return false;
            }
            Transaction tx = _session.beginTransaction();
            _session.save(userRole);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean assignToRole(int roCode, int usrCode) {
        try {
            RoleController controller = new RoleController();
            Role role = controller.get(roCode);
            User user = get(usrCode);
            if (null == role || null == user) {
                return false;
            }
            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);
            Transaction tx = _session.beginTransaction();
            _session.save(userRole);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

        @Override
    public boolean removeRole(UserRole userRole) {
        try {
             if (null == userRole || 
                    null == userRole.getRole() ||
                    null == userRole.getUser()) {
                return false;
            }
             
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from UserRole where UsrCode= " + userRole.getUser().getUsrCode() +" RoCode ="+userRole.getRole().getRoCode()).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }
    
    @Override
    public boolean removeRole(int roCode, int usrCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from UserRole where UsrCode= " + usrCode +" RoCode ="+roCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public User login(User user) {
        if ( null == user)
            return null;
        
         List<User> users = _session.createQuery("From User where "
                + "UsrUsername = '"+user.getUsrUsername()+"' and UsrPassword= '"+user.getUsrPassword()+"'").list();
        if (null == users || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

}
