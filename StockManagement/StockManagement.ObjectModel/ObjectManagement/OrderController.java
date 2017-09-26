/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IOrder;
import StockManagement.ObjectModel.Utilities.Endpoint;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mfaour
 */
public class OrderController implements IOrder {

    private SessionFactory _sessionFactory;
    private Session _session;

    public OrderController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    private TransactionType getTransactionType(int trCode) {
        List<TransactionType> types = _session.createQuery("From TransactionType where TrCode = " + trCode).list();
        if (null == types || types.isEmpty()) {
            return null;
        }
        return types.get(0);
    }

    private TransactionType getRouting(Endpoint source, Endpoint destination) {
        int trCode = 5;

        if (source == Endpoint.Stock && destination == Endpoint.Branch) {
            trCode = 1;
        }
        if (source == Endpoint.Branch && destination == Endpoint.Stock) {
            trCode = 2;
        }
        if (source == Endpoint.Branch && destination == Endpoint.Branch) {
            trCode = 3;
        }
        if (source == Endpoint.Branch && destination == Endpoint.Client) {
            trCode = 4;
        }
        //if ( source == Endpoint.Client && destination == Endpoint.Branch)
        return getTransactionType(trCode);
    }

    @Override
    public int add(Order order) {
        try {
            if (null == order || 
                    order.getCompany() == null ||
                    order.getUser() == null ) {
               return -1;
            }
            TransactionType trType = getRouting(order.getSource(),order.getDestination());
            if ( null == trType)
                return -1;
            order.setTransactionType(trType);
            Transaction tx = _session.beginTransaction();
            _session.save(order);
            tx.commit();
            return order.getPrCode();
        } catch (Exception e) {
            throw (e);
        } 
    }

    @Override
    public boolean update(Order order) {
         try {
            if (null == order) {
                return false;
            }
            TransactionType trType = getRouting(order.getSource(),order.getDestination());
            if ( null == trType)
                return false;
            order.setTransactionType(trType);
            Transaction tx = _session.beginTransaction();
            _session.update(order);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        } 
    }

    @Override
    public boolean delete(Order order) {
          try {
            if (null == order) {
                return false;
            }
            Transaction tx = _session.beginTransaction();
            _session.delete(order);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        } 
    }

    @Override
    public boolean delete(int ordCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Order where OrdCode= " + ordCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<Order> getBySource(OrderRoute orderRoute) {
        String query = "From Order where OrdSource = " + orderRoute.getCode() +""
                 + " and (TrCode = 2 or TrCode = 3 or TrCode =4) "; // branch
        if ( orderRoute.getRoute() == Endpoint.Stock)
            query = "From Order where OrdSource = " + orderRoute.getCode() +""
                 + " and (TrCode = 1 ) "; // stock
        else  if ( orderRoute.getRoute() == Endpoint.Client)
            query = "From Order where OrdSource = " + orderRoute.getCode() +""
                 + " and (TrCode = 5 ) "; // stock
            
         List<Order> orders = _session.createQuery(query).list();
        if (null == orders || orders.isEmpty()) {
            return null;
        }
        return orders;
    }

    @Override
    public List<Order> getByDestination(OrderRoute orderRoute) {
        String query = "From Order where OrdDestination = " + orderRoute.getCode() +""
                 + " and (TrCode = 1 or TrCode = 3 or TrCode =5) "; // branch
        if ( orderRoute.getRoute() == Endpoint.Stock)
            query = "From Order where OrdDestination = " + orderRoute.getCode() +""
                 + " and (TrCode = 2 ) "; // stock
        else  if ( orderRoute.getRoute() == Endpoint.Client)
            query = "From Order where OrdDestination = " + orderRoute.getCode() +""
                 + " and (TrCode = 4 ) "; // stock
        
        List<Order> orders = _session.createQuery(query).list();
        if (null == orders || orders.isEmpty()) {
            return null;
        }
        return orders;
    }

    @Override
    public List<Order> getByCompany(int compCode) {
          String query = "From Order where CompCode = " + compCode;
          
         List<Order> orders = _session.createQuery(query).list();
        if (null == orders || orders.isEmpty()) {
            return null;
        }
        return orders;
    }

}
