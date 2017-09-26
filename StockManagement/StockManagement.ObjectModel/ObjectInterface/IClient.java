/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ObjectInterface;

import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;

/**
 *
 * @author Chiraze Haidar
 */
public interface IClient 
{

    public List<Client> getAll();

    public Client get(int cltCode);

    public int add(Client user);

    public boolean update(Client user);

    public boolean delete(Client user);

    public boolean delete(int cltCode);

    public List<Order> getOrders(int cltCode);

    public int addOrder(Order order);

    public int addOrder(Client client, Order order);
    
    public boolean sendMessage(Client client);
    
    public boolean sendCatalog(Client client);
    
    public boolean sendMessage(int cltCode);
    
    public boolean sendCatalog(int cltCode);

}
