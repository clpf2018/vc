/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IClient;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.Client;
import StockManagement.ObjectModel.ValueObject.Order;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chiraze Haidar
 */
public class ClientController implements IClient 
{

    private final SessionFactory _sessionFactory;
    private final Session _session;

    public ClientController() 
    {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }
    
    @Override
    public List<Client> getAll() 
    {
        List<Client> clients = _session.createQuery("From Client").list();
        if (null == clients || clients.isEmpty()) 
        {
            return null;
        }
        return clients;
    }

    @Override
    public Client get(int cltCode) 
    {
        Object objClient = _session.get(Client.class, cltCode);
        if (null == objClient) 
        {
            return null;
        }
        return (Client) objClient;
    }

    @Override
    public int add(Client client) 
    {
        try 
        {
            Transaction tx = _session.beginTransaction();
            _session.save(client);
            tx.commit();
            return client.getCltCode();
        } 
        catch (Exception e) 
        {
            throw (e);
        } 
    }

    @Override
    public boolean update(Client client) 
    {
        try 
        {
            Transaction tx = _session.beginTransaction();
            _session.update(client);
            tx.commit();
            return true;
        } 
        catch (Exception e) 
        {
            throw (e);
        } 
    }

    @Override
    public boolean delete(Client client) 
    {
        try 
        {
            Transaction tx = _session.beginTransaction();
            _session.delete(client);
            tx.commit();
            return true;
        } 
        catch (Exception e) 
        {
            throw (e);
        } 
    }

    @Override
    public boolean delete(int cltCode) 
    {
        try 
        {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Client where CltCode= " + cltCode).executeUpdate();
            tx.commit();
            return true;
        } 
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Override
    public List<Order> getOrders(int cltCode) 
    {
       List<Order> orders = _session.createQuery("From Order where OrdDestination = "+cltCode).list();
        if (null == orders || orders.isEmpty()) 
        {
            return null;
        }
        return orders;
    }

    @Override
    public int addOrder(Order order) 
    {
        try 
        {
            if (  null == order ||order.getOrdDestination() <= 0 || 
                                  order.getOrdSource() <= 0)
            {
                return -1;
            }
            
            Transaction tx = _session.beginTransaction();
            _session.save(order);
            tx.commit();
            return order.getOrdCode();
        } 
        catch (Exception e) 
        {
            throw (e);
        } 
    }

    @Override
    public int addOrder(Client client, Order order) 
    {
        try 
        {
            if ( null == client || null == order)
            {
                return -1;
            }
            
            order.setOrdDestination(client.getCltCode());
            Transaction tx = _session.beginTransaction();
            _session.save(order);
            tx.commit();
            return order.getOrdCode();
        } 
        catch (Exception e) 
        {
            throw (e);
        } 
    }

    @Override
    public boolean sendMessage(Client client) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendCatalog(Client client) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendMessage(int cltCode) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendCatalog(int cltCode) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
