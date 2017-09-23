/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IRole;
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
public class RoleController implements IRole {

    private SessionFactory _sessionFactory;
    private Session _session;

    public RoleController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
          _session = _sessionFactory.openSession();
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = _session.createQuery("From Role").list();
        if (null == roles || roles.isEmpty()) {
            return null;
        }
        return roles;
    }

    @Override
    public Role get(int roCode) {
        Object objRole = _session.get(Role.class, roCode);
        if (null == objRole) {
            return null;
        }
        return (Role) objRole;
    }

    @Override
    public List<User> getUsers(Role role) {
        List<User> users = _session.createQuery("select U  From UserRole U where U.role.roCode = " + role.getRoCode()).list();
        if (null == users || users.isEmpty()) {
            return null;
        }
        return users;
    }

    @Override
    public List<User> getUsers(int roCode) {
        List<User> users = _session.createQuery("select U  From UserRole U where U.role.roCode = " + roCode).list();
        if (null == users || users.isEmpty()) {
            return null;
        }
        return users;
    }

    @Override
    public int add(Role role) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(role);
            tx.commit();
            return role.getRoCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Role role) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(role);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Role role) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.delete(role);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int roCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Role where RoCode= " + roCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }   

    @Override
    public int assignAction(RoleAction roleAction) {
        try {
            if (null == roleAction || 
                    null == roleAction.getRole() ||
                    null == roleAction.getAction()) {
                return -1;
            }
            Transaction tx = _session.beginTransaction();
            _session.save(roleAction);
            tx.commit();
            return roleAction.getRoActionCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public int assignAction(int roCode, int actCode) {
        try {
            if (roCode <= 0 || actCode <= 0) {
                return -1;
            }
            Role role = get(roCode);
            ActionController controller = new ActionController();
            Action action = controller.get(actCode);

            if (null == role || null == action) {
                return -1;
            }
            RoleAction roleAction = new RoleAction();
            roleAction.setAction(action);
            roleAction.setRole(role);

            Transaction tx = _session.beginTransaction();
            _session.save(roleAction);
            tx.commit();
            return roleAction.getRoActionCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<Action> getActions(Role role) {
        if (null == role) {
            return null;
        }
        ActionController controller = new ActionController();
        return controller.getByRole(role.getRoCode());
    }

    @Override
    public List<Action> getActions(int roCode) {
        ActionController controller = new ActionController();
        return controller.getByRole(roCode);
    }

    @Override
    public boolean removeAction(RoleAction roleAction) {
        try {
             if (null == roleAction || 
                    null == roleAction.getRole() ||
                    null == roleAction.getAction()) {
                return false;
            }
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from RoleAction where RoCode= " + roleAction.getRole().getRoCode() + 
                    " and ActCode = " + roleAction.getAction().getActCode()).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean assignUser(int roCode, int usrCode) {
        UserController controller = new UserController();
        return controller.assignToRole(roCode, usrCode);
    }

    @Override
    public boolean assignUser(UserRole userrole) {
       if ( null == userrole || 
                null == userrole.getRole()||
                null == userrole.getUser())
            return false;
        UserController controller = new UserController();
        return controller.assignRole(userrole);
    }

    @Override
    public boolean removeUser(int roCode, int usrCode) {
         
        UserController controller = new UserController();
        return controller.removeRole(roCode, usrCode);
    }

    @Override
    public boolean removeUser(UserRole userrole) {
        if ( null == userrole || 
                null == userrole.getRole()||
                null == userrole.getUser())
            return false;
        UserController controller = new UserController();
        return controller.removeRole(userrole);
    }

}
