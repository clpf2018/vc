/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IAction;
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
public class ActionController implements IAction {

    private SessionFactory _sessionFactory;
    private Session _session;

    public ActionController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }
    @Override
    public Action get(int actCode) {
       Object objAction = _session.get(Action.class, actCode);
        if (null == objAction) {
            return null;
        }
        return (Action) objAction;
    }

    @Override
    public List<Action> getAll() {
       List<Action> actions = _session.createQuery("From Action").list();
        if (null == actions || actions.isEmpty()) {
            return null;
        }
        return actions;
    }

    @Override
    public List<Action> getByRole(int roCode) {
         List<Action> actions = _session.createQuery("Select Action.* From Action, RoleAction where"
                 + " RoleAction.ActCode = Action.ActCode and RoleAction.RoCode = "+roCode).list();
        if (null == actions || actions.isEmpty()) {
            return null;
        }
        return actions;
    }

    @Override
    public int add(Action action) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(action);
            tx.commit();
            return action.getActCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Action action) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(action);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Action action) {
         try {
            Transaction tx = _session.beginTransaction();
            _session.delete(action);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int actCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Action where ActCode= " + actCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }
    
}
